package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousCenterGoLeft extends CommandGroup {

	public AutonomousCenterGoLeft() {
		
		addSequential(new DriveStraightReverseTime(2));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveStraightReverseTime(2.5));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveStraightReverseTime(2.2));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveStraightReverseTime(2));
		addSequential(new LaunchCubeLow());
		addSequential(new LaunchCubeLow());
	} 
}
