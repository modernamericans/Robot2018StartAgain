package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

public class AnalogDrive extends Command {
	
	protected DriveTrain driveTrain = Robot.driveTrain;
	
    public AnalogDrive() {
        requires(driveTrain);
    }

    protected void initialize() {

    }

    protected void execute() {
    	double  leftValue = Robot.oi.getDriveLeft();
    	double rightValue = Robot.oi.getDriveRight();
    	
    	driveTrain.tankDrive(rightValue, leftValue);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	driveTrain.tankDrive(0, 0);
    }
    
    protected void interrupted() {
    	end();
    }
}
