package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousStanton extends CommandGroup {

	public AutonomousStanton() {
		addSequential(new TurnRightGyro(45));
		
			addSequential(new DriveStraightForwardTime(.5));
			addSequential(new DriveStraightReverseTime(.5));
			addSequential(new TurnLeftGyro(90));
			addSequential(new DriveStraightForwardTime(.5));
			addSequential(new DriveStraightReverseTime(.5));
			addSequential(new TurnRightGyro(90));
			addSequential(new DriveStraightForwardTime(.5));
			addSequential(new DriveStraightReverseTime(.5));
			addSequential(new TurnLeftGyro(90));
			addSequential(new DriveStraightForwardTime(.5));
			addSequential(new DriveStraightReverseTime(.5));
			addSequential(new TurnRightGyro(90));
		
	}
}