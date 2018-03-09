package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Grabber;

public class AnalogGrab extends Command {
	
	protected Grabber grabber = Robot.grabber;
	
    public AnalogGrab() {
        requires(grabber);
    }

    protected void initialize() {
    	
    }
    
    protected void execute() {
    	double  leftGrab = Robot.oi.getGrabLeft();
    	double rightGrab = Robot.oi.getDriveRight();
    	
    	grabber.grab(leftGrab, rightGrab);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	grabber.stop();
    }

    protected void interrupted() {
    	end();
    }
}
