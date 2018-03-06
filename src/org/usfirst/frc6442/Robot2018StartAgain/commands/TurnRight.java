package org.usfirst.frc6442.Robot2018StartAgain.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;

public class TurnRight extends Command {

public double turn;
//public Timer timer;
public double heading;
public TurnRight(double turnDegrees) {

	 requires(Robot.driveTrain);
	 turn = turnDegrees;///450 number to change with timing
	 //timer = new Timer();
}

@Override
protected void initialize() {
	 heading = RobotMap.gyro.getAngle(); 
	 //timer.start();
	 Robot.driveTrain.rightTurn();
	 System.out.println("WE'RE GONNA SPIN AROUND CLOCKWISE TONIGHT");
}

@Override
protected void execute() {
}

@Override
protected boolean isFinished() {
   //return timer.get()>turn;
   double angleNow = RobotMap.gyro.getAngle();
   return angleNow>heading+turn;
}

@Override
protected void end() {
	 Robot.driveTrain.stop();
}
@Override
protected void interrupted() {
}
}