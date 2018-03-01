package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
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
    public static Launcher launcher;
    public static DistanceSensor distanceSensor;
    public static Grabber grabber;
	
	// Game state
    enum StartPosition { LEFT, CENTER, RIGHT }
	enum OurSide { LEFT, RIGHT }
	
	public StartPosition position;
	
	public OurSide nearSwitch;
	public OurSide scale;
	public OurSide farSwitch;
	
    public Command teleopCommand;
    public SendableChooser<Command> teleopChooser;
    
    // Autonomous
    public String gameMessage;
    
    public Command autoCommand;
    public Command autoDefaultCommand;
    
    public SendableChooser<Command> chooserLLL;
    public SendableChooser<Command> chooserLRL;
    public SendableChooser<Command> chooserRLR;
    public SendableChooser<Command> chooserRRR;
    
    @Override
    public void robotInit() {
		values = new RobotValues();
		prefs  = Preferences.getInstance();
        RobotMap.init();
        
        // Subsystems
        pneumatics        = new Pneumatics();
        driveTrain        = new DriveTrain();
        distributionPanel = new DistributionPanel();
        launcher          = new Launcher();
        distanceSensor    = new DistanceSensor();
        grabber           = new Grabber();

        autoDefaultCommand = new AutonomousDisplay();
        
        initDashboard();      
        
        CameraServer.getInstance().startAutomaticCapture();
        
        // OI must be constructed after subsystems to avoid null pointer exceptions from requires()
        oi = new OI();
        
    }
    
    public void getGameData() {
    	gameMessage = DriverStation.getInstance().getGameSpecificMessage();
		
		if      (gameMessage.charAt(0) == 'L') nearSwitch = OurSide.LEFT;
		else if (gameMessage.charAt(0) == 'R') nearSwitch = OurSide.RIGHT;
		
		if      (gameMessage.charAt(1) == 'L') scale      = OurSide.LEFT;  
		else if (gameMessage.charAt(1) == 'R') scale      = OurSide.RIGHT; 
		
		if      (gameMessage.charAt(2) == 'L') farSwitch  = OurSide.LEFT;  
		else if (gameMessage.charAt(2) == 'R') farSwitch  = OurSide.RIGHT; 
    }
    
    public void setAutonomousCommand() {
    	switch (gameMessage) {
			case "LLL": autoCommand = chooserLLL.getSelected(); break;
			case "LRL": autoCommand = chooserLRL.getSelected(); break;
			case "RLR": autoCommand = chooserRLR.getSelected(); break;
			case "RRR": autoCommand = chooserRRR.getSelected(); break;
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
    	if (autoCommand != null) autoCommand.cancel();
    	teleopCommand = teleopChooser.getSelected();
        if(teleopCommand != null) teleopCommand.start();
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
    
    public void initDashboard() {
    	SmartDashboard.putData(Scheduler.getInstance());
    	SmartDashboard.putData(driveTrain);
    	SmartDashboard.putData(distributionPanel);
    	SmartDashboard.putData(distanceSensor);
    	SmartDashboard.putData(grabber);
    	SmartDashboard.putData(launcher);
    	SmartDashboard.putData(pneumatics);
    	SmartDashboard.putData("Drive Command", new DriveTeleop());
    	SmartDashboard.putData("Autonomous Command",new AutonomousCommand());
    	SmartDashboard.putData("Feed", new Feed());
    	SmartDashboard.putData("AutonomousCenterGoLeft", new AutonomousCenterGoLeft());
    	SmartDashboard.putData("AutonomousCenterGoRight", new AutonomousCenterGoRight());
    	SmartDashboard.putData("AutonomousDisplay", new AutonomousDisplay());
    	SmartDashboard.putData("AutonomousLeftGoLeft", new AutonomousLeftGoLeft());
    	SmartDashboard.putData("AutonomousLeftGoRight", new AutonomousLeftGoRight());
    	SmartDashboard.putData("AutonomousRightGoLeft", new AutonomousRightGoLeft());
    	SmartDashboard.putData("AutonomousRightGoRight", new AutonomousRightGoRight());
    	SmartDashboard.putData("DriveForwardTime(1)", new DriveForwardTime(1.0));
    	SmartDashboard.putData("DriveReverseTime(1)", new DriveReverseTime(1.0));
    	SmartDashboard.putData("DriveStop(2)", new DriveStop(2.0));
    	SmartDashboard.putData("Exchange", new Exchange());
    	SmartDashboard.putData("ExchangeCube", new ExchangeCube());
    	SmartDashboard.putData("Grab", new GrabTeleop());
    	SmartDashboard.putData("LaunchCube(1)", new LaunchCube(1));
    	SmartDashboard.putData("LaunchDone(1)", new LaunchDone(1));
    	SmartDashboard.putData("LauncherControl", new LauncherControl());
    	SmartDashboard.putData("LauncherDown", new LauncherDown());
    	SmartDashboard.putData("LauncherRaw", new LauncherRaw());
    	SmartDashboard.putData("LauncherSpinFast", new LauncherSpinFast());
    	SmartDashboard.putData("LauncherSpinSlow", new LauncherSpinSlow());
    	SmartDashboard.putData("LauncherUp", new LauncherUp());
    	SmartDashboard.putData("PneumaticsLeveler", new PneumaticsLeveler());
    	SmartDashboard.putData("PrepLaunch", new PrepLaunch());
    	SmartDashboard.putData("Push", new Push());
    	SmartDashboard.putData("Secure", new Secure());
    	SmartDashboard.putData("SecureCube", new SecureCube());
    	SmartDashboard.putData("TeleopCommand", new TeleopCommand());
    	SmartDashboard.putData("TurnLeft(90)", new TurnLeft(90.0));
    	SmartDashboard.putData("TurnRight(90)", new TurnRight(90.0));
    	
    	// Autonomous choosers
    	chooserLLL = new SendableChooser<Command>(); 
    	chooserLRL = new SendableChooser<Command>(); 
    	chooserRLR = new SendableChooser<Command>(); 
    	chooserRRR = new SendableChooser<Command>(); 
    	
    	List<SendableChooser<Command>> choosers = Arrays.asList(chooserLLL, chooserLRL, chooserRLR, chooserRRR);
    	
        List<Command> autoCommands = Arrays.asList(
        		new AutonomousCommand()
        );
        for (SendableChooser<Command> chooser : choosers) {
	        for (Command command : autoCommands) {
	        	chooser.addObject(c.getClass().getName(), command);
	        }
	        chooser.addDefault("Autonomous Command", autoDefaultCommand);
        }
        
        SmartDashboard.putData("Auto if LLL", chooserLLL);
        SmartDashboard.putData("Auto if LRL", chooserLRL);
        SmartDashboard.putData("Auto if RLR", chooserRLR);
        SmartDashboard.putData("Auto if RRR", chooserRRR);
        
        
        // Teleop chooser
        teleopChooser.addObject("Arcade", new ArcadeDrive());
        teleopChooser.addDefault("Tank", new TankDrive());
        SmartDashboard.putData("Start teleop with:", teleopChooser);
    	
    }	
    

}
