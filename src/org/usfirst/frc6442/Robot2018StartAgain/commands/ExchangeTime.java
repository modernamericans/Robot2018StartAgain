package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;

public class ExchangeTime extends TimedCommand {

	public Feeder feeder = Robot.feeder;
	
	public ExchangeTime(double time) {
		super(time);
		requires(Robot.feeder);
	}
	
    protected void initialize() {
    	feeder.exchange();
    }

    protected void end() {
    	feeder.stop();
    }

    protected void interrupted() {
    	end();
    }
}
