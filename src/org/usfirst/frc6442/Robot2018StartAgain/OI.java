// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6442.Robot2018StartAgain;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private double  leftDrive ;
	private double rightDrive ;
	private double  leftGrab  ;
	private double rightGrab  ;
	
    public Controller controller1;
    public Controller controller2;
    
    public OI() {	
        controller1 = new Controller(2);
        controller2 = new Controller(0);
    }
    
    // make sure this is called
    public void inputPeriodic() {
    	controller1.update();
    	controller2.update();
    	updateGrabValues();
    	updateDriveValues();
    }
    
	public void mapButtons() {
		controller1.buttonY    .whenPressed( new LaunchCubeHigh() );
		controller2.buttonY    .whenPressed( new LaunchCubeHigh() );
		
		controller1.buttonA    .whenPressed( new LaunchCubeLow()  );
		controller2.buttonA    .whenPressed( new LaunchCubeLow()  );
		
		controller1.buttonDown .whenPressed( new SecureCube()     );
		controller2.buttonDown .whenPressed( new SecureCube()     );
		
		controller1.buttonUp   .whenPressed( new ExchangeCube()   );
		controller2.buttonUp   .whenPressed( new ExchangeCube()   );
		
		Command updateValues = new InstantCommand() { protected void initialize(){ 
			Robot.values.update(); 
		}};
		
		controller1.buttonStart   .whenPressed( updateValues );
		controller2.buttonStart   .whenPressed( updateValues );
	}


    
    private void updateGrabValues() {
    	double TL, TR, TL1, TL2, TR1, TR2, RAxis, LAxis;
    	
    	leftDrive = 0;
    	rightDrive = 0;
    	
    	DriveMode mode;
    	
    	TL1 = controller1.triggerL();
    	TR1 = controller1.triggerR();
    	TL2 = controller2.triggerL();
    	TR2 = controller2.triggerR();
    	
    	RAxis = controller2.axisRY();
    	LAxis = controller2.axisLY();
    	
    	// dominance is max only
    	TL = Math.max(TL1, TL2);
    	TR = Math.max(TR1, TR2);
    	
		leftGrab  = LAxis != 0 ? LAxis : TR - TL ;
		rightGrab = RAxis != 0 ? RAxis : TR - TL ;
    }
    
    private void updateDriveValues() {
    	double LX, LY, RX, RY, LX1, LX2, LY1, LY2, RX1, RX2, RY1, RY2;
    	
    	leftDrive = 0;
    	rightDrive = 0;
    	
    	DriveMode mode;
    	
    	LX1 = controller1.axisLX();
    	LY1 = controller1.axisLY();
    	RX1 = controller1.axisRX();
    	RY1 = controller1.axisRY();
    	LX2 = controller2.axisLX();
    	LY2 = controller2.axisLY();
    	RX2 = controller2.axisRX();
    	RY2 = controller2.axisRY();
    	
    	// dominance
    	if (LX1 > 0 || LY1 > 0 || RX1 > 0 || RY1 > 0) {
    		LX = LX1;
    		LY = LY1;
    		RX = RX1;
    		RY = RY1;
    		mode = controller1.mode;
    		
    	} else {
    		LX = LX2;
    		LY = LY2;
    		RX = RX2;
    		RY = RY2;
    		mode = controller2.mode;
    	}
    	
    	if (mode == DriveMode.TANK) {
    		
    		leftDrive  = LY;
        	rightDrive = RY;
        	
    	} else if (mode == DriveMode.ARCADE) {
    		
    		double[] lr = arcadeToLR(RX, LY);
    		leftDrive  = lr[0];
    		rightDrive = lr[1];
    	}
    	
    }
    
    public double[] arcadeToLR(double steerAxis, double speedAxis) {
    	double left  = 1;
    	double right = 1;

    	double steerAmount = Math.abs(steerAxis);
    	
    	int steerDirection = (int) Math.signum(steerAxis);
		boolean steerRight = steerDirection > 0;
    	boolean steerLeft  = steerDirection < 0;
    	
        if(steerLeft)  left -= steerAmount;	
        if(steerRight) right -= steerAmount;
        
        left  *= speedAxis;
        right *= speedAxis;
        
        return new double[] {left, right};
    }
    
    public double driveLeft()  { return  leftDrive; }
    public double driveRight() { return rightDrive; }
    public double  grabLeft()  { return  leftGrab;  }
    public double  grabRight() { return rightGrab;  }

}










