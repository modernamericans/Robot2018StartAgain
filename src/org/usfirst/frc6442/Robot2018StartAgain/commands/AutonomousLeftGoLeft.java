//RobotBuilder Version: 2.0
//
//This file was generated by RobotBuilder. It contains sections of
//code that are automatically generated and assigned by robotbuilder.
//These sections will be updated in the future when you export to
//Java from RobotBuilder. Do not put any code or make any change in
//the blocks indicating autogenerated code or it will be lost on an
//update. Deleting the comments indicating the section will prevent
//it from being updated in the future.


package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class AutonomousLeftGoLeft extends CommandGroup {

public AutonomousLeftGoLeft() {

	addSequential(new DriveForwardTime(1));
	addSequential(new DriveStop(1));
	addSequential(new TurnRight(90));//this is in degrees, not in terms of time
	addSequential(new DriveForwardTime(1));
	//addSequential(new LaunchLow);
	addSequential(new DriveReverseTime(1));
	addSequential(new TurnLeft(90));	
} 
}
