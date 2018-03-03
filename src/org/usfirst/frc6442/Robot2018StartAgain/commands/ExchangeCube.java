package org.usfirst.frc6442.Robot2018StartAgain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class ExchangeCube extends CommandGroup {
    public ExchangeCube() {
    	addParallel(new ExchangeTime(Robot.values.exchangeTime));
    	addParallel(new PushTime(Robot.values.pushTime));
    } 
}
