package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Grabber;

public class GrabTime extends TimedCommand {
	public Grabber grabber = Robot.grabber;
	
    public GrabTime(double time) {
    	super(time);
    	requires(Robot.grabber);
    }

    protected void initialize() {
    	grabber.grab();
    }

    protected void end() {
    	grabber.stop();
    }

    protected void interrupted() { 
    	end(); 
    }
}
