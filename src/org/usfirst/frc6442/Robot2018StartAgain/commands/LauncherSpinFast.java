
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
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

/**
*
*/
public class LauncherSpinFast extends Command {
	

	
 // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

 // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

 // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
 public LauncherSpinFast() {
 	

 // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
     // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

     // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
     // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

 // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
     requires(Robot.launcher);

 	
 }

 // Called just before this Command runs the first time
 @Override
 protected void initialize() {
 }

 // Called repeatedly when this Command is scheduled to run
 @Override
 protected void execute() {
 	
 	int mode = Robot.controllerMode;

 	
 	
// 	if(mode == Robot.tankMode || mode == Robot.arcadeMode) { 
// 	double triggerLeft = Robot.oi.joystick.getRawAxis(2);
// 	double triggerRight = Robot.oi.joystick.getRawAxis(3);
 	double triggerLeft = Robot.oi.leftTrigger(1);
 	double triggerRight = Robot.oi.rightTrigger(1);
 	double speed = triggerRight-triggerLeft;
 	Robot.grabber.grab(speed);
 	
 	
// 	}
// }else if(mode == 1){
// 		double joyLeft = Robot.oi.joystick.getRawAxis(1);
//     	double joyRight = Robot.oi.joystick.getRawAxis(5);
//     	Robot.grabber.grabAD(joyRight, joyLeft);
//     	
// 	}
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