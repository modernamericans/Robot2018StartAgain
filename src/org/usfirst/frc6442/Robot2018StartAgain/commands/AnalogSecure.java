package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Feeder;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.Grabber;

public class AnalogSecure extends Command {
	protected Feeder feeder = Robot.feeder;
	
    public AnalogSecure() {
        requires(Robot.feeder);
    }

    @Override
    protected void initialize() {
    	
    }

    @Override
    protected void execute() {
    	double  secure = Robot.oi.getSecure();
    	
    	feeder.secure(secure);
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }
    
    @Override
    protected void end() {
    	feeder.stop();
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
