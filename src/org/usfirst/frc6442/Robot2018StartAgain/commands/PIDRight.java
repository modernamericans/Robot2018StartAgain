package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class PIDRight extends Command {
	public int count = 0;
	public int countWanted = 10;
	public double angle;
	
	public PIDRight(double turnDegrees) {
		angle = turnDegrees;
		requires(Robot.driveTrain);
	}
	
	protected void initialize() {
	//	Robot.driveTrain.driveTurnLeft(angle);
		count = 0;
	}
	protected void execute() {
//		if(Robot.driveTrain.onTarget()) {
//			count++;
//		}
//		else {
//			count = 0;
//		}
	}
	protected boolean isFinished() {
		return 	count >= countWanted;
	}
	
	protected void end() {
		 Robot.driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}