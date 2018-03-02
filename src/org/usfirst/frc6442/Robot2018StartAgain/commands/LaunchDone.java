package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class LaunchDone extends InstantCommand {
	private Feeder feeder = Robot.feeder;
	private Launcher launcher = Robot.launcher;
	
    public LaunchDone() {
    	requires(Robot.feeder);
    	requires(Robot.launcher);
    }
    
    protected void initialize() {
    	feeder.stop();
    	launcher.stop();
    }
}
