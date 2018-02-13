// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

/**
 *
 */
public class AutonomousCommand extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	int near;
    	if(gameData.charAt(0) == 'L') {
    		near = 0;
    	}
    	else {
    		near = 1;
    	}
    	    	
    	Preferences StartLocation;
        boolean StartLeft = false;
        boolean StartCenter = false;
        boolean StartRight = false;
        
        StartLocation = Preferences.getInstance();
        StartLeft = false;
        StartCenter = false;
        StartRight = false;
        
        if (StartRight == false && StartLeft == false && StartCenter == false)
        	System.out.println("Please Enter a Start Location");
        else if(StartRight == true)
        	System.out.println("Auto Right Start");
        else if (StartLeft == true)
        	System.out.println("Auto Left Start");
        else if(StartCenter == true)
        	System.out.println("Auto Center Start");
        else {}
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	StartLocation = Preferences.getInstance();
        
        if (StartRight == false && StartLeft == false && StartCenter == false)
        	System.out.println("Please Enter a Start Location");
        else if(StartRight == true)
        	System.out.println("Auto Right Start");
        else if (StartLeft == true)
        	System.out.println("Auto Left Start");
        else if(StartCenter == true)
        	System.out.println("Auto Center Start");
        else {}
    	//start location stuff?
    	//if not set, pick opposite of game info
    	/*
    	if right side == our side;
    	  	go to right start;
    	  		left
    	  		 start/center start;
    	  			Robot.DriveTrain.autoDriveforward(time[seconds, revolution of wheels, something else?])
    	  			Robot.DriveTrain.autoLeftTurn(time);
    	  			Robot.DriveTrain.autoDriveForward(time);
    	  			Robot.DriveTrain.autoRightTurn(time);
    	  		right start;
    	  			Robot.DriveTrain.autoDriveForward(time);
    	  		Robot.DriveTrain.autoDriveForward(time);
    	  		Robot.DriveTrain.autoTurnLeft(time);
    	  		eject block;
    	  		Robot.DriveTrain.autoRightTurn(time);
    	 		Stop;
    	 if left side == our side;
    	 	invert right's and left's under right side;
    	
    	
    */
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
