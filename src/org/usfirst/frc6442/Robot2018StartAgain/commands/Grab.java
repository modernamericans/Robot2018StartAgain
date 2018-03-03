package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Grabber;

public class Grab extends InstantCommand {
	public Grabber grabber = Robot.grabber;
	
    public Grab() {
    	requires(Robot.grabber);
    }

    protected void initialize() {
    	grabber.grab();
    }
}
