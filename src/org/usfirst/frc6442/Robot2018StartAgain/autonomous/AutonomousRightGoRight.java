package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousRightGoRight extends CommandGroup {

	public AutonomousRightGoRight() {
	
		addSequential(new DriveReverseTime(5));
		addSequential(new DriveStop(.5));
		addSequential(new TurnRightGyro(1.5));
		//addSequential(new DriveReverseTime(1.5));
		addSequential(new LaunchCubeLow());
		addSequential(new LaunchCubeLow());
		//addSequential(new DriveForwardTime(1));
		//addSequential(new TurnRightGyro(1.5));	
		
	} 
}
