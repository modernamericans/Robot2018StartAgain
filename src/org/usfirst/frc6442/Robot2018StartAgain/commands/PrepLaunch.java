
package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

public class PrepLaunch extends Command {
	private int time;

    public PrepLaunch() {

    }

    @Override
    protected void initialize() {
    	System.out.println("Engaging Thrusters Now");
    	time = 0;
    }

    @Override
    protected void execute() {
    	System.out.println("Thrusters aproaching Full Speed");
    	time++;
    }

    @Override
    protected boolean isFinished() {
        
        System.out.println("Thusters at Full Speed");
        return (time > 50);
        
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
