package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

public class AnalogDrive extends Command {

    public AnalogDrive() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
    	double  leftValue = Robot.oi.driveLeft();
    	double rightValue = Robot.oi.driveRight();
    	
    	Robot.driveTrain.tankDrive(rightValue, leftValue);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	Robot.driveTrain.tankDrive(0, 0);
    }
    

    @Override
    protected void interrupted() {
    	end();
    }
}
