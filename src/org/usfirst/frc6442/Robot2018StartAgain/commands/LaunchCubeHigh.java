package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;


public class LaunchCubeHigh extends CommandGroup {

    public LaunchCubeHigh() {
        
        addSequential(new LauncherUp());
        addSequential(new LauncherSpinFast());
    	addSequential(new Feed());
    	addSequential(new LaunchDone(1));
    } 
}
