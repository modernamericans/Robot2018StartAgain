package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRightGoScaleRight extends CommandGroup {
	
	public AutonomousRightGoScaleRight() {
		//Gets around switch
		//addSequential(new DriveStraightReverseTime(.2));
		//addSequential(new TurnRightGyro(90));
		addSequential(new DriveForwardTime(.2));
		//addSequential(new TurnLeftGyro(90));
		//gets to Null zone
		addSequential(new DriveStraightReverseTime(7));
		//Position
		
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveStraightForwardTime(2));
		//Attack
		addSequential(new LaunchCubeHigh());
	}
}