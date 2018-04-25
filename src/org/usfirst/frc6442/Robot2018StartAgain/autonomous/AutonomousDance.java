package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousDance extends CommandGroup {

	public AutonomousDance() {
	
			addSequential(new TurnLeftGyro(90));
			addSequential(new TurnRightGyro(90));
			addSequential(new TurnLeftGyro(90));
			addSequential(new TurnRightGyro(90));
			addSequential(new DriveStraightForwardTime(.2));
			addSequential(new DriveStop(.1));
			addSequential(new DriveStraightForwardTime(.2));
			addSequential(new DriveStop(.1));
			addSequential(new DriveStraightForwardTime(.2));
			addSequential(new DriveStop(.1));
			addSequential(new DriveStraightReverseTime(.2));
			addSequential(new DriveStop(.1));
			addSequential(new DriveStraightReverseTime(.2));
			addSequential(new DriveStop(.1));
			addSequential(new DriveStraightReverseTime(.2));
			
		
		
		
		
	}
}