package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem{
	private final SpeedController ctlLauncher = RobotMap.ctlLauncher;
	public void initDefaultCommand() {	}
	public void set(double speed) {
		ctlLauncher.set(speed);
	}
	public void stop( ) {
		set(0);
	}
 }