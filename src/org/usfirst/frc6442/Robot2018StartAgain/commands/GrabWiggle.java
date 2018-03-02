package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class GrabWiggle extends TimedCommand {
	private Grabber grabber = Robot.grabber;
	
	private int tick = 0;
	
	private int leftGrabModulo = 2;
	private int rightGrabModulo = 2;
	private int leftGrabOn = 0;
	private int rightGrabOn = 1;
	
	private double grabSpeed = 0.2;
	
    public GrabWiggle(double time) {
    	super(time);
    }

    protected void initialize() {
    	leftGrabModulo  = (int) Robot.values.get("Wiggle left grabber modulo", 2);
    	rightGrabModulo = (int) Robot.values.get("Wiggle right grabber modulo", 2);
    	leftGrabOn      = (int) Robot.values.get("Wiggle left grab on", 2);
    	rightGrabOn     = (int) Robot.values.get("Wiggle right grab on", 2);
    	grabSpeed       = (int) Robot.values.get("Wiggle grab speed", 2);
    	
    	tick = 0;
    }

    protected void execute() {
    	tick++;
    	grabber.stop();

    	if (tick %  leftGrabModulo ==  leftGrabOn) {
    		grabber.grabLeft(grabSpeed);
    	} 
    	if (tick % rightGrabModulo == rightGrabOn) {
    		grabber.grabRight(grabSpeed);
    	}
    }

    protected void end() {
    	grabber.stop();
    }

    protected void interrupted() {
    	end();
    }
}
