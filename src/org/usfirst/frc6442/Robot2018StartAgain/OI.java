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
 
	private double driveLeft ;
	private double driveRight;
	private double grabLeft  ;
	private double grabRight ;
	private double feed      ;

	public double getDriveLeft () { return driveLeft ; }
	public double getDriveRight() { return driveRight; }
	public double getGrabLeft ()  { return grabLeft  ; }
	public double getGrabRight()  { return grabRight ; }
	public double getFeed()       { return feed      ; }

	public Controller controller1;
	public Controller controller2;
	
	public OI() {
			controller1 = new Controller(0);
			controller2 = new Controller(1);
			mapButtons();
	}
	
	// make sure this is called
	public void inputPeriodic() {
		controller1.update();
		controller2.update();
		updateMode(controller1);
		updateDriveValues();
		updateGrabberValues();
		updateFeederValues();
	}

	public void updateMode(Controller controller) {
		if (controller.buttonLB.get()) controller.mode = DriveMode.ARCADE;
		if (controller.buttonRB.get()) controller.mode = DriveMode.TANK;
	}
		
	public void mapButtons() {
		commonButtons(controller1);
		commonButtons(controller2);
	}

	public void commonButtons(Controller controller) {

		Command updateValues = new InstantCommand() { protected void initialize(){ 
			Robot.values.update(); 
		}};

		controller.buttonStart .whenPressed( updateValues         );
		controller.buttonY     .whenPressed( new LaunchCubeHigh() );
		controller.buttonA     .whenPressed( new LaunchCubeLow()  );
		controller.buttonDown  .whileActive( new SecureToSwitch()         );
		controller.buttonUp    .whileActive( new Exchange()       );
	}

	private void updateFeederValues() {
		double RT = controller2.triggerR();
		double LT = controller2.triggerL();
		feed = RT - LT;
	}
		
	private void updateGrabberValues() {
		double TL = controller1.triggerL();
		double TR = controller1.triggerR();
		
		double RAxis = controller2.axisRY();
		double LAxis = controller2.axisLY();

		if (RAxis > 0 || LAxis > 0) {
			grabLeft  = LAxis;
			grabRight = RAxis;
		} else {
			grabLeft  = TR - TL;
			grabRight = TR - TL;
		}
	}

	private void updateDriveValues() {
		double LX = controller1.axisLX();
		double LY = controller1.axisLY();
		double RX = controller1.axisRX();
		double RY = controller1.axisRY();

		DriveMode mode = controller1.mode;
		
		if (mode == DriveMode.TANK) {
			
			driveLeft  = LY;
			driveRight = RY;
				
		} else if (mode == DriveMode.ARCADE) {

			LR vals = arcadeToLR(RX, LY);
			driveLeft  = vals.left;
			driveRight = vals.right;

			// boolean spin = (Math.abs(LX) > Robot.values.spinYRange) && (Math.abs(LY) < Robot.values.spinYRange);
			// if (spin) {
			// 	leftDrive  =  LX;
			// 	rightDrive = -LX;
			// } 
		}
	}
	
	public class LR {
		public final double left;
		public final double right;
		public LR(double left, double right) {
			this.left  = left;
			this.right = right;
		}
	}
	
	public LR arcadeToLR(double steerAxis, double speedAxis) {
		double left  = 1;
		double right = 1;

		double steerAmount = Math.abs(steerAxis);
		
		int steerDirection = (int) Math.signum(steerAxis);

		boolean steerRight = steerDirection > 0;
		boolean steerLeft  = steerDirection < 0;
		
		if (steerLeft ) left  -= steerAmount;	
		if (steerRight) right -= steerAmount;
		
		left  *= speedAxis;
		right *= speedAxis;
		
		return new LR(left, right);
	}
}