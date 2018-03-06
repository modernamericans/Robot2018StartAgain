package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

public class Grab extends Command {
	
	public Grab() {
    
		requires(Robot.grabber);

		requires(Robot.grabber);
    }

	@Override
    protected void initialize() {
    }

	@Override
    protected void execute() {
    	
    	int mode = Robot.controllerMode;
  	
    	
//    	if(mode == Robot.tankMode || mode == Robot.arcadeMode) { 
//    	double triggerLeft = Robot.oi.joystick.getRawAxis(2);
//    	double triggerRight = Robot.oi.joystick.getRawAxis(3);
    	double triggerLeft = Robot.oi.leftTrigger(1);
    	double triggerRight = Robot.oi.rightTrigger(1);
    	double speed = triggerRight-triggerLeft;
    	Robot.grabber.grab(speed);    	
//    	}
//    }else if(mode == 1){
//    		double joyLeft = Robot.oi.joystick.getRawAxis(1);
//        	double joyRight = Robot.oi.joystick.getRawAxis(5);
//        	Robot.grabber.grabAD(joyRight, joyLeft);
//        	
//    	}
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
