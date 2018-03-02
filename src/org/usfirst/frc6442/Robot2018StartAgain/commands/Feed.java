package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;

public class Feed extends TimedCommand {
	public Feeder feeder = Robot.feeder;

	public Feed() {
		super(0);
		requires(Robot.feeder);
	}
	
    protected void initialize() {
    	double time = Robot.values.get("Feed Time",  1);
		setTimeout(time);
    	feeder.feed();
    }

    protected void interrupted() {
    	feeder.stop();
    }
}
