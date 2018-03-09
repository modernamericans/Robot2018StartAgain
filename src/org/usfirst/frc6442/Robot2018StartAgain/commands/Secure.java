package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class Secure extends Command {
	protected Feeder feeder = Robot.feeder;
	
    public Secure() {
    	requires(feeder);
    }

    protected void initialize() {
    	feeder.secure();
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
