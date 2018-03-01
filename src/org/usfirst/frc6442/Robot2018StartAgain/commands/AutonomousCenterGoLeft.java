package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class AutonomousCenterGoLeft extends CommandGroup {

	public AutonomousCenterGoLeft() {
		
		addSequential(new DriveForwardTime(1));
		addSequential(new TurnLeft(90));
		addSequential(new DriveForwardTime(1));
		addSequential(new TurnRight(90));
		addSequential(new DriveForwardTime(1));
		addSequential(new TurnRight(90));
		addSequential(new DriveForwardTime(1));
		//addSequential(new Launch Low);
		addSequential(new DriveReverseTime(1));
		addSequential(new TurnLeft(90));
	} 
}
