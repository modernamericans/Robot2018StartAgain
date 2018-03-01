package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

public class Exchange extends TimedCommand {

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.launcher.exchange();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.launcher.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	Robot.launcher
    }
}
