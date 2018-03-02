package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Launcher;

public class LauncherSpinFast extends TimedCommand {
	public Launcher launcher = Robot.launcher;
	
	public LauncherSpinFast() {
		super(0);
	    requires(Robot.launcher);
	}
	
	protected void initialize() {
		double time = Robot.values.get("High Launch Spin Time",  0.2);
		setTimeout(time);
		launcher.launchFast();
	}
}