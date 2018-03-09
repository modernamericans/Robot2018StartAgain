package org.usfirst.frc6442.Robot2018StartAgain.commands;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AnalogDrive extends Command{
	protected DriveTrain driveTrain = Robot.driveTrain;
	public AnalogDrive() {
		requires(driveTrain);
	}
	protected void execute() {
		driveTrain.set(Robot.oi.driveLeft, Robot.oi.driveRight);
	}
	protected boolean isFinished() { return false; }
	protected void end() {driveTrain.stop();}
	protected void interrupted() {end();}
}
