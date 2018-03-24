package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousLeftGoLeft extends CommandGroup {

	public AutonomousLeftGoLeft() {

		addSequential(new DriveStraightReverseTime(4.1));
		addSequential(new DriveStop(.5));
		addSequential(new LaunchCubeLow());
		addSequential(new LaunchCubeLow());	
	} 
}
