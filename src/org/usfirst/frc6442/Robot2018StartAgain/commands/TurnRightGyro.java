package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class TurnRightGyro extends Command {
	
	public double turn;
	public double start;
	public double target;
	public double margin;
	
	public TurnRightGyro(double turnDegrees) {
		 requires(Robot.driveTrain);
		 turn = turnDegrees; //number to change with timing
	}
	
	protected void initialize() {
		start = RobotMap.gyro.getAngle();
		target = start + turn; 
		Robot.driveTrain.rightTurn();
		margin = Robot.values.gyroTurnErrorMargin;
	}
	
	protected boolean isFinished() {
	   double angleNow = RobotMap.gyro.getAngle();
	   return angleNow > target - margin && angleNow < target + margin;
	}
	
	protected void end() {
		 Robot.driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
