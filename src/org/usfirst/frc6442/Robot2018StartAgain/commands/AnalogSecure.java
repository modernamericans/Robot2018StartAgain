package org.usfirst.frc6442.Robot2018StartAgain.commands;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;

import edu.wpi.first.wpilibj.command.Command;

public class AnalogSecure extends Command{
	protected Feeder feeder = Robot.feeder;
	public AnalogSecure() {
		requires(feeder);
	}
	protected void execute() {
		feeder.set(Robot.oi.feed);
	}
	protected boolean isFinished() { return false; }
	protected void end() {feeder.stop();}
	protected void interrupted() {end();}
}
