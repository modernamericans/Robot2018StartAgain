package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

public class PneumaticsLeveler extends Command {
	
 public PneumaticsLeveler() {
 	
     requires(Robot.pneumatics);
 	
 }

 @Override
 protected void initialize() {
 }

 @Override
 protected void execute() {
 	
 	int mode = Robot.controllerMode;

 }
 
 public void upMode() {
	 
	 boolean upMode = Robot.oi.buttonY(1);
 
 }
 	
 public void downMode() {

	 boolean downMode = Robot.oi.buttonA(1);
 	
 	

 }
 
 @Override
 protected boolean isFinished() {
     return false;
 }

 @Override
 protected void end() {
 }

 @Override
 protected void interrupted() {
 }
}
