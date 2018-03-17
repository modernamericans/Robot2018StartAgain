package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class TurnLeftGyro extends Command {
	
	public double turn;
	public double start;
	public double target;
	public int tic;
	public boolean alternate;
	
	public TurnLeftGyro(double turnDegrees) {
		super(turnDegrees);
		 requires(Robot.driveTrain);
		 turn = turnDegrees; //number to change with timing
	}
	
	protected void initialize() {
		start = RobotMap.gyro.getAngle();
		target = start - turn; 
		tic = 0;
	}
	protected void execute() {
		System.out.println("Left Turn");
		tic++;
		double current = RobotMap.gyro.getAngle();
		double error = target - current;
		double distance = Math.abs(error);
		double speed = .5;
		//if(distance < 50) speed = .3;
		//if(distance < 30) speed = .1;
		//if(distance < 10) speed = .05;
		if(distance < 20) {
			if(tic %  20 == 0)
				alternate = !alternate;
			if(alternate) Robot.driveTrain.set(-speed, speed);
			else Robot.driveTrain.stop();
		}
		else Robot.driveTrain.set(-speed, speed);

	}
	protected boolean isFinished() {
		 double current = RobotMap.gyro.getAngle();
	   return current < target;
	}
	
	protected void end() {
		 Robot.driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
