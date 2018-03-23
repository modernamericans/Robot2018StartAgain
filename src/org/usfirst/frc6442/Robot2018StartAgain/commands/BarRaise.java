package org.usfirst.frc6442.Robot2018StartAgain.commands;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Bar;

import edu.wpi.first.wpilibj.command.Command;

public class BarRaise extends Command{
	public Bar bar = Robot.bar;
	public BarRaise() {
		requires(bar);
	}
	
	public void execute() {
		bar.set(-.4);
	}
	
	public boolean isFinished() {
		return false;
	}
	
	public void end() {
		bar.stop();
	}
	
	public void interrupted() {
		end();
	}
}
