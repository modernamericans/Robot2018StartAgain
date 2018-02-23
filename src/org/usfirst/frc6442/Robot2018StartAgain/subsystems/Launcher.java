// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Launcher extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	 private final SpeedController launcherStage1 = RobotMap.launcherLaunchStage1;
	 private final SpeedController launcherStage2 = RobotMap.launcherLaunchStage2;
//    private final SpeedController launchStage1R = RobotMap.launcherLaunchStage1R;
//    private final SpeedController launchStage1L = RobotMap.launcherLaunchStage1L;
//    private final SpeedControllerGroup launcherStage1Group = RobotMap.launcherLauncherStage1Group;
//    private final SpeedController launcherStage2R = RobotMap.launcherLauncherStage2R;
//    private final SpeedController launcherStage2L = RobotMap.launcherLauncherStage2L;
//    private final SpeedControllerGroup launcherStage2Group = RobotMap.launcherLauncherStage2Group;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        setDefaultCommand(new LauncherRaw());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    	
    	//when button pressed, launch?
    	//when button pressed, intake?

    }

    public void secure() {
    	
    }
    
    public void exchange() {
    	
    }
    
    public void feed() {
    	
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

