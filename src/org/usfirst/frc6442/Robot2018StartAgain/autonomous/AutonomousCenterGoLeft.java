package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousCenterGoLeft extends CommandGroup {

	public AutonomousCenterGoLeft() {
		
		addSequential(new DriveForwardTime(1));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveForwardTime(1));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveForwardTime(1));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveForwardTime(1));
		addSequential(new LaunchCubeLow());
		addSequential(new DriveReverseTime(1));
		addSequential(new TurnLeftGyro(90));
	} 
}
