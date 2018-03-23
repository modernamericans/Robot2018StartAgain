package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRightGoLeftSimple extends CommandGroup {
	public AutonomousRightGoLeftSimple() {
	
	addSequential(new DriveReverseTime(4.1));
	addSequential(new DriveStop(.5));
	
	}

}
