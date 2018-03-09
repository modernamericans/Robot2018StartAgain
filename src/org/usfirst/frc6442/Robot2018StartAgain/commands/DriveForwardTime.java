package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.DriveTrain;

public class DriveForwardTime extends TimedCommand {
	
	protected DriveTrain driveTrain = Robot.driveTrain;
	
	public DriveForwardTime(double time) {
		super(time);
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		driveTrain.set(0.5);
	}

	protected void end() {
		driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
