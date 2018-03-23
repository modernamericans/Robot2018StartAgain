package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import org.usfirst.frc6442.Robot2018StartAgain.autonomous.*;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;
import edu.wpi.first.wpilibj.Preferences;

public class Robot extends TimedRobot {

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
    public enum Strategy{ SWITCH,SCALE }
    public static Strategy strategy; 
    public static Style style;
    public static Side startSide;
    public static Side switchSide;
    public static Side scaleSide;

    @Override
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
    	if(sidePrefs.equals("L")) startSide = Side.LEFT;
    	if(sidePrefs.equals("C")) startSide = Side.CENTER;
    	if(sidePrefs.equals("R")) startSide = Side.RIGHT; 
    	if(stylePrefs.equals("A")) style = Style.ADVANCED;
    	if(stylePrefs.equals("S")) style = Style.SIMPLE;
    	if(strategyPrefs.equals("F")) strategy = Strategy.SCALE;
    	if(strategyPrefs.equals("N")) strategy = Strategy.SWITCH;
    }
    public void autonomousInit() {
    	getGameData();
    	setStartingPositon();
    	setAutonomousCommand();
    	
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    	else (new DriveStraightReverseTime(5)).start();
    }    
    public void getGameData() {
    	gameMessage = DriverStation.getInstance().getGameSpecificMessage();
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
			}
		}
    	if(switchSide == Side.RIGHT) {
			if(startSide == Side.LEFT) {
				autonomousCommand = style == Style.ADVANCED ? new AutonomousLeftGoRight()
															: new AutonomousLeftGoRightSimple();
			}
			if(startSide == Side.CENTER) {
				autonomousCommand = style == Style.ADVANCED ? new AutonomousCenterGoRight()
															: new AutonomousCenterGoRightSimple();
			}
			if(startSide == Side.RIGHT) {
				autonomousCommand = style == Style.ADVANCED ? new AutonomousRightGoRight()
															: new AutonomousRightGoRightSimple();			}
			
    	}
	}
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
    	if (autonomousCommand != null) autonomousCommand.cancel();       
    }

    @Override
    public void teleopPeriodic() {    
    	Robot.oi.Update();
    	Scheduler.getInstance().run();
    }
}
