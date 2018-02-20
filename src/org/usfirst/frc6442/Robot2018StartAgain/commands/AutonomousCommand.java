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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;

/**
 *
 */
public class AutonomousCommand extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	int near;
	boolean StartRight;
	boolean StartCenter;
	boolean StartLeft;
	Preferences StartLocation;
//	int time;
	

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	 requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	 if(gameData.charAt(0) == 'L') {
    		near = 0;
    	}
    	else if(gameData.charAt(0) == 'R') {
    		near = 1;
    	}
        
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
       // time = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	
        StartLocation = Preferences.getInstance();
        StartLeft = false;
        StartCenter = false;
        StartRight = false;
    	
        if (StartRight == false && StartLeft == false && StartCenter == false)
        	System.out.println("Why no start Location");
        	if(near == 1)
        		StartLeft = true;
        	else
        		StartRight = true;
        if(StartRight == true)
        	System.out.println("Auto Right Start");
        else if (StartLeft == true)
        	System.out.println("Auto Left Start");
        else if(StartCenter == true)
        	System.out.println("Auto Center Start");
        else {}
        //System Grab block, however that is done      
        //System.out.println("Got Block");
        
        
    	if (near == 1){
    	  	System.out.println("Go to Right Start");
    	  	if(StartLeft == true || StartCenter == true) {
    	  		//driveForward(.5)
    	  			Robot.driveTrain.autonomousForward(.5);
    	  			Timer.delay(1);//need to time things out
    	  			//turnRight(90)
    	  			Robot.driveTrain.autonomousRightTurn(.5);
    	  			Timer.delay(1);
    	  			//driveForward(.5)
    	  			Robot.driveTrain.autonomousForward(.5);
    	  			Timer.delay(1);
    	  			if(StartLeft == true) {
    	  				//driveForward(.5)
    	  				Robot.driveTrain.autonomousForward(.5);
    	  				Timer.delay(1);
    	  			}
    	  			//turnLeft(90)
    	  			Robot.driveTrain.autonomousLeftTurn(.5);
    	  			}
    	  		if(StartRight == true) {
    	  			//driveForward(.5)
    	  			Robot.driveTrain.autonomousForward(.5);
    	  			Timer.delay(1);
    	  		}
    	  		//driveForward(.5)
    	  	Robot.driveTrain.autonomousForward(.5);
    	  	Timer.delay(1);
    	  //turnLeft(90)
    	  	Robot.driveTrain.autonomousLeftTurn(.5);
    	  	Timer.delay(1);
    	  	//eject block;
    	  	//driveReverse(.5);
    	  //turnRight(90)
    	  	Robot.driveTrain.autonomousRightTurn(.5);
    	  	Timer.delay(1);
    	  //driveForward(0)
    	  	Robot.driveTrain.autonomousForward(0);
    	  	}
    	if (near == 0) {
	  	System.out.println("Go to Left Start");
	  	if(StartRight == true || StartCenter == true) {
	  	//driveForward(.5)
	  		Robot.driveTrain.autonomousForward(.5);
	  		Timer.delay(1);//need to time things out
	  	//turnLeft(90)
	  		Robot.driveTrain.autonomousLeftTurn(.5);
	  		Timer.delay(1);
	  	//driveForward(.5)
	  		Robot.driveTrain.autonomousForward(.5);
	  		Timer.delay(1);
	  		if(StartLeft == true){
	  		//driveForward(.5)
	  			Robot.driveTrain.autonomousForward(.5);
	  			Timer.delay(1);
	  		}
	  	//turnRight(90)
	  		Robot.driveTrain.autonomousRightTurn(.5);
	  		}
	  	if(StartRight == true) {
	  	//driveForward(.5)
	  		Robot.driveTrain.autonomousForward(.5);
	  		Timer.delay(1);
	  	}
	  //driveForward(.5)
	  	Robot.driveTrain.autonomousForward(.5);
	  	Timer.delay(1);
	  //turnRight(90)
	  	Robot.driveTrain.autonomousRightTurn(.5);
	  	Timer.delay(1);
	  	//eject block;
	  	//driveReverse(.5);
	  //turnLeft(90)
	  	Robot.driveTrain.autonomousLeftTurn(.5);
	  	Timer.delay(1);
	  //driveForward(0)
	 	Robot.driveTrain.autonomousForward(0);
	  	}
        //  time++;
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
