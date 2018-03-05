package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Pneumatics;

public class LauncherOff extends InstantCommand {
	protected Pneumatics pneumatics = Robot.pneumatics;
	
	public LauncherOff() {
	    requires(Robot.pneumatics);
	}
	
	protected void initialize() {
		 pneumatics.off();
	}
}