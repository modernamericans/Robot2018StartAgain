package org.usfirst.frc6442.Robot2018StartAgain.commands;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Grabber;

import edu.wpi.first.wpilibj.command.Command;

public class AnalogGrab extends Command{
	protected Grabber grabber = Robot.grabber;
	public AnalogGrab() {
		requires(grabber);
	}
	protected void execute() {
		grabber.set(Robot.oi.grabLeft, Robot.oi.grabRight);
	}
	protected boolean isFinished() { return false; }
	protected void end() {grabber.stop();}
	protected void interrupted() {end();}
}
