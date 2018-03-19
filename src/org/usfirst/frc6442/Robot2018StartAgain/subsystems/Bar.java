package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.AnalogSecure;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Bar extends Subsystem{
	private final SpeedController ctlBar = RobotMap.ctlBar;
	public void initDefaultCommand() {}
	public void set(double speed) {
		ctlBar.set(speed);
	}
	public void stop( ) {
		set(0);
	}
 }