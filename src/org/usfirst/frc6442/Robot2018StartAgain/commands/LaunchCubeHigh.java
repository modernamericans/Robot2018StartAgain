package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;


public class LaunchCubeHigh extends CommandGroup {

    public LaunchCubeHigh() {
        
        addSequential(new LauncherUp());
        addSequential(new LauncherSpinFast());
    	addSequential(new Feed());
        addSequential(new WaitCommand(Robot.values.launchWait));
        addSequential(new LaunchDone());
    } 
}
