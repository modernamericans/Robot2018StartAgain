package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousLeftGoRight extends CommandGroup {

	public AutonomousLeftGoRight() {
	
		addSequential(new DriveForwardTime(2));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveForwardTime(4));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveForwardTime(2.1));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveForwardTime(1.5));
		addSequential(new LaunchCubeLow());
		addSequential(new LaunchCubeLow());
		
	} 
}
