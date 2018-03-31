package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousMacarena extends CommandGroup {

	public AutonomousMacarena() {
		while(true) {
			addSequential(new TurnLeftGyro(5));
			addSequential(new DriveStop(.1));
			addSequential(new TurnRightGyro(5));
			addSequential(new DriveStop(.1));
			addSequential(new TurnRightGyro(5));
			addSequential(new DriveStop(.1));
			addSequential(new TurnLeftGyro(5));
			addSequential(new LauncherUp());
			addSequential(new DriveStop(.1));
			addSequential(new LauncherDown());
			addSequential(new DriveStop(.1));
			addSequential(new BarLower());
			addSequential(new DriveStop(.1));
			addSequential(new BarRaise());
			addSequential(new DriveStop(.1));
			addSequential(new TurnRightGyro(5));
			addSequential(new DriveStop(.1));
			addSequential(new TurnLeftGyro(5));
			addSequential(new DriveStop(.1));
			addSequential(new TurnLeftGyro(5));
			addSequential(new DriveStop(.1));
			addSequential(new TurnRightGyro(5));
			addSequential(new DriveStop(.1));
			addSequential(new TurnLeftGyro(360));
			addSequential(new DriveStop(.1));
			addSequential(new TurnLeftGyro(90));
			addSequential(new DriveStop(.1));

		}
		
		
	}
}