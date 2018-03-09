package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousDisplay extends CommandGroup {

	public AutonomousDisplay() {
		
		addSequential(new DriveForwardTime(3));
		addSequential(new DriveStop(1));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveStop(1));
		addSequential(new DriveForwardTime(.5));
		addSequential(new DriveStop(1));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveStop(1));
		addSequential(new DriveReverseTime(3));
		addSequential(new DriveStop(1));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveStop(1));
		addSequential(new DriveReverseTime(.5));
		addSequential(new DriveStop(1));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveForwardTime(1.5));
		addSequential(new DriveStop(1));
		addSequential(new DriveReverseTime(1.5));
	} 
}
