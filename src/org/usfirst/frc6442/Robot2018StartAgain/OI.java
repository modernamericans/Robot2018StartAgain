// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6442.Robot2018StartAgain;

import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc6442.Robot2018StartAgain.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
//    public JoystickButton buttonA;
//    public JoystickButton buttonB;
//    public JoystickButton buttonX;
//    public JoystickButton buttonY;
//    public JoystickButton buttonRB;
//    public JoystickButton buttonLB;
//    public JoystickButton buttonStart;
//    public JoystickButton buttonBack;
//    public JoystickButton buttonLS;
//    public JoystickButton buttonRS;
//    public Joystick joystick, joystickLaunch;
//    public JoystickButton buttonY2;
//    public JoystickButton buttonA2;
    
    public XboxController xbox = new XboxController(1);
    public XboxController xbox2 = new XboxController(2);
    
    
    public double rightStickVertical(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getY(Hand.kRight);
    }
    
    public double leftStickVertical(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getY(Hand.kLeft);
    }
    
    public double rightStickHorizontal(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getX(Hand.kRight);
    }
    
    public double leftStickHorizontal(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getX(Hand.kLeft);
    }
    
    public double rightTrigger(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getTriggerAxis(Hand.kRight);
    }
    
    public double leftTrigger(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getTriggerAxis(Hand.kLeft);
    }
    
    public boolean leftBumper(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getBumper(Hand.kLeft);
    }
    
    public boolean rightBumper(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getBumper(Hand.kRight);
    }
    
    public boolean buttonA(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getAButton();
    }
    
    public boolean buttonY(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getYButton();
    }
    
    public boolean buttonB(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getBButton();
    }
    
    public boolean buttonX(int controllerNumber) {
    	
    	XboxController controller = xbox;
    	
    	if(controllerNumber == 2) {
    		controller = xbox2;
    	}
    	return controller.getXButton();
    }
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

//        joystick = new Joystick(2);
//        joystickLaunch = new Joystick(0);
//        
//        
//        dPadUpLaunch = new JoystickButton(joystickLaunch, 1);
//        
//        dPadDownLaunch = new JoystickButton(joystickLaunch, 2);
//        
//        buttonA = new JoystickButton(joystickLaunch, 2);
//        
//        buttonB = new JoystickButton(joystickLaunch, 3);
//         // dpad is being used to raise and lower the pneumatics system on a second controller. Also, A is going to
//        //be a set speed for launching into the switch and B is going to be a set speed to launch onto the scale. 
//       
//        buttonBack = new JoystickButton(joystick, 7);
//        
//        //buttonStart = new JoystickButton(joystick, 8);
//       
//        buttonLB = new JoystickButton(joystick, 5);
//        
//        buttonRB = new JoystickButton(joystick, 6);
//        
//        buttonY = new JoystickButton(joystick, 4);
//        
//        buttonX = new JoystickButton(joystick, 3);
//        
//        buttonB = new JoystickButton(joystick, 2);
//        
//        buttonA = new JoystickButton(joystick, 1);
//       //buttonA.whenPressed(new AutonomousCommand());
//       buttonLS = new JoystickButton(joystick, 9);
//       
//       buttonRS = new JoystickButton(joystick, 10);
       
       
       


//        // SmartDashboard Buttons
//        SmartDashboard.putData("LaunchCube", new LaunchCube());
//        SmartDashboard.putData("Secure", new Secure());
//        SmartDashboard.putData("Teleop Command", new TeleopCommand());
//        SmartDashboard.putData("DriveCommand", new DriveCommand());
//        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
//        SmartDashboard.putData("Grab", new Grab());
//        SmartDashboard.putData("Exchange", new Exchange());
//        SmartDashboard.putData("Push", new Push());
//        SmartDashboard.putData("Feed", new Feed());
//        SmartDashboard.putData("PrepLaunch", new PrepLaunch());
//        SmartDashboard.putData("LaunchDone", new LaunchDone());
//        SmartDashboard.putData("SecureCube", new SecureCube());
//        SmartDashboard.putData("ExchangeCube", new ExchangeCube());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    //public Joystick getJoystick() {
        //return joystick;
    //}


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

