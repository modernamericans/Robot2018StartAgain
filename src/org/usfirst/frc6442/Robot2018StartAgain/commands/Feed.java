package org.usfirst.frc6442.Robot2018StartAgain.commands;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class Feed extends InstantCommand{
	protected Feeder feeder = Robot.feeder;
	public Feed() {
		requires(Robot.feeder);
	}
	protected void initialize() {
		feeder.set(1);
	}
}
