package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousCenterGoRight extends CommandGroup {

	public AutonomousCenterGoRight() {
		
		addSequential(new DriveForwardTime(1.5));
		addSequential(new TurnRightGyro(1.5));
		addSequential(new DriveForwardTime(2.5));
		addSequential(new TurnLeftGyro(1.5));
		addSequential(new DriveForwardTime(2.7));
		addSequential(new TurnRightGyro(1.5));
		addSequential(new DriveReverseTime(2));
		addSequential(new LaunchCubeLow());
		addSequential(new LaunchCubeLow());
		addSequential(new DriveForwardTime(1.5));
		addSequential(new TurnLeftGyro(1.5));
		
	} 		
}
