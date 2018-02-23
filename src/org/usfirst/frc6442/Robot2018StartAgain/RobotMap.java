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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Compressor pneumaticsCompressor1;
    public static Solenoid pneumaticsSolenoid1;
    public static Solenoid pneumaticsSolenoid2;
    public static SpeedController driveTrainDrive1;
    public static SpeedController driveTrainDrive2;
    public static SpeedControllerGroup driveTrainSpeedControllerGroup1;
    public static PowerDistributionPanel distributionPanelPowerDistributionPanel1;
    public static SpeedController launcherLaunchStage1R;
    public static SpeedController launcherLaunchStage1L;
    public static SpeedControllerGroup launcherLauncherStage1Group;
    public static SpeedController launcherLauncherStage2R;
    public static SpeedController launcherLauncherStage2L;
    public static SpeedControllerGroup launcherLauncherStage2Group;
    public static Ultrasonic distanceSensorUltrasonic1;
    public static SpeedController grabberGrabberR;
    public static SpeedController grabberGrabberL;
    public static SpeedControllerGroup grabberGrabbingGroup;
	public static ADXRS450_Gyro gyro;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        pneumaticsCompressor1 = new Compressor(0);
        LiveWindow.addActuator("Pneumatics", "Compressor 1", pneumaticsCompressor1);
        
        pneumaticsSolenoid1 = new Solenoid(0, 0);
        LiveWindow.addActuator("Pneumatics", "Solenoid 1", pneumaticsSolenoid1);
        
        pneumaticsSolenoid2 = new Solenoid(0, 3);
        LiveWindow.addActuator("Pneumatics", "Solenoid 2", pneumaticsSolenoid2);
        
        driveTrainDrive1 = new Spark(0);
        LiveWindow.addActuator("DriveTrain", "Drive 1", (Spark) driveTrainDrive1);
        driveTrainDrive1.setInverted(false);
        driveTrainDrive2 = new Spark(1);
        LiveWindow.addActuator("DriveTrain", "Drive 2", (Spark) driveTrainDrive2);
        driveTrainDrive2.setInverted(false);
        driveTrainSpeedControllerGroup1 = new SpeedControllerGroup(driveTrainDrive1, driveTrainDrive2  );
        LiveWindow.addActuator("DriveTrain", "Speed Controller Group 1", driveTrainSpeedControllerGroup1);
        
        distributionPanelPowerDistributionPanel1 = new PowerDistributionPanel(0);
        LiveWindow.addSensor("DistributionPanel", "PowerDistributionPanel 1", distributionPanelPowerDistributionPanel1);
        
        launcherLaunchStage1R = new Spark(2);
        LiveWindow.addActuator("Launcher", "Launch Stage 1R", (Spark) launcherLaunchStage1R);
        launcherLaunchStage1R.setInverted(false);
        launcherLaunchStage1L = new Spark(3);
        LiveWindow.addActuator("Launcher", "Launch Stage 1L", (Spark) launcherLaunchStage1L);
        launcherLaunchStage1L.setInverted(false);
        launcherLauncherStage1Group = new SpeedControllerGroup(launcherLaunchStage1R, launcherLaunchStage1L  );
        LiveWindow.addActuator("Launcher", "Launcher Stage 1 Group ", launcherLauncherStage1Group);
        
        launcherLauncherStage2R = new Spark(5);
        LiveWindow.addActuator("Launcher", "Launcher Stage 2R", (Spark) launcherLauncherStage2R);
        launcherLauncherStage2R.setInverted(false);
        launcherLauncherStage2L = new Spark(4);
        LiveWindow.addActuator("Launcher", "Launcher Stage 2L", (Spark) launcherLauncherStage2L);
        launcherLauncherStage2L.setInverted(false);
        launcherLauncherStage2Group = new SpeedControllerGroup(launcherLauncherStage2R, launcherLauncherStage2L  );
        LiveWindow.addActuator("Launcher", "Launcher Stage 2 Group", launcherLauncherStage2Group);
        
        distanceSensorUltrasonic1 = new Ultrasonic(0, 1);
        LiveWindow.addSensor("DistanceSensor", "Ultrasonic 1", distanceSensorUltrasonic1);
        
        grabberGrabberR = new Spark(6);
        LiveWindow.addActuator("Grabber", "GrabberR", (Spark) grabberGrabberR);
        grabberGrabberR.setInverted(true);
        grabberGrabberL = new Spark(7);
        LiveWindow.addActuator("Grabber", "GrabberL", (Spark) grabberGrabberL);
        grabberGrabberL.setInverted(false);
        grabberGrabbingGroup = new SpeedControllerGroup(grabberGrabberR, grabberGrabberL  );
        LiveWindow.addActuator("Grabber", "Grabbing Group", grabberGrabbingGroup);
		gyro = new ADXRS450_Gyro();
		 

        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
