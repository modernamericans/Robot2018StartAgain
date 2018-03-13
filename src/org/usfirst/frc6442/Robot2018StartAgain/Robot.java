package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.CameraServer;
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
    
    public static String gameMessage;
    public static Command autonomousCommand;
    public enum Side{ LEFT,CENTER,RIGHT }
    public static Side startSide;
    public static Side switchSide;

    @Override
    public void robotInit() {
        RobotMap.init();
        pneumatics = new Pneumatics();
        driveTrain = new DriveTrain();
        launcher = new Launcher();
        grabber = new Grabber();
        feeder = new Feeder();
        CameraServer.getInstance().startAutomaticCapture();

        oi = new OI();

        RobotDashboard.initDashboard();
        CameraServer.getInstance().startAutomaticCapture();
        
    }
    public void setStartingPositon() {
    	//startSide = Side.CENTER;
    	//RobotDashboard.startPosition.getSelected();
    	Preferences prefs = Preferences.getInstance();
    	if(!prefs.containsKey("start")) prefs.putString("start", "");
    	String sidePrefs = prefs.getString("start", "");
    	if(sidePrefs.equals("L")) startSide = Side.LEFT;
    	if(sidePrefs.equals("C")) startSide = Side.CENTER;
    	if(sidePrefs.equals("R")) startSide = Side.RIGHT; 
    	System.out.println(sidePrefs);
    	System.out.println(startSide);
    }
    public void autonomousInit() {
    	getGameData();
    	setStartingPositon();
    	setAutonomousCommand();
    	//ok time to test it I guess?
    	//time to test
    	//oh got a minute, we just need to add drive mode swithing, it's like 2 lines of code
    	//In analogDrive?
    	//oi
    	
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    	else (new DriveForwardTime(5)).start();
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
        
    }
	public void setAutonomousCommand() {
		if(switchSide == Side.LEFT){
			if(startSide == Side.LEFT) {
				autonomousCommand = new AutonomousLeftGoLeft();
			}
			if(startSide == Side.CENTER) {
				autonomousCommand = new AutonomousCenterGoLeft();
				System.out.println("Starting from Center");
				System.out.println(autonomousCommand);
			}
			if(startSide == Side.RIGHT) {
				autonomousCommand = new AutonomousRightGoLeft();
			}
		}
    	if(switchSide == Side.RIGHT) {
			if(startSide == Side.LEFT) {
				autonomousCommand = new AutonomousRightGoRight();
			}
			if(startSide == Side.CENTER) {
				autonomousCommand = new AutonomousCenterGoRight();
			}
			if(startSide == Side.RIGHT) {
				autonomousCommand = new AutonomousRightGoRight();
			}
			
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
