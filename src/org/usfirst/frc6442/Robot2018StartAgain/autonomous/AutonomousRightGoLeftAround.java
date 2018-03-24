package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousRightGoLeftAround extends CommandGroup {

	public AutonomousRightGoLeftAround() {
	
		addSequential(new DriveStraightReverseTime(2));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveStraightReverseTime(.5));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveStraightReverseTime(3));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveStraightReverseTime(5));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveStraightReverseTime(1));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveStraightReverseTime(1.5));
		addSequential(new LaunchCubeLow());
		addSequential(new LaunchCubeLow());
		
	} 
}