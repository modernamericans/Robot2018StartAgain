package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;

public class Feed extends InstantCommand {
	public Feeder feeder = Robot.feeder;

	public Feed() {
		requires(feeder);
	}
	
    protected void initialize() {
    	feeder.feed();
    }
}
