package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLeftGoScaleLeft extends CommandGroup {
	
	public AutonomousLeftGoScaleLeft() {
		//Gets around switch
		addSequential(new DriveForwardTime(1));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveForwardTime(1));
		addSequential(new TurnRightGyro(90));
		//gets to Null zone
		addSequential(new DriveForwardTime(6));
		//Position
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveForwardTime(2));
		//Attack
		addSequential(new LaunchCubeHigh());
	}
}
