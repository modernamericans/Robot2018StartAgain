package org.usfirst.frc6442.Robot2018StartAgain;

import org.usfirst.frc6442.Robot2018StartAgain.Controller.Mode;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

import edu.wpi.first.wpilibj.command.Scheduler;

public class OI {
//Analog Values
	public double feed;
	public double grabLeft;
	public double grabRight;
	public double driveLeft = 0;
	public double driveRight = 0;
	public boolean reverse = false;


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
		Controller1.Y.whileHeld(new WiggleFeed());
		Controller2.Y.whenPressed(new LaunchCubeHigh());
		
		//Controller1.X.whenPressed(new LauncherDown());
		Controller1.B.whenPressed(new LauncherUp());
		Controller2.X.whenPressed(new LauncherDown());
		Controller2.B.whenPressed(new LauncherUp());
		
		Controller1.A.whenPressed(new LaunchCubeLow());
		Controller2.A.whenPressed(new LaunchCubeLow());
		
		if(Controller1.dPadLeft()) Scheduler.getInstance().add(new TurnLeftGyro(90));
		if(Controller1.dPadRight()) Scheduler.getInstance().add(new TurnRightGyro(90));
		if(Controller1.dPadUp()) reverse = false;
		if(Controller1.dPadDown()) reverse = true;

	}

//Update
	public void Update() {
		UpdateFeederValue();
		UpdateGabberValue();
		UpdateDriverValue();
		UpdateMode();
		if(reverse)	{ 
			double oldLeft = driveLeft;
			double oldRight = driveRight;
			driveLeft = -oldRight;
			driveRight = -oldLeft;
		}
	}

//Update Mode method
//new method updateMode()
	public void UpdateMode() {
		if(Controller1.LB.get())
			Controller1.mode = Controller.Mode.ARCADE;
		if(Controller1.RB.get())
			Controller1.mode = Controller.Mode.TANK;
//		if(Controller1.dPadUp())
	//		reverse = false;
		//if(Controller1.dPadDown())
			//reverse = true;
		if(Controller1.X.get())
			reverse = !reverse;
		//done, now just add this method to the update
	}
//Update Feeder Method
	private void UpdateFeederValue() {
		double RT = Controller2.axisRT();
		double LT = Controller2.axisLT();
		feed = RT-LT;
		grabLeft = RT-LT;
		grabRight = RT-LT;
	}
//updater grabber method
	private void UpdateGabberValue() {
		double RT = Controller2.axisRT();
		double LT = Controller2.axisLT();
		double RY = Controller2.axisRY();
		double LY = Controller2.axisLY();
		boolean finesse = RT == 0 && LT == 0;
		if(finesse) {
			grabLeft = -LY;
			grabRight = -RY;
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
    		double joySpeed = LY;
    		double joySteer = RX;
    		
        	double steerStrength = Math.abs(joySteer);
        	
        	boolean steerRight = joySteer > 0;
        	boolean steerLeft = joySteer < 0;
        	
			driveRight = 1;
			driveLeft = 1;
        	
        	if(steerRight) {
        		driveRight -= steerStrength;	
        	}
        	if(steerLeft) {
        		driveLeft -= steerStrength;	
        	}
        	
		}
	}
}