package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousDisplay extends CommandGroup {

	public AutonomousDisplay() {
		
			addSequential(new DriveStraightForwardTime(1));
			addSequential(new DriveStop(1));
			addSequential(new TurnRightGyro(90));
			addSequential(new DriveStop(1));
			addSequential(new DriveStraightForwardTime(.5));
			addSequential(new DriveStop(1));
			addSequential(new TurnLeftGyro(90));
			addSequential(new DriveStop(1));
			addSequential(new DriveStraightReverseTime(1));
			addSequential(new DriveStop(1));
			addSequential(new TurnRightGyro(90));
			addSequential(new DriveStop(1));
			addSequential(new DriveStraightReverseTime(.5));
			addSequential(new DriveStop(1));
			addSequential(new TurnLeftGyro(90));
	
	} 
}
