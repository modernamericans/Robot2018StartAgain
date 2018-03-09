package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.AnalogGrab;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem{
	private final SpeedController ctlGrabRight = RobotMap.ctlGrabRight;
	private final SpeedController ctlGrabLeft = RobotMap.ctlGrabLeft;
	public void initDefaultCommand() {	
		setDefaultCommand(new AnalogGrab());
	}
	public void set(double speed) {
		ctlGrabRight.set(speed);
		ctlGrabLeft.set(speed);
	}
	public void set(double left, double right) {
		ctlGrabRight.set(right);
		ctlGrabLeft.set(left);
	}
	public void left(double speed) {
		ctlGrabLeft.set(speed);
	}
	public void right(double speed) {
		ctlGrabRight.set(speed);
	}
	public void stop( ) {
		set(0);
	}
 }