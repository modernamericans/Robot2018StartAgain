package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class LauncherRaw extends Command {
	enum Goal {HIGH, LOW}
	enum State {WAITING, INIT, SPINNING, FEEDING, LAUNCHING, ENDING}
	public Timer timer;
	public State state;
	public Goal goal;
	private final Feeder feeder = Robot.feeder;
	private final Launcher launcher = Robot.launcher;
	private final Pneumatics  pneumatics = Robot.pneumatics;
	
	public LauncherRaw() {
		requires(Robot.feeder);
		requires(Robot.launcher);
		requires(Robot.pneumatics);
		
		List<String> vars = Arrays.asList(
				"High Launch Speed",     
				"Low Launch Speed",      
				"High Launch Spin Time", 
				"Low Launch Spin Time",  
				"High Launch Feed Speed",
				"Low Launch Feed Speed", 
				"High Launch Feed Time", 
				"Low Launch Feed Time",  
				"High Launch Speed",     
				"Low Launch Speed",      
				"High Launch Spin Time", 
				"Low Launch Spin Time",  
				"High Launch Feed Speed",
				"Low Launch Feed Speed", 
				"High Launch Feed Time", 
				"Low Launch Feed Time"
		);
		
		for (String var : vars) {
			double val = 0.5;
			if (var.startsWith("Low")) val = 0.2;
			if (!Robot.prefs.containsKey(var)) Robot.prefs.putDouble(var, val);
		}
	}

	protected double highSpeed() {
		return Robot.prefs.getDouble("High Launch Speed", 0.5);
	}

	protected double lowSpeed() {
		return Robot.prefs.getDouble("Low Launch Speed",  0.2);
	}
	
	protected double highSpin() {
		return Robot.prefs.getDouble("High Launch Spin Time", 0.5);
	}

	protected double lowSpin() {
		return Robot.prefs.getDouble("Low Launch Spin Time",  0.2);
	}
	
	protected double highFeed() {
		return Robot.prefs.getDouble("High Launch Feed Speed", 0.5);
	}

	protected double lowFeed() {
		return Robot.prefs.getDouble("Low Launch Feed Speed",  0.2);
	}
	
	protected double highFeedTime() {
		return Robot.prefs.getDouble("High Launch Feed Time", 0.5);
	}

	protected double lowFeedTime() {
		return Robot.prefs.getDouble("Low Launch Feed Time",  0.2);
	}
	
	protected void execute() {
		double speed, wait;
	    boolean isAPressed = Robot.oi.controller1.buttonA.get();
	    boolean isYPressed = Robot.oi.controller1.buttonY.get();
	    
	    switch (state) {
	    	case WAITING:
	    		if (isAPressed || isYPressed) {
	    			state = State.INIT;
	    			if (isAPressed) {
	    				goal = Goal.LOW;
	    				pneumatics.down();
	    			}
	    			if (isYPressed) {
	    				goal = Goal.HIGH;
	    				pneumatics.up();
	    			}
	    		}
	    		break;
	    		
	    	case INIT:
	    		speed = goal == Goal.HIGH ? highSpeed() : lowSpeed();
	    		launcher.launch(speed);
	    		timer.reset();
	    		timer.start();
	    		state = State.SPINNING;
	    		break;
	    		
	    	case SPINNING:
	    		wait = goal == Goal.HIGH ? highSpin() : lowSpin();
	    		if (timer.get() > wait) state = State.FEEDING;
	    		break;
	    		
	    	case FEEDING:
	    		speed = goal == Goal.HIGH ? highFeed() : lowFeed();
	    		feeder.feed(speed);
	    		timer.reset();
	    		timer.start();
	    		break;
	    		
	    	case LAUNCHING:
	    		wait = goal == Goal.HIGH ? highFeedTime() : lowFeedTime();
	    		if (timer.get() > wait) state = State.ENDING;
	    		break;
	    		
	    	case ENDING:
	    		feeder.stop();
	    		launcher.stop();
	    		state = State.WAITING;
	    		break;
	    		
	    }
	}
	
	protected boolean isFinished() {
	   return false;
	}

	protected void end() {
		launcher.set(0);
		feeder.stop();
		pneumatics.off();
	}
	
	protected void interrupted() {
		end();
	}
}