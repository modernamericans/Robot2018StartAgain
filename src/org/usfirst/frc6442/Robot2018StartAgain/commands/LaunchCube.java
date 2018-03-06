package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

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
