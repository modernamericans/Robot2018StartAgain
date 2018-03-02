package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousLeftGoLeft extends CommandGroup {

	public AutonomousLeftGoLeft() {

		addSequential(new DriveForwardTime(1));
		addSequential(new DriveStop(1));
		addSequential(new TurnRightGyro(90));//this is in degrees, not in terms of time
		addSequential(new DriveForwardTime(1));
		//addSequential(new LaunchLow);
		addSequential(new DriveReverseTime(1));
		addSequential(new TurnLeftGyro(90));	
	} 
}
