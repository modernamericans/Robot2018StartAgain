package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.AnalogSecure;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem{
	private final SpeedController ctlFeeder = RobotMap.ctlFeeder;
	public void initDefaultCommand() {	
		setDefaultCommand(new AnalogSecure());
	}
	public void set(double speed) {
		ctlFeeder.set(speed);
	}
	public void stop( ) {
		set(0);
	}
 }