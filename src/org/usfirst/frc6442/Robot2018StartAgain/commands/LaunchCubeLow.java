package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;


public class LaunchCubeLow extends CommandGroup {

    public LaunchCubeLow() {
    	
        addSequential(new LauncherDown());
        addSequential(new LauncherSpinSlow());
        addSequential(new Feed());
        addSequential(new LaunchDone(1));
    } 
}
