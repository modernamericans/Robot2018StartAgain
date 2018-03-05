package org.usfirst.frc6442.Robot2018StartAgain;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
//import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private double  leftDrive ;
	private double rightDrive ;
	private double  leftGrab  ;
	private double rightGrab  ;
	private double secureSpeed;
	
    public Controller controller1;
    public Controller controller2;
    
    public OI() {	
        controller1 = new Controller(2);
        controller2 = new Controller(0);
        mapButtons();
    }
    
    // make sure this is called
    public void inputPeriodic() {
    	controller1.update();
    	controller2.update();
    	updateGrabValues();
    	updateDriveValues();
    	updateSecureValues();
    }
    
	public void mapButtons() {
		controller1.buttonY    .whenPressed( new LaunchCubeHigh() );
		controller2.buttonY    .whenPressed( new LaunchCubeHigh() );
		
		controller1.buttonA    .whenPressed( new LaunchCubeLow()  );
		controller2.buttonA    .whenPressed( new LaunchCubeLow()  );
		
		controller1.buttonDown .whileActive( new Secure()     );
		controller2.buttonDown .whileActive( new Secure()     );
		
		controller1.buttonUp   .whileActive( new Exchange()   );
		controller2.buttonUp   .whileActive( new Exchange()   );
		
		Command updateValues = new InstantCommand() { protected void initialize(){ 
			Robot.values.update(); 
		}};
		
		controller1.buttonStart   .whenPressed( updateValues );
		controller2.buttonStart   .whenPressed( updateValues );
	}


    
    private void updateGrabValues() {
    	double TL, TR, TL1, TR1, RAxis, LAxis;
    	
    	TL1 = controller1.triggerL();
    	TR1 = controller1.triggerR();
    	//TL2 = controller2.triggerL();
    	//TR2 = controller2.triggerR();
    	
    	RAxis = controller2.axisRY();
    	LAxis = controller2.axisLY();
    	
    	// dominance is max only
    	TL = TL1;//Math.max(TL1, TL2);
    	TR = TR1;//Math.max(TR1, TR2);
    	
		leftGrab  = LAxis != 0 ? LAxis : TR - TL ;
		rightGrab = RAxis != 0 ? RAxis : TR - TL ;
		//System.out.println("Afirmative " + leftGrab + " " + rightGrab);
    }
    private void updateSecureValues() {
    	double TL, TR, TL1, TL2, TR1, TR2, RAxis, LAxis;
    	
    	//TL1 = controller1.triggerL();
    	//TR1 = controller1.triggerR();
    	TL2 = controller2.triggerL();
    	TR2 = controller2.triggerR();
    	
    	//RAxis = controller2.axisRY();
    //	LAxis = controller2.axisLY();
    	
    	// dominance is max only
    	leftGrab =TL2;// Math.max(TL1, TL2);
    	rightGrab = TR2;//Math.max(TR1, TR2);
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
    	LX = LX1;
		LY = LY1;
		RX = RX1;
		RY = RY1;
		mode = controller1.mode;
		
    	if (Robot.values.pairDrive) {
	    	if (LX1 == 0 && LY1 == 0 && RX1 == 0 && RY1 == 0) {
	    		LX = LX2;
	    		LY = LY2;
	    		RX = RX2;
	    		RY = RY2;
	    		mode = controller2.mode;
	    	}
    	}
    	
    	if (mode == DriveMode.TANK) {
    		
    		leftDrive  = LY;
        	rightDrive = RY;
        	
    	} else if (mode == DriveMode.ARCADE) {
    		if (Robot.values.spinInArcade && LY < Robot.values.spinYRange && LX > Robot.values.spinXRange) {
    			leftDrive  =  LX;
    			rightDrive = -LX;
    		} else {
    			double[] lr = arcadeToLR(RX, LY);
        		leftDrive  = lr[0];
        		rightDrive = lr[1];
    		}
    		
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
    
    public double driveLeft () { return  leftDrive; }
    public double driveRight() { return rightDrive; }
    public double  grabLeft () { return  leftGrab;  }
    public double  grabRight() { return rightGrab;  }
    public double  getSecure() { return secureSpeed; }

}