package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Motors
    public static SpeedController driveCtrlRight;
    public static SpeedController driveCtrlLeft;
    public static SpeedControllerGroup driveCtrlBoth;
    
    public static SpeedController feedCtrl;
    public static SpeedController launchCtrl;
    
    public static SpeedController grabCtrlRight;
    public static SpeedController grabCtrlLeft;
    public static SpeedControllerGroup grabCtrlBoth;
    
    // Sensors
    public static Ultrasonic distSensor1;
    public static Ultrasonic distSensor2;
	public static ADXRS450_Gyro gyro;
	public static Accelerometer accel;
	public static DigitalInput feedSwitch;
	
	// CAN Controlled
    public static Compressor pneumaticsCompressor;
    public static DoubleSolenoid pneumaticsDoubleSolenoid;
    
	public static PowerDistributionPanel powerDist;

    public static void init() {
    	RobotValues v = Robot.values;
    	
    	if (!v.skipCAN) {
    		pneumaticsCompressor     = new Compressor();
	        pneumaticsDoubleSolenoid = new DoubleSolenoid(v.solenoidForwardChannel, v.solenoidReverseChannel);
	        powerDist                = new PowerDistributionPanel();
	        
	        //double current = powerDist.getCurrent(intPortNum); //in amps
    	}
        
        driveCtrlRight = new Spark(v.rightDrivePWM);
        driveCtrlRight.setInverted(v.rightDriveInvert);
        driveCtrlLeft  = new Spark(v.leftDrivePWM);
        driveCtrlLeft .setInverted(v.leftDriveInvert);
        driveCtrlBoth  = new SpeedControllerGroup(driveCtrlRight, driveCtrlLeft);
        
        feedCtrl   = new Spark(v.feederPWM);
        feedCtrl  .setInverted(v.feederInvert);
        launchCtrl = new Spark(v.launcherPWM);
        launchCtrl.setInverted(v.launcherInvert);
        
        grabCtrlRight = new Spark(v.grabberRightPWM);
        grabCtrlRight.setInverted(v.grabberRightInvert);
        grabCtrlLeft  = new Spark(v.grabberLeftPWM);
        grabCtrlLeft .setInverted(v.grabberLeftInvert);
        grabCtrlBoth = new SpeedControllerGroup(grabCtrlRight, grabCtrlLeft  );
		
		distSensor1 = new Ultrasonic(v.echoPortOut1, v.triggerPortIn1);
		distSensor2 = new Ultrasonic(v.echoPortOut2, v.triggerPortIn2);
		distSensor1.setAutomaticMode(true);
		distSensor2.setAutomaticMode(true);
		gyro = new ADXRS450_Gyro();
		accel = new BuiltInAccelerometer();
		feedSwitch = new DigitalInput(v.feedSwitchPortIn);
		
		// boolean isSecure = feedSwitch.get();
		
		// double xVal = accel.getX();
		// double yVal = accel.getY();
		// double zVal = accel.getZ();
    }
}
