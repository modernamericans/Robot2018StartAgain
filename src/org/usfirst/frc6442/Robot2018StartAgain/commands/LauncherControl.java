package org.usfirst.frc6442.Robot2018StartAgain.commands;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class LauncherControl extends Command {

	  protected void execute() {
	    boolean isAPressed = Robot.oi.xbox.getAButton();
	    
	    if(isAPressed) {
	    	Scheduler.getInstance().add(new LaunchCube(1));
	    	
	    	
	    }
	    		
	    }
	  protected boolean isFinished() {
		  return false;
	  }
}
