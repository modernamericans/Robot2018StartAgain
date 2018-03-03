package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.networktables.NetworkTableInstance;

import org.usfirst.frc6442.Robot2018StartAgain.autonomous.*;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {
	
    public static RobotValues values;
    public static Preferences prefs;
    public static OI oi;
    
    // Subsystems
    public static Pneumatics pneumatics;
    public static DriveTrain driveTrain;
    public static DistributionPanel distributionPanel;
    public static Feeder feeder;
    public static Launcher launcher;
    public static DistanceSensor distanceSensor;
    public static Grabber grabber;
	
	// Game state
    public enum StartPosition { LEFT, CENTER, RIGHT }
	public enum OurSide { LEFT, RIGHT }
	
    public static String gameMessage;
    
	public static StartPosition position;
	
	public static OurSide nearSwitch;
	public static OurSide scale;
	public static OurSide farSwitch;
	
    public Command teleopCommand;
    
    // Autonomous
    public Command autoCommand;
    public static Command autoDefaultCommand;
    
    @Override
    public void robotInit() {
		values = new RobotValues();
		prefs  = Preferences.getInstance();
        RobotMap.init();
        
        // Subsystems
        pneumatics        = new Pneumatics();
        driveTrain        = new DriveTrain();
        distributionPanel = new DistributionPanel();
        feeder            = new Feeder();
        launcher          = new Launcher();
        distanceSensor    = new DistanceSensor();
        grabber           = new Grabber();

        autoDefaultCommand = new AutonomousDisplay();
        
        RobotDashboard.initDashboard();      
        
        CameraServer.getInstance().startAutomaticCapture();
        
        // OI must be constructed after subsystems to avoid null pointer exceptions from requires()
        oi = new OI();
    }
    
    public void getGameData() {
    	gameMessage = DriverStation.getInstance().getGameSpecificMessage();
		
		if      (gameMessage.charAt(0) == 'L') Robot.nearSwitch = OurSide.LEFT;
		else if (gameMessage.charAt(0) == 'R') Robot.nearSwitch = OurSide.RIGHT;
		                                       
		if      (gameMessage.charAt(1) == 'L') Robot.scale      = OurSide.LEFT;  
		else if (gameMessage.charAt(1) == 'R') Robot.scale      = OurSide.RIGHT; 
		                                      
		if      (gameMessage.charAt(2) == 'L') Robot.farSwitch  = OurSide.LEFT;  
		else if (gameMessage.charAt(2) == 'R') Robot.farSwitch  = OurSide.RIGHT; 
    }
    
    public void setAutonomousCommand() {
    	switch (gameMessage) {
			case "LLL": autoCommand = RobotDashboard.chooserLLL.getSelected(); break;
			case "LRL": autoCommand = RobotDashboard.chooserLRL.getSelected(); break;
			case "RLR": autoCommand = RobotDashboard.chooserRLR.getSelected(); break;
			case "RRR": autoCommand = RobotDashboard.chooserRRR.getSelected(); break;
    	}
    }

    @Override
    public void autonomousInit() {
    	getGameData();
    	setAutonomousCommand();
    
        if (autoCommand   != null) autoCommand.start();
        if (teleopCommand != null) teleopCommand.cancel();
    }
    
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
    	teleopCommand = RobotDashboard.teleopChooser.getSelected();
    	if (autoCommand   != null) autoCommand.cancel();
        if (teleopCommand != null) teleopCommand.start();
    }

    @Override
    public void teleopPeriodic() {
    	Robot.oi.inputPeriodic();
    	Scheduler.getInstance().run();
    }
    
    @Override
    public void disabledInit(){

    }
    
    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
}