/*    
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // button.whenPressed(new ExampleCommand());
    // button.whileHeld(new ExampleCommand());
    // button.whenReleased(new ExampleCommand());

	enum DriveMode { TANK, ARCADE }
	private DriveMode controller1Mode;
	private DriveMode controller2Mode;
	
	private double leftDrive;
	private double rightDrive;
	
	public double deadzone;
	
    public Joystick controller1, controller2;
    
    public JoystickButton controller1ButtonA;
    public JoystickButton controller1ButtonB;
    public JoystickButton controller1ButtonX;
    public JoystickButton controller1ButtonY;
    public JoystickButton controller1ButtonLB;
    public JoystickButton controller1ButtonRB;
    public JoystickButton controller1ButtonBack;
    public JoystickButton controller1ButtonStart;
    public JoystickButton controller1ButtonLS;
    public JoystickButton controller1ButtonRS;

    public JoystickButton controller2ButtonA;
    public JoystickButton controller2ButtonB;
    public JoystickButton controller2ButtonX;
    public JoystickButton controller2ButtonY;
    public JoystickButton controller2ButtonLB;
    public JoystickButton controller2ButtonRB;
    public JoystickButton controller2ButtonBack;
    public JoystickButton controller2ButtonStart;
    public JoystickButton controller2ButtonLS;
    public JoystickButton controller2ButtonRS;
    
    public OI() {
    	deadzone = 0.05;
    	
        controller1 = new Joystick(2);
        controller2 = new Joystick(0);
        
        controller1ButtonA       = new JoystickButton(controller1, 1);
        controller1ButtonB       = new JoystickButton(controller1, 2);
        controller1ButtonX       = new JoystickButton(controller1, 3);
        controller1ButtonY       = new JoystickButton(controller1, 4);
        controller1ButtonLB      = new JoystickButton(controller1, 5);
        controller1ButtonRB      = new JoystickButton(controller1, 6);
        controller1ButtonBack    = new JoystickButton(controller1, 7);
        controller1ButtonStart   = new JoystickButton(controller1, 8);
        controller1ButtonLS      = new JoystickButton(controller1, 9);
        controller1ButtonRS      = new JoystickButton(controller1, 10);
                                 
        controller2ButtonA       = new JoystickButton(controller2, 1); 
        controller2ButtonB       = new JoystickButton(controller2, 2); 
        controller2ButtonX       = new JoystickButton(controller2, 3); 
        controller2ButtonY       = new JoystickButton(controller2, 4); 
        controller2ButtonLB      = new JoystickButton(controller2, 5); 
        controller2ButtonRB      = new JoystickButton(controller2, 6); 
        controller2ButtonBack    = new JoystickButton(controller2, 7); 
        controller2ButtonStart   = new JoystickButton(controller2, 8); 
        controller2ButtonLS      = new JoystickButton(controller2, 9); 
        controller2ButtonRS      = new JoystickButton(controller2, 10);
    }
    
    public double  axisLX    (GenericHID controller) { return controller.getRawAxis(0); }
    public double  axisLY    (GenericHID controller) { return controller.getRawAxis(1); }
    public double  axisRX    (GenericHID controller) { return controller.getRawAxis(4); }
    public double  axisRY    (GenericHID controller) { return controller.getRawAxis(5); }
    public double  triggerR  (GenericHID controller) { return controller.getRawAxis(3); }
    public double  triggerL  (GenericHID controller) { return controller.getRawAxis(2); }
    
	public int dPad(GenericHID controller) {
    	int angle = controller.getPOV();
		
		if (angle == -1) return 0;
		if (angle > 337 || angle < 23)  return 1;
		if (angle > 67  && angle < 113) return 2;
		if (angle > 157 && angle < 213) return 3;
		if (angle > 247 && angle < 293) return 4;
		return 0;
    }
	
	public boolean dPadUp    (GenericHID controller) { return dPad(controller) == 1 ? true : false; }
	public boolean dPadRight (GenericHID controller) { return dPad(controller) == 2 ? true : false; }
	public boolean dPadDown  (GenericHID controller) { return dPad(controller) == 3 ? true : false; }
	public boolean dPadLeft  (GenericHID controller) { return dPad(controller) == 4 ? true : false; }
	
	public void mapButtons() {
		controller2ButtonY.whenPressed(new LaunchCubeHigh());
		controller2ButtonA.whenPressed(new LaunchCubeLow());
		new Secure()
		new Exchange()
	}
	
    public double driveLeft() { return leftDrive;  }
    public double drivRight() { return rightDrive; }

    public void inputPeriodic() {
    	updateDriveModes();
    	updateDriveValues();
    }
    
    private void updateDriveModes() {
    	if (controller1ButtonLB.get()) controller1Mode = DriveMode.ARCADE;
    	if (controller1ButtonRB.get()) controller1Mode = DriveMode.TANK;
    	if (controller2ButtonLB.get()) controller2Mode = DriveMode.ARCADE;
    	if (controller2ButtonRB.get()) controller2Mode = DriveMode.TANK;
    }
    
    private void updateDriveValues() {
    	double LX, LY, RX, RY, LX1, LX2, LY1, LY2, RX1, RX2, RY1, RY2;
    	
    	leftDrive = 0;
    	rightDrive = 0;
    	
    	DriveMode mode;
    	
    	LX1 = axisLX(controller1);
    	LY1 = axisLY(controller1);
    	RX1 = axisRX(controller1);
    	RY1 = axisRY(controller1);
    	LX2 = axisLX(controller2);
    	LY2 = axisLY(controller2);
    	RX2 = axisRX(controller2);
    	RY2 = axisRY(controller2);
    	
    	// consider deadzone
    	if( Math.abs(LX1) < deadzone) LX1 = 0;
    	if( Math.abs(LY1) < deadzone) LY1 = 0;
    	if( Math.abs(RX1) < deadzone) RX1 = 0;
    	if( Math.abs(RY1) < deadzone) RY1 = 0;
    	if( Math.abs(LX2) < deadzone) LX2 = 0;
    	if( Math.abs(LY2) < deadzone) LY2 = 0;
    	if( Math.abs(RX2) < deadzone) RX2 = 0;
    	if( Math.abs(RY2) < deadzone) RY2 = 0;
    	
    	// dominance
    	if (LX1 > 0 || LY1 > 0 || RX1 > 0 || RY1 > 0) {
    		LX = LX1;
    		LY = LY1;
    		RX = RX1;
    		RY = RY1;
    		mode = controller1Mode;
    	} else {
    		LX = LX2;
    		LY = LY2;
    		RX = RX2;
    		RY = RY2;
    		mode = controller2Mode;
    	}
    	
    	if (mode == DriveMode.TANK) {
    		leftDrive  = LY;
        	rightDrive = RY;
        	
    	} else if (mode == DriveMode.ARCADE) {
    		
    		double speed = LY;
    		int direction = (int) Math.signum(RX);
    		boolean steerRight = direction > 0;
        	boolean steerLeft  = direction < 0;
        	
        	double steer = Math.abs(RX);
        	
        	double right = 1;
        	double left  = 1;
        	
	        if(steerRight) right -= steer;	
	        if(steerLeft)  left  -= steer;	
	       
	        rightDrive = right * speed; 
	        leftDrive  = left  * speed; 
    	}
    	
    }
    
    */