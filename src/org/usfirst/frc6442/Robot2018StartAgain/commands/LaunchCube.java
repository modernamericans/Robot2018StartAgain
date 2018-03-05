// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

/**
 *
 */
public class LaunchCube extends CommandGroup {

    public LaunchCube(int height) {

    	if(height == 0) {  //launch low
    		addSequential(new LauncherDown());
    		addSequential(new LauncherSpinSlow());
    		
    	}
    	
    	else if(height == 1) {  //launch high
    		addSequential(new LauncherUp());
    		addSequential(new LauncherSpinFast());
    	}
    	
    	addSequential(new Feed());
    	addSequential(new LaunchDone(1));
    } 
}
