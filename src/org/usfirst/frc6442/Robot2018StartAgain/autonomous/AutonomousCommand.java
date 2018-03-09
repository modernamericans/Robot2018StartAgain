/*package org.usfirst.frc6442.Robot2018StartAgain.autonomous;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;

public class AutonomousCommand extends InstantCommand {

    public AutonomousCommand() {}

    protected void initialize() {
        if(Robot.nearSwitch == Robot.OurSide.RIGHT) {
        	
        	if(Robot.position == Robot.StartPosition.RIGHT)
        		Scheduler.getInstance().add(new AutonomousRightGoRight());
        	
        	if(Robot.position == Robot.StartPosition.CENTER)
        		Scheduler.getInstance().add(new AutonomousCenterGoRight());
        	
        	if(Robot.position == Robot.StartPosition.LEFT)
        		Scheduler.getInstance().add(new AutonomousLeftGoRight());
        	
        	
        } else if(Robot.nearSwitch == Robot.OurSide.LEFT) {
        	
        	if(Robot.position == Robot.StartPosition.RIGHT)
        		Scheduler.getInstance().add(new AutonomousRightGoLeft());
        	
        	if(Robot.position == Robot.StartPosition.CENTER)
        		Scheduler.getInstance().add(new AutonomousCenterGoLeft());
        	
        	if(Robot.position == Robot.StartPosition.LEFT)
        		Scheduler.getInstance().add(new AutonomousLeftGoLeft());
        }

    }
}
*/