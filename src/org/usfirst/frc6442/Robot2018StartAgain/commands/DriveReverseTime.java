package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.DriveTrain;

public class DriveReverseTime extends TimedCommand {
	
	protected DriveTrain driveTrain = Robot.driveTrain;
	
	public DriveReverseTime(double time) {
		super(time);
		requires(driveTrain);
	}

	protected void initialize() {
		 driveTrain.reverse();
	}

	protected void end() {
		 driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
