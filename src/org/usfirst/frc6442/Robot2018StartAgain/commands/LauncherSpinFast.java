package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class LauncherSpinFast extends Command {

	public LauncherSpinFast() {
     requires(Robot.launcher);
 }

 @Override
 protected void initialize() {

	 RobotMap.launcherLaunchStage2.set(1); 
 }
 

 @Override
 protected void execute() {
 	
// 	int mode = Robot.controllerMode;

 }
 
@Override
 protected boolean isFinished() {
     return true;
 }

 @Override
 protected void end() {
 }

 @Override
 protected void interrupted() {
 }
}