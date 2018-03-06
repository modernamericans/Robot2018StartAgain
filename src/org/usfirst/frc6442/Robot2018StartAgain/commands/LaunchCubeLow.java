package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;


public class LaunchCubeLow extends CommandGroup {

    public LaunchCubeLow() {
    	
      //  addSequential(new LauncherDown());
        addSequential(new LauncherOff());
    	addSequential(new LauncherSpinSlow());
        addSequential(new FeedSlow());
        addSequential(new WaitCommand(Robot.values.launchWait));
        addSequential(new LaunchDone());
    } 
}
