package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

public class AnalogGrab extends Command {
	
    public AnalogGrab() {
        requires(Robot.grabber);
    }

    @Override
    protected void initialize() {
    	
    }

    @Override
    protected void execute() {
    	double leftGrab = Robot.oi.grabLeft();
    	double rightGrab = Robot.oi.grabRight();
    	Robot.grabber.grab(rightGrab, leftGrab);
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }
    
    @Override
    protected void end() {
    	Robot.grabber.grab(0, 0);
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
