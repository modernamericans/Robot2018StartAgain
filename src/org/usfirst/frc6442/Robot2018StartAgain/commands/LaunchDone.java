package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class LaunchDone extends Command {
	private double time;
	private Timer timer;

	public LaunchDone(double waitTime) {

    	time = waitTime;
    	timer = new Timer();
    	}
    	
        @Override
    protected void initialize() {
    	timer.start();
    	
    }

   @Override
    protected void execute() {
    	
    }

    @Override
    protected boolean isFinished() {
        return timer.get() > time;
        
    }

    @Override
    protected void end() {
    	System.out.println("Stoping Stage 1");
//    	RobotMap.launcherLauncherStage1Group.set(0);
    	System.out.println("Stoping Stage 2");
//    	RobotMap.launcherLauncherStage2Group.set(0);
    }

    @Override
    protected void interrupted() {
    }
}
