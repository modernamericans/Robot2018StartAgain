package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;

public class ExchangeCube extends CommandGroup {
    public ExchangeCube() {
    	addSequential(new Exchange());
    	addSequential(new Push());
    } 
}
