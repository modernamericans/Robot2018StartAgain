package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

public class LauncherDown extends Command {
	
	public LauncherDown() {
    requires(Robot.launcher);
 	
 }

	@Override
 protected void initialize() {
 
	 Robot.pneumatics.down();
 
 }

 @Override
 protected void execute() {
 	
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