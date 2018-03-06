
package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class LauncherSpinSlow extends Command {
	public LauncherSpinSlow() {
     requires(Robot.launcher);
 }

 @Override
 protected void initialize() {
 
	 RobotMap.launcherLaunchStage2.set(0.5);
 
 }

 @Override
 protected void execute() {
 	
 	
	 
	 
	 
	 //int mode = Robot.controllerMode;

 	
 	

// 	double triggerLeft = Robot.oi.leftTrigger(1);
// 	double triggerRight = Robot.oi.rightTrigger(1);
// 	double speed = triggerRight-triggerLeft;
// 	Robot.grabber.grab(speed);
 	
 	
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