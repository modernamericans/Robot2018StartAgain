package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class TurnRightTime extends TimedCommand {
	
	public TurnRightTime(double time) {
		super(time);
		requires(Robot.driveTrain);
	}
	
	protected void initialize() {
		Robot.driveTrain.rightTurn();
	}

	protected void end() {
		Robot.driveTrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}