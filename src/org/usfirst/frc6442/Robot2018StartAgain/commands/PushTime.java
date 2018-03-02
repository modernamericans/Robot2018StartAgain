package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Grabber;

public class PushTime extends TimedCommand {
	public Grabber grabber = Robot.grabber;
	
    public PushTime(double time) {
    	super(time);
    	requires(Robot.grabber);
    }

    protected void initialize() {
    	grabber.push();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
