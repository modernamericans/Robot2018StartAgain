package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import org.usfirst.frc6442.Robot2018StartAgain.commands.DriveStop;
import org.usfirst.frc6442.Robot2018StartAgain.commands.LaunchCubeLow;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRightGoRightSimple extends CommandGroup {
	public AutonomousRightGoRightSimple() {
	
	addSequential(new DriveStraightReverseTime(4.1));
	addSequential(new DriveStop(.5));
	addSequential(new LaunchCubeLow());
	
	}

}
