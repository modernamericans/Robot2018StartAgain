package org.usfirst.frc6442.Robot2018StartAgain.commands;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

public class AnalogSecure extends Command{
	protected Feeder feeder = Robot.feeder;
	protected Launcher launcher = Robot.launcher;
	public AnalogSecure() {
		requires(feeder);
		requires(launcher);
	}
	protected void execute() {
		feeder.set(Robot.oi.feed);
		launcher.set(Robot.oi.launch);
	}
	protected boolean isFinished() { return false; }
	protected void end() {feeder.stop();}
	protected void interrupted() {end();}
}
