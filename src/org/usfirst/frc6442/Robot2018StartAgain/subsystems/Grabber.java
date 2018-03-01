package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Grabber extends Subsystem {

    private final SpeedController grabberR = RobotMap.grabCtrlRight;
    private final SpeedController grabberL = RobotMap.grabCtrlLeft;
    private final SpeedControllerGroup grabbingGroup = RobotMap.grabCtrlBoth;

    @Override
    public void initDefaultCommand() {
         //setDefaultCommand(new Grab());h
    }
    
    public void grabSync(double speed) {
    	grab(speed, speed);
    }
    public void pushSync(double speed) {
    	grab(-speed, -speed);
    }
    
    public void grab(double speedR, double speedL) {
    	set(speedR, speedL);
    }
   
    public void set(double speedRight, double speedLeft) {
    	grabberR.set(speedRight);
    	grabberL.set(speedLeft);
    }
    
    @Override
    public void periodic() {
        

    }
}

