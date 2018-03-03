package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotValues;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class LauncherRaw extends Command {
	enum Goal {HIGH, LOW}
	enum State {WAITING, INIT, SPINNING, FEEDING, LAUNCHING, ENDING}
	
	public State state;
	public Goal goal;
	
	public Timer timer;
	
	private final Feeder feeder = Robot.feeder;
	private final Launcher launcher = Robot.launcher;
	private final Pneumatics  pneumatics = Robot.pneumatics;
	
	public LauncherRaw() {
		requires(Robot.feeder);
		requires(Robot.launcher);
		requires(Robot.pneumatics);
	}
	
	protected void initialize() {
		Robot.values.update();
	}
	
	private RobotValues v = Robot.values;
	
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
	    		speed = goal == Goal.HIGH ? v.highSpeed : v.lowSpeed ;
	    		launcher.launch(speed);
	    		timer.reset();
	    		timer.start();
	    		state = State.SPINNING;
	    		break;
	    		
	    	case SPINNING:
	    		wait = goal == Goal.HIGH ? v.highSpin : v.lowSpin;
	    		if (timer.get() > wait) state = State.FEEDING;
	    		break;
	    		
	    	case FEEDING:
	    		speed = goal == Goal.HIGH ? v.highFeed : v.lowFeed;
	    		feeder.feed(speed);
	    		timer.reset();
	    		timer.start();
	    		break;
	    		
	    	case LAUNCHING:
	    		wait = goal == Goal.HIGH ? v.highFeedTime : v.lowFeedTime;
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