package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import org.usfirst.frc6442.Robot2018StartAgain.autonomous.*;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;
import edu.wpi.first.wpilibj.Preferences;

public class Robot extends TimedRobot/*hi*/ {

    public static OI oi;
    public static Pneumatics pneumatics;
    public static DriveTrain driveTrain;
    public static Launcher launcher;
    public static Feeder feeder;
    public static Grabber grabber;
    public static Bar bar;
    public static DigitalOutput lightSwitch;
    
    public static String gameMessage;
    public static Command autonomousCommand;
    public enum Side{ LEFT,CENTER,RIGHT }
    public enum Style{ ADVANCED, SIMPLE }
    public enum Strategy{ SWITCH,SCALE,FORWARD }
    public static Strategy strategy; 
    public static Style style;
    public static Side startSide;
    public static Side switchSide;
    public static Side scaleSide;

    public void robotInit() {
        RobotMap.init();
        pneumatics = new Pneumatics();
        driveTrain = new DriveTrain();
        launcher = new Launcher();
        grabber = new Grabber();
        feeder = new Feeder();
        bar = new Bar();
        lightSwitch = new DigitalOutput(1);
        CameraServer.getInstance().startAutomaticCapture();
        pneumatics.up();

        oi = new OI();

        RobotDashboard.initDashboard();
        CameraServer.getInstance().startAutomaticCapture();
        
    }
    public void setStartingPositon() {
    	Preferences prefs = Preferences.getInstance();
    	if(!prefs.containsKey("start")) prefs.putString("start", "");
    	String sidePrefs = prefs.getString("start", "");
    	if(!prefs.containsKey("style")) prefs.putString("style", "");
    	String stylePrefs = prefs.getString("style", "");
    	if(!prefs.containsKey("strategy")) prefs.putString("strategy", "");
    	String strategyPrefs = prefs.getString("strategy", "");
    	if(sidePrefs.equals("Left")) startSide = Side.LEFT;
    	if(sidePrefs.equals("Center")) startSide = Side.CENTER;
    	if(sidePrefs.equals("Right")) startSide = Side.RIGHT; 
    	if(stylePrefs.equals("Advanced")) style = Style.ADVANCED;
    	if(stylePrefs.equals("Simple")) style = Style.SIMPLE;
    	if(strategyPrefs.equals("Scale")) strategy = Strategy.SCALE;
    	if(strategyPrefs.equals("Switch")) strategy = Strategy.SWITCH;
		if(strategyPrefs.equals("Forward")) strategy = Strategy.FORWARD;
    }
    public void autonomousInit() {
    	getGameData();
    	setStartingPositon();
    	setAutonomousCommand();
    	
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    	else (new DriveStraightReverseTime(5)).start();
    }    
    public void getGameData() {
    	gameMessage = DriverStation.getInstance().getGameSpecificMessage();//Something is up//
    	if(gameMessage.charAt(0) == 'L' ) {	
    		switchSide = Side.LEFT;	
    		System.out.println(switchSide);		
    	} 
    	else if(gameMessage.charAt(0) == 'R') {
    		switchSide = Side.RIGHT;
    	}
    	if(gameMessage.charAt(1) == 'L') scaleSide = Side.LEFT;
    	else if(gameMessage.charAt(1) == 'R') scaleSide = Side.RIGHT;
        
    }
	public void setAutonomousCommand() {
		
		if(strategy == Strategy.SWITCH) {
			
			if(switchSide == Side.LEFT){
				if(startSide == Side.LEFT) {
					autonomousCommand = style == Style.ADVANCED ? new AutonomousLeftGoLeft()
															    : new AutonomousLeftGoLeftSimple();
				}
				if(startSide == Side.CENTER) {
					autonomousCommand = style == Style.ADVANCED ? new AutonomousCenterGoLeft()
																: new AutonomousCenterGoLeftSimple();
				}
				if(startSide == Side.RIGHT) {
					autonomousCommand = style == Style.ADVANCED ? new AutonomousRightGoLeft()
																: new AutonomousRightGoLeftSimple();
					if(scaleSide == Side.RIGHT && style == Style.SIMPLE)
						autonomousCommand = new AutonomousRightGoScaleRight();
				}
			}
			if(switchSide == Side.RIGHT) {
				if(startSide == Side.LEFT) {
					autonomousCommand = style == Style.ADVANCED ? new AutonomousLeftGoRight()
																: new AutonomousLeftGoRightSimple();
					if(scaleSide == Side.LEFT && style == Style.SIMPLE)
						autonomousCommand = new AutonomousLeftGoScaleLeft();
				}
				if(startSide == Side.CENTER) {
					autonomousCommand = style == Style.ADVANCED ? new AutonomousCenterGoRight()
																: new AutonomousCenterGoRightSimple();
				}
				if(startSide == Side.RIGHT) {
					autonomousCommand = style == Style.ADVANCED ? new AutonomousRightGoRight()
																: new AutonomousRightGoRightSimple();
					}
			}
    	}
		else if(strategy == Strategy.SCALE){
			if(scaleSide == Side.LEFT && startSide == Side.LEFT) 
				autonomousCommand = new AutonomousLeftGoScaleLeft(); 
			if(scaleSide == Side.RIGHT && startSide == Side.RIGHT) 
				autonomousCommand = new AutonomousRightGoScaleRight(); 
			
		}
		else if(strategy == Strategy.FORWARD){autonomousCommand = new AutonomousDriveToScale();}
	}
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	if (autonomousCommand != null) autonomousCommand.cancel();       
    }

    public void teleopPeriodic() {    
    	Robot.oi.Update();
    	Scheduler.getInstance().run();
    }
}
