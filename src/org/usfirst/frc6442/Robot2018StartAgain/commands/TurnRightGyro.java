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
		super(turnDegrees); 
		requires(Robot.driveTrain);
		 turn = turnDegrees; //number to change with timing
	}
	
	protected void initialize() {
		start = RobotMap.gyro.getAngle();
		target = start + turn; 
		Robot.driveTrain.set(-.5,.5);
		margin = 5;
	}
	protected void execute() {
		double current = RobotMap.gyro.getAngle();
		double error = target - currrent;
		double distance = Math.abs(error);
		double speed = .5;
		if(distance < 50) speed = .4;
		if(distance < 30) speed = .2;
		if(distance < 10) speed = .1;
		Robot.driveTrain.set(speed, -speed);
	}

		protected boolean isFinished() {
			double current = RobotMap.gyro.getAngle();
			return current > target;
	 }
	
	protected void end() {
		 Robot.driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
