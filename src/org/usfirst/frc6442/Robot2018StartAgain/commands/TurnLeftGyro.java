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
	public double approachVelocity = 20;
	public double fullVelocity = 90;
	public double speed = .5;
	public double approachDistance = 50; 
	public double error;
	public double distance;
	public double current;
	public double margin = 5;
	
	public TurnLeftGyro(double turnDegrees) {
		super(turnDegrees); 
		requires(Robot.driveTrain);
		 turn = turnDegrees; //number to change with timing
	}
	
	protected void initialize() {
		start = gyro.getAngle();
		target = start + turn; 
	}
	protected void execute() {
		System.out.println("Right Turn");
		current = gyro.getAngle();
		double velocity = gyro.getRate();
		error = target - current;
		distance = Math.abs(error);
		double maxVelocity = fullVelocity;
		if(error>0) speed = -speed;
		
		if(distance < approachDistance) maxVelocity = approachVelocity;
		if(velocity > maxVelocity) speed = 0;
		
		Robot.driveTrain.set(-speed, speed);

	}
	protected boolean isFinished() {
		if(distance<margin)
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
