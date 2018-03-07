package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

public class Controller extends Joystick {
	public DriveMode mode = DriveMode.TANK;

	public double deadzone = 0.05;
	 
    public JoystickButton buttonA    = new JoystickButton(this, 1);
    public JoystickButton buttonB    = new JoystickButton(this, 2);
    public JoystickButton buttonX    = new JoystickButton(this, 3);
    public JoystickButton buttonY    = new JoystickButton(this, 4);
    public JoystickButton buttonLB   = new JoystickButton(this, 5);
    public JoystickButton buttonRB   = new JoystickButton(this, 6);
    public JoystickButton buttonBack = new JoystickButton(this, 7);
    public JoystickButton buttonStart= new JoystickButton(this, 8);
    public JoystickButton buttonLS   = new JoystickButton(this, 9);
    public JoystickButton buttonRS   = new JoystickButton(this, 10);
    
    public DPadButton buttonUp   = new DPadButton(this, 1);
    public DPadButton buttonRight= new DPadButton(this, 2);
    public DPadButton buttonDown = new DPadButton(this, 3);
    public DPadButton buttonLeft = new DPadButton(this, 4);
    
    public int dPadZone = 0;
    
    public Controller(int id) {
		super(id);
    }
    
    class DPadButton extends Button {
    	private Controller controller;
    	private int zone;
    	
    	public DPadButton(Controller controller, int zone) {
    		this.controller = controller;
    		this.zone = zone;
    	}
    	
    	public boolean get() {
    		return ( controller.dPadZone == zone );
    	}
    }
    
    public void update() {
    	updateDPad();
    }
    
    public double  axisLX    () { return applyDeadzone(   this.getRawAxis(0) ); }
    public double  axisLY    () { return applyDeadzone( - this.getRawAxis(1) ); } // invert vertical axis so that up is positive
    public double  axisRX    () { return applyDeadzone(   this.getRawAxis(4) ); }
    public double  axisRY    () { return applyDeadzone( - this.getRawAxis(5) ); } // invert vertical axis so that up is positive
    public double  triggerR  () { return applyDeadzone(   this.getRawAxis(3) ); }
    public double  triggerL  () { return applyDeadzone(   this.getRawAxis(2) ); }
    
    public double applyDeadzone(double value) {
    	return Math.abs(value) > deadzone ? value : 0;
    }
    
	public void updateDPad() {
    	int angle = this.getPOV();
    	dPadZone = angleToZone(angle);
    }
	
	public int angleToZone(int angle) {
		if (angle != -1) {
            angle = (int) Math.floor( ( (angle + 22.5) % 360 ) / 45);
        }
        // -1 means no press, 0-7 are 8 directions as if cardinal directions (0=N, 1=NE, 2=E, 3=SE, 4=S, 5=SW, 6=W, 7=NW )
		return angle;
	}
	
	public boolean dPadUp    () { return dPadZone == 0 ? true : false; }
	public boolean dPadRight () { return dPadZone == 2 ? true : false; }
	public boolean dPadDown  () { return dPadZone == 4 ? true : false; }
	public boolean dPadLeft  () { return dPadZone == 6 ? true : false; }
}
