package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotValues;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

/*
 * IDEA: Wiggles the cube left and right while grabbing/securing, to reduce chance of jam?
 */
public class GrabWiggle extends TimedCommand {
	private RobotValues v = Robot.values;
	
	private Grabber grabber = Robot.grabber;
	
	private int tick = 0;
	
    public GrabWiggle(double time) {
    	super(time);
    }

    protected void initialize() {
    	tick = 0;
    	v.update();
    }

    protected void execute() {
    	tick++;
    	grabber.stop();

    	if (tick %  v.leftGrabModulo ==  v.leftGrabOn) {
    		grabber.grabLeft(v.grabSpeed);
    	} 
    	if (tick % v.rightGrabModulo == v.rightGrabOn) {
    		grabber.grabRight(v.grabSpeed);
    	}
    }

    protected void end() {
    	grabber.stop();
    }

    protected void interrupted() {
    	end();
    }
}
