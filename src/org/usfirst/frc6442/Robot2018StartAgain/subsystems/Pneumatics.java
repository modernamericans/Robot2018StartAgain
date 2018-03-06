package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends Subsystem {

    private final Compressor compressor1 = RobotMap.pneumaticsCompressor1;
    private final Solenoid solenoid1 = RobotMap.pneumaticsSolenoid1;
    private final Solenoid solenoid2 = RobotMap.pneumaticsSolenoid2;
    private final DoubleSolenoid doubleSolenoid = RobotMap.pneumaticsDoubleSolenoid;

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
    	/*Compressor c = new Compressor(0);
    	
    	boolean enabled = c.enabled();
    	boolean pressureSwitch = c.getPressureSwitchValue();
    	double current = c.getCompressorCurrent();
    	*/
    }
    
    
    public void up() {
      doubleSolenoid.set(DoubleSolenoid.Value.kForward);   
    }
    public void down() {
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);   
      } 
    public void off() {
        doubleSolenoid.set(DoubleSolenoid.Value.kOff);   

      }
}

