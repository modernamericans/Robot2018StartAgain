package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class TurnLeftGyro extends Command {
	
	public double turn;
	public double start;
	public double target;
	public double margin;
	public int steadyCount;
	public int settleTarget;
	
	public TurnLeftGyro(double turnDegrees) {
		 requires(Robot.driveTrain);
		 turn = turnDegrees; //number to change with timing
		 kP = 0.004;
		 settleTarget = 3;
	}
	
	protected void initialize() {
		steadyCount = 0;
		start = RobotMap.gyro.getAngle();
		target = start - turn;
		margin = Robot.values.gyroTurnErrorMargin;
	}

	protected void execute(){
		double angleNow = RobotMap.gyro.getAngle();
		error = angleNow - target;
		double value = error * kP;
		double signal = Math.max(-1, Math.min(1,value));
		if (Math.abs(signal) < Robot.values.driveMinimumSignal) {
			signal = Robot.values.driveMinimumSignal * Math.signum(signal);
		}
		Robot.driveTrain.leftTurn( signal );
	}

	
	protected boolean isFinished() {
		 double angleNow = RobotMap.gyro.getAngle();
		 boolean inMargin = angleNow > target - margin && angleNow < target + margin;
		 
		 // only finish if we remain in the margin (prevent premature exit if we are flying past it to prevent overshooting)
		 if (inMargin) steadyCount++;
		 else steadyCount = 0;

		 return steadyCount > settleTarget;
	}
	
	protected void end() {
		 Robot.driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
