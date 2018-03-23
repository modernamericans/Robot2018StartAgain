package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.AnalogDrive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

//public class DriveTrain extends PIDSubsystem{
public class DriveTrain extends Subsystem{
private final SpeedController ctlDriveRight = RobotMap.ctlDriveRight;
    private final SpeedController ctlDriveLeft = RobotMap.ctlDriveLeft;
    private static final double Kp = 3;
    private static final double Ki = .2;
    private static final double Kd = .1;
    private static boolean PIDing=false;
    private static double speed = .5;

    public DriveTrain() {
       // super("DriveTrain", Kp, Ki, Kd);
        //disable();
    }
	public void initDefaultCommand() {	
		setDefaultCommand(new AnalogDrive());
	}
	public void set(double speed) {
		ctlDriveRight.set(speed);
		ctlDriveLeft.set(speed);
	}
	public void set(double left, double right) {
		ctlDriveRight.set(right);
		ctlDriveLeft.set(left);
	}
	public void stop( ) {
        set(0);
     //   PIDing = false;
       // disable();
    }/*
	public void PIDset(double angle) {
    	double current = RobotMap.gyro.getAngle();
    	PIDing = true;
    	setSetpoint(current + angle);
    	enable();
	}
    public void driveStraight(double speed){
        this.speed = speed;
    	PIDset(0);
    }
    public void driveTurnLeft(double angle) {
    	speed = 0;
    	PIDset(-angle);
    }
    public void driveTurnRight(double angle) {
    	speed=0;
    	PIDset(angle);
    }*/
 protected double returnPIDInput() {
     return RobotMap.gyro.getAngle();
 }
 protected void usePIDOutput(double output) {
     set(speed+output,speed-output);
 }
}