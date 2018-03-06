package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class Secure extends Command {
	protected Feeder feeder = Robot.feeder;
	
    public Secure() {
    	requires(Robot.feeder);
    }

    protected void initialize() {
    	feeder.secure();
    }

    protected boolean isFinished() {
        return RobotMap.feedSwitch.get();
    }

    protected void end() {
    	feeder.stop();
    }

    protected void interrupted() {
    	end();
    }
}
