package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class TurnLeftGyro2 extends Command {
	
	public ADXRS450_Gyro gyro = RobotMap.gyro;
	public double turn;
	public double start;
	public double target;
	public int count;
	public int stableTarget = 10;
	public double approachVelocity = 20;
	public double fullVelocity = 90;
	public double fullSpeed = .5;
	public double speed = .4;
	public double approachSpeed = .3;
	public double approachDistance = 50; 
	public double error;
	public double distance;
	public double current;
	public double margin = 5;
	
	public TurnLeftGyro2(double turnDegrees) {
		super(turnDegrees); 
		requires(Robot.driveTrain);
		 turn = turnDegrees; //number to change with timing
	}
	
	protected void initialize() {
		start = gyro.getAngle();
		target = start - turn;
		count = 0;
	}
	protected void execute() {
		System.out.println("Left Turn");
		current = gyro.getAngle();
		double velocity = gyro.getRate();
		error = target - current;
		distance = Math.abs(error);
		double maxVelocity = fullVelocity;
		double speed = fullSpeed;
		
		if(distance < approachDistance) speed = approachSpeed;
		
		if(error>0) speed = -speed;
		Robot.driveTrain.set(-speed, speed);

	}
	protected boolean isFinished() {
		if(distance<target-margin && distance>target+margin)
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
