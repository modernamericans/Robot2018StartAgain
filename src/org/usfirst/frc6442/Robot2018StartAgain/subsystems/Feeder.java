package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Feeder extends Subsystem {
	
	private final SpeedController feeder = RobotMap.feedCtrl;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new AnalogSecure());
    }

    public void set(double speed) {
    	feeder.set(speed);
    }
    
    public void feed(double speed) {
    	set(speed);
    }
    
    public void feed() {
    	feed(Robot.values.lowFeed);
    }
    
    public void secure(double speed) {
    	set(speed);
    }
    public void exchange(double speed) {
    	set(-speed);
    }
    
    public void secure() {
    	secure(Robot.values.secureSpeed);
    }
    
    public void exchange() {
    	exchange(Robot.values.exchangeSpeed);
    }
    
    public void stop() {
    	set(0);
    }
}

