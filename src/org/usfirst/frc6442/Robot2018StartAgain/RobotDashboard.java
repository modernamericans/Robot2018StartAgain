package org.usfirst.frc6442.Robot2018StartAgain;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc6442.Robot2018StartAgain.autonomous.*;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotDashboard {
	
    public static SendableChooser<Command> teleopChooser;
    
    public static SendableChooser<Robot.StartPosition> startPosition;
    
    public static SendableChooser<Command> chooserLLL;
    public static SendableChooser<Command> chooserLRL;
    public static SendableChooser<Command> chooserRLR;
    public static SendableChooser<Command> chooserRRR;
    
	public static void initDashboard() {
		
		SmartDashboard.putData(Scheduler.getInstance());
		
    	SmartDashboard.putData(Robot.driveTrain);
    	SmartDashboard.putData(Robot.distributionPanel);
    	SmartDashboard.putData(Robot.distanceSensor);
    	SmartDashboard.putData(Robot.grabber);
    	SmartDashboard.putData(Robot.launcher);
    	SmartDashboard.putData(Robot.pneumatics);
    	
    	SmartDashboard.putData("Drive Command", new AnalogDrive());
    	SmartDashboard.putData("Autonomous Command",new AutonomousCommand());
    	SmartDashboard.putData("Feed", new Feed());
    	SmartDashboard.putData("AutonomousCenterGoLeft", new AutonomousCenterGoLeft());
    	SmartDashboard.putData("AutonomousCenterGoRight", new AutonomousCenterGoRight());
    	SmartDashboard.putData("AutonomousDisplay", new AutonomousDisplay());
    	SmartDashboard.putData("AutonomousLeftGoLeft", new AutonomousLeftGoLeft());
    	SmartDashboard.putData("AutonomousLeftGoRight", new AutonomousLeftGoRight());
    	SmartDashboard.putData("AutonomousRightGoLeft", new AutonomousRightGoLeft());
    	SmartDashboard.putData("AutonomousRightGoRight", new AutonomousRightGoRight());
    	SmartDashboard.putData("DriveForwardTime(1)", new DriveForwardTime(1.0));
    	SmartDashboard.putData("DriveReverseTime(1)", new DriveReverseTime(1.0));
    	SmartDashboard.putData("DriveStop(2)", new DriveStop(2.0));
    	SmartDashboard.putData("Exchange", new ExchangeTime(1));
    	SmartDashboard.putData("ExchangeCube", new ExchangeCube());
    	SmartDashboard.putData("Grab", new AnalogGrab());
    	SmartDashboard.putData("LaunchDone(1)", new LaunchDone());
    	SmartDashboard.putData("LauncherDown", new LauncherDown());
    	SmartDashboard.putData("LauncherRaw", new LauncherRaw());
    	SmartDashboard.putData("LauncherSpinFast", new LauncherSpinFast());
    	SmartDashboard.putData("LauncherSpinSlow", new LauncherSpinSlow());
    	SmartDashboard.putData("LauncherUp", new LauncherUp());
    	SmartDashboard.putData("Push", new PushTime(1));
    	SmartDashboard.putData("Secure", new Secure());
    	SmartDashboard.putData("SecureCube", new SecureCube());
    	SmartDashboard.putData("TurnLeft(90)", new TurnLeftGyro(90.0));
    	SmartDashboard.putData("TurnRight(90)", new TurnRightGyro(90.0));
    	
    	// Position chooser
    	startPosition = new SendableChooser<Robot.StartPosition>(); 
    	startPosition.addObject("Left", Robot.StartPosition.LEFT);
    	startPosition.addObject("Left", Robot.StartPosition.CENTER);
    	startPosition.addObject("Left", Robot.StartPosition.RIGHT);
    	
        // Teleop chooser
    	teleopChooser = new SendableChooser<Command>();
		teleopChooser.addObject("Arcade", new AnalogDrive());
		SmartDashboard.putData("Start teleop with:", teleopChooser);
    	
    	// Autonomous choosers
    	chooserLLL = new SendableChooser<Command>(); 
    	chooserLRL = new SendableChooser<Command>(); 
    	chooserRLR = new SendableChooser<Command>(); 
    	chooserRRR = new SendableChooser<Command>(); 
    	
    	List<SendableChooser<Command>> choosers = Arrays.asList(chooserLLL, chooserLRL, chooserRLR, chooserRRR);
    	
        List<Command> autoCommands = Arrays.asList(
        		new AutonomousCommand()
        );
        for (SendableChooser<Command> chooser : choosers) {
	        for (Command command : autoCommands) {
	        	chooser.addObject(command.getClass().getName(), command);
	        }
	        chooser.addDefault("Autonomous Command", Robot.autoDefaultCommand);
        }
        
        SmartDashboard.putData("Auto if LLL", chooserLLL);
        SmartDashboard.putData("Auto if LRL", chooserLRL);
        SmartDashboard.putData("Auto if RLR", chooserRLR);
        SmartDashboard.putData("Auto if RRR", chooserRRR);
        
	}
	
	public static void initLiveWindow() {

		LiveWindow.add(RobotMap.pneumaticsCompressor);
		LiveWindow.add(RobotMap.pneumaticsDoubleSolenoid);
		
		LiveWindow.add((Spark) RobotMap.driveCtrlRight);
	    LiveWindow.add((Spark) RobotMap.driveCtrlLeft); 
	    LiveWindow.add(        RobotMap.driveCtrlBoth);
		                       
		LiveWindow.add((Spark) RobotMap.feedCtrl);
		LiveWindow.add((Spark) RobotMap.launchCtrl);
		                       
		LiveWindow.add((Spark) RobotMap.grabCtrlRight);
		LiveWindow.add((Spark) RobotMap.grabCtrlLeft);
		LiveWindow.add(        RobotMap.grabCtrlBoth);
		
		//LiveWindow.add(RobotMap.accel);
		LiveWindow.add(RobotMap.gyro);
		LiveWindow.add(RobotMap.distSensor1);
		LiveWindow.add(RobotMap.distSensor2);
		
		LiveWindow.add(RobotMap.powerDist);
	}
}
