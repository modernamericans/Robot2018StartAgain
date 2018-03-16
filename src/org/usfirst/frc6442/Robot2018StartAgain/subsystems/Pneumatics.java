package org.usfirst.frc6442.Robot2018StartAgain.subsystems;

import org.usfirst.frc6442.Robot2018StartAgain.Robot;
import org.usfirst.frc6442.Robot2018StartAgain.RobotMap;
import org.usfirst.frc6442.Robot2018StartAgain.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends Subsystem {

    private final Compressor compressor1 = RobotMap.compressor;
    private final DoubleSolenoid doubleSolenoid = RobotMap.dblSolenoid;
    

    @Override
    public void initDefaultCommand() { }
       
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

