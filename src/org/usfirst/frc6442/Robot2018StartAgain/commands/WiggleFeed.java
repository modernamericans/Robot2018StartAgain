package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class WiggleFeed extends Command {
	protected Feeder feeder = Robot.feeder;
	protected Launcher launcher = Robot.launcher;
	public int tic = 0;
  public int direction = 1;
  public int time = time;
  public WiggleFeed() {
		 requires(feeder);
		 requires(launcher);
	}
	
	protected execute() {
    tic++;
    boolean swap = tic % time == 0;
    if(swap) {
    tic = 0;
    direction = -direction;
    }
		feeder.set(.5*direction);
		launcher,set(.25*direction);
	}
		protected boolean isFinished() {
			return false;
	 }
	
	protected void end() {
		 feeder.stop();
		 launcher.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
