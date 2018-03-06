package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class TurnLeft extends Command {

public double turn;

public double heading;

public TurnLeft(double turnDegrees) {

	 requires(Robot.driveTrain);
	 turn = turnDegrees;//number to change with timing
	 //timer = new Timer();
}

@Override
protected void initialize() {
	// timer.start();
	heading = RobotMap.gyro.getAngle();
	 Robot.driveTrain.leftTurn();
	 System.out.println("WE'RE GONNA SPIN COUNTER-CLOCKWISE TONIGHT");
	 heading = RobotMap.gyro.getAngle(); 
}
@Override
protected void execute() {
}

@Override
protected boolean isFinished() {
   //return timer.get()>turn;
   double angleNow = RobotMap.gyro.getAngle();

   
   double target = heading - turn; 
   System.out.println("Target =" + target );
   System.out.println("angleNow =" + angleNow);
   return angleNow < heading - turn;
}

@Override
protected void end() {
	 Robot.driveTrain.stop();
}

@Override
protected void interrupted() {
}
}
