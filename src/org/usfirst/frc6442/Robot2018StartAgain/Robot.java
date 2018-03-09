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
        CameraServer.getInstance().startAutomaticCapture();

        oi = new OI();
      }
    public void autonomousInit() {
    	getGameData();
    	setAutonomousCommand();
    	if (autonomousCommand != null) autonomousCommand.start();
    }    
    public void getGameData() {
    	gameMessage = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameMessage.charAt(0) == 'L' ) {	
    		switchSide = Side.LEFT;	
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
			}
			if(startSide == Side.RIGHT) {
				autonomousCommand = new AutonomousRightGoLeft();
			}
		}
    	if(switchSide == Side.RIGHT) {
			if(startSide == Side.LEFT) {
				autonomousCommand = new AutonomousRighttGoRight();
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
