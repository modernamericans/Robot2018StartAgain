package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRightGoLeftSimple extends CommandGroup {
	public AutonomousRightGoLeftSimple() {
	
	addSequential(new DriveReverseTime(1));
	addSequential(new TurnLeftGyro(90));
	addSequential(new DriveReverseTime(3));
	addSequential(new TurnRightGyro(90));
	addSequential(new DriveReverseTime(2));
	addSequential(new DriveStop(.5));
	addSequential(new LaunchCubeLow());
	
	}

}
