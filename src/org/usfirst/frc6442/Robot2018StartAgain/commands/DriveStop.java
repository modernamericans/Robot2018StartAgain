package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class DriveStop extends InstantCommand {
	protected DriveTrain driveTrain = Robot.driveTrain;
	
	public DriveStop(double timetoDrive) {
		 requires(Robot.driveTrain);
	}

	protected void initialize() {
		 Robot.driveTrain.stop();
	}
}