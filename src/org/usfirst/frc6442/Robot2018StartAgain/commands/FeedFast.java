package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;

public class FeedFast extends InstantCommand {
	public Feeder feeder = Robot.feeder;

	public FeedFast() {
		requires(Robot.feeder);
	}
	
    protected void initialize() {
    	feeder.feed(Robot.values.highFeed);
    }
}