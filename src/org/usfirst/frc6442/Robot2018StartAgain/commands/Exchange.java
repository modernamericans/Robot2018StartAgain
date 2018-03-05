package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class Exchange extends Command {
	protected Feeder feeder = Robot.feeder;
	
    public Exchange() {
    	requires(Robot.feeder);
    }

    protected void initialize() {
    	feeder.exchange();
    }

    protected boolean isFinished() {
    	// ToDo: test limit switch?
        return false;
    }

    protected void end() {
    	feeder.stop();
    }

    protected void interrupted() {
    	end();
    }
}
