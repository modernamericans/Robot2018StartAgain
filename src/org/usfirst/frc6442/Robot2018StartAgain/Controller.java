package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

public class Controller extends Joystick {
	public DriveMode mode = DriveMode.TANK;

	public double deadzone = 0.05;
	 
    public JoystickButton buttonA;
    public JoystickButton buttonB;
    public JoystickButton buttonX;
    public JoystickButton buttonY;
    public JoystickButton buttonLB;
    public JoystickButton buttonRB;
    public JoystickButton buttonBack;
    public JoystickButton buttonStart;
    public JoystickButton buttonLS;
    public JoystickButton buttonRS;	
    
    public DPadButton buttonUp;	
    public DPadButton buttonRight;	
    public DPadButton buttonDown;	
    public DPadButton buttonLeft;	
    
    public int dPadZone = 0;
    
    public Controller(int id) {
		super(id);
        buttonA       = new JoystickButton(this, 1);
        buttonB       = new JoystickButton(this, 2);
        buttonX       = new JoystickButton(this, 3);
        buttonY       = new JoystickButton(this, 4);
        buttonLB      = new JoystickButton(this, 5);
        buttonRB      = new JoystickButton(this, 6);
        buttonBack    = new JoystickButton(this, 7);
        buttonStart   = new JoystickButton(this, 8);
        buttonLS      = new JoystickButton(this, 9);
        buttonRS      = new JoystickButton(this, 10);
        
        buttonUp    = new DPadButton(this, 1);  
        buttonRight	= new DPadButton(this, 2);  
        buttonDown  = new DPadButton(this, 3);  
        buttonLeft  = new DPadButton(this, 4);  
    }
    
    class DPadButton extends Button {
    	private Controller controller;
    	private int zone;
    	public DPadButton(Controller c, int zoneToMatch) {
    		controller = c;
    		zone = zoneToMatch;
    	}
    	public boolean get() {
    		return controller.dPadZone == zone;
    	}
    }
    
    public void update() {
    	updateDPad();
    	if (buttonLB.get()) mode = DriveMode.ARCADE;
    	if (buttonRB.get()) mode = DriveMode.TANK;
    }
    
    public double  axisLX    () { return applyDeadzone( this.getRawAxis(0) ); }
    public double  axisLY    () { return applyDeadzone( this.getRawAxis(1) ); }
    public double  axisRX    () { return applyDeadzone( this.getRawAxis(4) ); }
    public double  axisRY    () { return applyDeadzone( this.getRawAxis(5) ); }
    public double  triggerR  () { return applyDeadzone( this.getRawAxis(3) ); }
    public double  triggerL  () { return applyDeadzone( this.getRawAxis(2) ); }
    
    public double applyDeadzone(double value) {
    	return Math.abs(value) > deadzone ? value : 0;
    }
    
	public void updateDPad() {
    	int angle = this.getPOV();
    	dPadZone = angleToZone(angle);
    }
	
	public int angleToZone(int angle) {
		if (angle == -1) return 0;
		if (angle > 337 || angle < 23)  return 1;
		if (angle > 67  && angle < 113) return 2;
		if (angle > 157 && angle < 213) return 3;
		if (angle > 247 && angle < 293) return 4;
		return 0;
	}
	
	public boolean dPadUp    () { return dPadZone == 1 ? true : false; }
	public boolean dPadRight () { return dPadZone == 2 ? true : false; }
	public boolean dPadDown  () { return dPadZone == 3 ? true : false; }
	public boolean dPadLeft  () { return dPadZone == 4 ? true : false; }
}
