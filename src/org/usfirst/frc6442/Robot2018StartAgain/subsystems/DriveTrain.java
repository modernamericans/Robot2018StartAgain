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
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController drive1 = RobotMap.driveTrainDrive1;
    private final SpeedController drive2 = RobotMap.driveTrainDrive2;
    private final SpeedControllerGroup speedControllerGroup1 = RobotMap.driveTrainSpeedControllerGroup1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        //Set the default command for a subsystem here.
       setDefaultCommand(new DriveCommand());
    }
    
    public void joyDrive(double rightMagnitude, double leftMagnitude) {
    	drive1.set(rightMagnitude);
    	drive2.set(leftMagnitude);
    	System.out.println("joyDrive output:" + rightMagnitude + " " + leftMagnitude);
    }
    
    public void stop() {
    	drive1.set(0);
    	drive2.set(0);
    	
    }
    @Override
    public void periodic() {
        // Put code here to be run every loop
    
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

