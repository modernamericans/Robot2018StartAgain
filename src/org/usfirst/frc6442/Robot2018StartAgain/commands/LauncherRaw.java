
//RobotBuilder Version: 2.0
//
//This file was generated by RobotBuilder. It contains sections of
//code that are automatically generated and assigned by robotbuilder.
//These sections will be updated in the future when you export to
//Java from RobotBuilder. Do not put any code or make any change in
//the blocks indicating autogenerated code or it will be lost on an
//update. Deleting the comments indicating the section will prevent
//it from being updated in the future.


package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;




/**
*
*/
public class LauncherRaw extends Command {
	
	public Timer timer;
	private final SpeedController feeder = RobotMap.launcherLaunchStage1;
	private final SpeedController launcher = RobotMap.launcherLaunchStage2;
	private final DoubleSolenoid doubleSolenoid = RobotMap.pneumaticsDoubleSolenoid;
	
	
	
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
public LauncherRaw() {
	
	

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
   // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

   // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
   // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
   requires(Robot.launcher);
   requires(Robot.pneumatics);

	
}

// Called just before this Command runs the first time
@Override
protected void initialize() {
}

// Called repeatedly when this Command is scheduled to run
@Override
protected void execute() {
	
//    boolean isAPressed = Robot.oi.xbox.getAButton();
//    boolean isYPressed = Robot.oi.xbox.getYButton();
//    
//    if(isAPressed) {
//
//    	timer.reset();
//    	timer.start();
//    	doubleSolenoid.set(DoubleSolenoid.Value.kForward);
//    	launcher.set(.5);
//    	
//    	while(timer.get() < 1);
//    	feeder.set(1);
//    	
//    	while(timer.get() < 2);
//    	launcher.set(0);
//    	feeder.set(0);
//    }
//    if(isYPressed) {
//
//    	timer.reset();
//    	timer.start();
//    	doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
//    	launcher.set(1);
//    	
//    	while(timer.get() < 1);
//    	feeder.set(1);
//    	
//    	while(timer.get() < 2);
//    	launcher.set(0);
//    	feeder.set(0);
//    }
}


// Make this return true when this Command no longer needs to run execute()
@Override
protected boolean isFinished() {
   return false;
}

// Called once after isFinished returns true
@Override
protected void end() {
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
@Override
protected void interrupted() {
}
}