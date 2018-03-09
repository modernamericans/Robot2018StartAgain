package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;

public class AnalogSecure extends Command {
	
	protected Feeder feeder = Robot.feeder;
	
    public AnalogSecure() {
        requires(feeder);
    }

    protected void execute() {
    	double  secure = Robot.oi.getFeed();
    	
    	feeder.secure(secure);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	feeder.stop();
    }

    protected void interrupted() {
    	end();
    }
}
