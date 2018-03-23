package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCenterGoLeftSimple extends CommandGroup {
	public AutonomousCenterGoLeftSimple() {
	
	addSequential(new DriveStraightReverseTime(1));
	addSequential(new DriveStop(.5));
	
	}

}
