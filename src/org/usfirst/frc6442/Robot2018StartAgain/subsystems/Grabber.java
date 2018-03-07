package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.AnalogGrab;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Grabber extends Subsystem {

    private final SpeedController grabberR = RobotMap.grabCtrlRight;
    private final SpeedController grabberL = RobotMap.grabCtrlLeft;

    public void initDefaultCommand() {
         setDefaultCommand(new AnalogGrab());
    }
    
    public void set(double speedLeft, double speedRight) {
    	grabberL.set(speedLeft);
    	grabberR.set(speedRight);
    }
    
    public void grab(double speedL, double speedR) {
    	set(speedL, speedR);
    }
    
    public void grabLeft(double speed) {
    	grabberL.set(speed);
    }
    
    public void grabRight(double speed) {
    	grabberR.set(speed);
    }
    
    public void grab(double speed) {
    	grab(speed, speed);
    }
    
    public void grab() {
    	grab(1);
    }
    
    public void push(double speedL, double speedR) {
    	set(-speedL, -speedR);
    }
    
    public void push(double speed) {
    	push(speed, speed);
    }
    
    public void push() {
    	push(-1);
    }
    
    public void set(double speed) {
    	set(speed, speed);
    }

	public void stop() {
		set(0);
	}
}

