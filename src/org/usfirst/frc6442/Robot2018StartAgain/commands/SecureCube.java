package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class SecureCube extends CommandGroup {

    public SecureCube() {
    	addParallel(new GrabTime(1));
    	addSequential(new Secure());
    } 
}
