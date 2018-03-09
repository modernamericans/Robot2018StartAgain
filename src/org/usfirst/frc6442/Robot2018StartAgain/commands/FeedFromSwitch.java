package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;

public class FeedFromSwitch extends Command {
	public Feeder feeder = Robot.feeder;

	public FeedFromSwitch() {
		requires(feeder);
	}
	
  protected void initialize() {
    feeder.feed();
  }

  protected boolean isFinished() {
    return !RobotMap.feedSwitch.get();
  }

  protected void end() {
    feeder.stop();
  }

  protected void interrupted() {
    end();
  }
}
