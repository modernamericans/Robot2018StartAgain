package org.usfirst.frc6442.Robot2018StartAgain;

import org.usfirst.frc6442.Robot2018StartAgain.Controller.Mode;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class OI {
//Analog Values
	public double feed;
	public double grabLeft;
	public double grabRight;
	public double driveLeft;
	public double driveRight;


// Controlers
	public Controller Controller1;
	public Controller Controller2;

// Constructure init controlers and map buttons
	public OI() {
		Controller1 = new Controller(0);
		Controller2 = new Controller(1);
		defineButtons();
	}
//Map buttons
	public void defineButtons() {
		Controller1.Y.whenPressed(new LaunchCubeHigh());
		Controller2.Y.whenPressed(new LaunchCubeHigh());
		
		Controller1.A.whenPressed(new LaunchCubeLow());
		Controller2.A.whenPressed(new LaunchCubeLow());
	}

//Update
	public void Update() {
		UpdateFeederValue();
		UpdateGabberValue();
		UpdateDriverValue();
	}

//Update Mode method


//Update Feeder Method
	private void UpdateFeederValue() {
		double RT = Controller2.axisRT();
		double LT = Controller2.axisLT();
		feed = RT-LT;
	}
//updater grabber method
	private void UpdateGabberValue() {
		double RT = Controller1.axisRT();
		double LT = Controller1.axisLT();
		double RY = Controller2.axisRY();
		double LY = Controller2.axisLY();
		boolean finesse = RY !=0 || LY != 0;
		if(finesse) {
			grabLeft = LY;
			grabRight = RY;
		}
		
		else {
			grabLeft = RT-LT;
			grabRight = RT-LT;
		}
	}
//update drive method
	private void UpdateDriverValue() {
		double RY = Controller1.axisRY();
		double LY = Controller1.axisLY();
		double RX = Controller1.axisRX();
		double LX = Controller1.axisLX();
		Mode mode = Controller1.mode;
		if(mode == Mode.TANK) {
			driveLeft = LY;
			driveRight = RY;
		}
		
		else {
    		double joySpeed = Controller1.axisLY();
    		double joySteer = Controller1.axisRX();
    		
        	double steerStrength = Math.abs(joySteer);
        	
        	boolean steerRight = joySteer > 0;
        	boolean steerLeft = joySteer < 0;
        	
        	if(steerRight) {
        		driveRight =1 - steerStrength;	
        	}
        	if(steerLeft) {
        		driveLeft = 1 - steerStrength;	
        	}
        	driveRight = driveRight * joySpeed;
        	driveLeft = driveLeft * joySpeed;
		}
	}
}