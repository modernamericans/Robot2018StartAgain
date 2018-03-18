package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import org.usfirst.frc6442.Robot2018StartAgain.commands.DriveReverseTime;
import org.usfirst.frc6442.Robot2018StartAgain.commands.DriveStop;
import org.usfirst.frc6442.Robot2018StartAgain.commands.LaunchCubeLow;
import org.usfirst.frc6442.Robot2018StartAgain.commands.TurnLeftGyro;
import org.usfirst.frc6442.Robot2018StartAgain.commands.TurnRightGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCenterGoRightSimple extends CommandGroup {
	public AutonomousCenterGoRightSimple() {
	
		addSequential(new DriveReverseTime(1));
		addSequential(new TurnRightGyro(90));
		addSequential(new DriveReverseTime(1));
		addSequential(new TurnLeftGyro(90));
		addSequential(new DriveReverseTime(2));
		addSequential(new DriveStop(.5));
		addSequential(new LaunchCubeLow());
	
	}

}
