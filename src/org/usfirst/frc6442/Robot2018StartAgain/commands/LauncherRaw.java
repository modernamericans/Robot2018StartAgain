package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;




public class LauncherRaw extends Command {
	
	public Timer timer;
	private final SpeedController feeder = RobotMap.launcherLaunchStage1;
	private final SpeedController launcher = RobotMap.launcherLaunchStage2;
	private final DoubleSolenoid doubleSolenoid = RobotMap.pneumaticsDoubleSolenoid;
	
public LauncherRaw() {
	
   requires(Robot.launcher);
   requires(Robot.pneumatics);
	
}

@Override
protected void initialize() {
}

@Override
protected void execute() {
	
//    boolean isAPressed = Robot.oi.xbox.getAButton();
//    boolean isYPressed = Robot.oi.xbox.getYButton();
//    
//    if(isAPressed) {
//
//    	timer.reset();
//    	timer.start();
//    	doubleSolenoid.set(DoubleSolenoid.Value.kForward);
//    	launcher.set(.5);
//    	
//    	while(timer.get() < 1);
//    	feeder.set(1);
//    	
//    	while(timer.get() < 2);
//    	launcher.set(0);
//    	feeder.set(0);
//    }
//    if(isYPressed) {
//
//    	timer.reset();
//    	timer.start();
//    	doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
//    	launcher.set(1);
//    	
//    	while(timer.get() < 1);
//    	feeder.set(1);
//    	
//    	while(timer.get() < 2);
//    	launcher.set(0);
//    	feeder.set(0);
//    }
}

@Override
protected boolean isFinished() {
   return false;
}

@Override
protected void end() {
}

@Override
protected void interrupted() {
}
}