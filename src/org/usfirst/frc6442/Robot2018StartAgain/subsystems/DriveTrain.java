package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.AnalogDrive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends PIDSubsystem{
	private final SpeedController ctlDriveRight = RobotMap.ctlDriveRight;
    private final SpeedController ctlDriveLeft = RobotMap.ctlDriveLeft;
    private static final double Kp = 3;
    private static double Ki = .2;
    private static double Kd = .1;

    public DriveTrain() {
        surper("DriveSystem", Kp, Ki, Kd);
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
	}
 protected double returnPIDInput() {
     return RobotMap.gyro.getAngle();
 }
 protected void usePIDOutput(double output) {
     set(0.5+output,0.5-output);
 }
}

