package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class TurnLeftGyro extends Command {
	
	public ADXRS450_Gyro gyro = RobotMap.gyro;
	public double turn;
	public double start;
	public double target;
	public int count;
	public int stableTarget = 10;
	public final double approachVelocity = 20;
	public final double fullVelocity = 90;
	public final double fullSpeed = .5;
	public final double approachSpeed = .35;
	public final double approachDistance = 50; 
	public double error;
	public double distance;
	public double current;
	public final double margin = 10;
	public boolean inMargin;
	
	public TurnLeftGyro(double turnDegrees) {
		requires(Robot.driveTrain);
		 turn = turnDegrees;
	}
	
	protected void initialize() {
		start = gyro.getAngle();
		target = start - turn;
		count = 0;
	}
	protected void execute() {
		current = gyro.getAngle();
		error = target - current;
		distance = Math.abs(error);
		double speed = fullSpeed;
		inMargin = distance<margin;
		
		if(distance < approachDistance) speed = approachSpeed;
		
		if(error>0) speed = -speed;
		if(inMargin) speed = 0;
		Robot.driveTrain.set(-speed, speed);

	}
	protected boolean isFinished() {
		if(inMargin)
			count++;
		else count = 0;
		return count > stableTarget;
	}
	
	protected void end() {
		 Robot.driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
