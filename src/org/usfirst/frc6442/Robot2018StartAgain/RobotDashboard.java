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
	
    public static SendableChooser<Robot.Side> startPosition;
    
    
	public static void initDashboard() {
		SmartDashboard.putData(Scheduler.getInstance());
		
    	SmartDashboard.putData(Robot.driveTrain);
    	SmartDashboard.putData(Robot.grabber);
    	SmartDashboard.putData(Robot.feeder);
    	SmartDashboard.putData(Robot.launcher);
    	SmartDashboard.putData(Robot.pneumatics);
    	
    	SmartDashboard.putData("Drive Command", new AnalogDrive());
    	SmartDashboard.putData("Feed", new Feed());
    	SmartDashboard.putData( "AutonomousCenterGoLeftSimple", new  AutonomousCenterGoLeftSimple());
    	SmartDashboard.putData("AutonomousCenterGoRightSimple", new  AutonomousCenterGoRightSimple());
    	SmartDashboard.putData(   "AutonomousLeftGoLeftSimple", new  AutonomousLeftGoLeftSimple());
    	SmartDashboard.putData(  "AutonomousLeftGoRightSimple", new  AutonomousLeftGoRightSimple());
    	SmartDashboard.putData(  "AutonomousRightGoLeftSimple", new  AutonomousRightGoLeftSimple());
    	SmartDashboard.putData( "AutonomousRightGoRightSimple", new  AutonomousRightGoRightSimple());
    	SmartDashboard.putData( "AutonomousCenterGoLeft", 		new  AutonomousCenterGoLeft());
    	SmartDashboard.putData("AutonomousCenterGoRight", 		new	 AutonomousCenterGoRight());
    	SmartDashboard.putData(      "AutonomousDisplay", 		new  AutonomousDisplay());
    	SmartDashboard.putData(   "AutonomousLeftGoLeft", 		new  AutonomousLeftGoLeft());
    	SmartDashboard.putData(  "AutonomousLeftGoRight", 		new  AutonomousLeftGoRight());
    	SmartDashboard.putData(  "AutonomousRightGoLeft", 		new  AutonomousRightGoLeft());
    	SmartDashboard.putData( "AutonomousRightGoRight", 		new  AutonomousRightGoRight());
    	SmartDashboard.putData(   "AutonomousLeftGoScaleLeft", 	new  AutonomousLeftGoScaleLeft());   
    	SmartDashboard.putData(   "AutonomousRightGoScaleRight", 	new  AutonomousRightGoScaleRight());
    	SmartDashboard.putData("DriveForwardTime(.2)", new DriveForwardTime(.2));
    	SmartDashboard.putData("DriveForwardTime(.4)", new DriveForwardTime(.4));
    	SmartDashboard.putData("DriveForwardTime(.6)", new DriveForwardTime(.6));
    	SmartDashboard.putData("DriveForwardTime(.8)", new DriveForwardTime(.8));
    	SmartDashboard.putData("DriveForwardTime(1)", new DriveForwardTime(1.0));
    	SmartDashboard.putData("DriveForwardTime(2)", new DriveForwardTime(2.0));
    	SmartDashboard.putData("DriveForwardTime(3)", new DriveForwardTime(3.0));
    	SmartDashboard.putData("DriveReverseTime(1)", new DriveReverseTime(1.0));
    	//SmartDashboard.putData("DriveStraightTime(.6)", new DriveStraightForwardTime(.6));
    	SmartDashboard.putData("DriveStraightForwardTime(3)", new DriveStraightForwardTime(3));
    	SmartDashboard.putData("DriveStraightReverseTime(3)", new DriveStraightReverseTime(3));
    	SmartDashboard.putData("DriveStop(2)", new DriveStop(2.0));
    	SmartDashboard.putData("ExchangeCube", new ExchangeCube());
    	SmartDashboard.putData("Grab", new AnalogGrab());
    	SmartDashboard.putData("LaunchDone(1)", new LaunchDone());
    	SmartDashboard.putData("LauncherDown", new LauncherDown());
    	SmartDashboard.putData("LauncherRaw", new LauncherRaw());
    	SmartDashboard.putData("LauncherSpinFast", new LauncherSpinFast());
    	SmartDashboard.putData("LauncherSpinSlow", new LauncherSpinSlow());
    	SmartDashboard.putData("LauncherUp", new LauncherUp());
    	SmartDashboard.putData("Secure", new Secure());
    	SmartDashboard.putData("SecureCube", new SecureCube());
    	SmartDashboard.putData("TurnLeft(90)", new TurnLeftGyro(90.0));
    	SmartDashboard.putData("TurnLeft2(90)", new TurnLeftGyro2(90.0));
    	SmartDashboard.putData("TurnLeft3(90)", new TurnLeftGyro3(90.0));
    	SmartDashboard.putData("TurnRight(90)", new TurnRightGyro(90.0));
    	
    	// Position chooser
    	startPosition = new SendableChooser<Robot.Side>(); 
    	startPosition.addObject("Left", Robot.Side.LEFT);
    	startPosition.addObject("Center", Robot.Side.CENTER);
    	startPosition.addObject("Right", Robot.Side.RIGHT);
    	
		SmartDashboard.putData("Start Position", startPosition);
    	
        
	}
	

}
