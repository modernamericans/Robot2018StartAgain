package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Grabber;

public class Push extends InstantCommand {
	public Grabber grabber = Robot.grabber;
	
    public Push() {
    	requires(grabber);
    }

    protected void initialize() {
    	grabber.push();
    }
}
