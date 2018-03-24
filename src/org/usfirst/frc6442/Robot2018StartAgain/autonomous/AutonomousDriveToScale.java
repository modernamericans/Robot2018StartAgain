package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousDriveToScale extends CommandGroup {

	public AutonomousDriveToScale() {
	
		addSequential(new DriveForwardTime(.2));
		addSequential(new DriveStraightReverseTime(5));
	}
}