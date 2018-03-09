package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controller extends Joystick {
	public enum Mode{TANK, ARCADE}
	public Mode mode = Mode.TANK;
	public JoystickButton A = new JoystickButton(this, 1);
	public JoystickButton B = new JoystickButton(this, 2);
	public JoystickButton X = new JoystickButton(this, 3);
	public JoystickButton Y = new JoystickButton(this, 4);
	public JoystickButton LB = new JoystickButton(this, 5);
	public JoystickButton RB = new JoystickButton(this, 6);
	public JoystickButton Back = new JoystickButton(this, 7);
	public JoystickButton Start = new JoystickButton(this, 8);
	public JoystickButton LF = new JoystickButton(this, 9);
	public JoystickButton RF = new JoystickButton(this, 10);
	
	public Controller(int id) {
		super(id);
		}
	public double axisLX() {
			return this.getRawAxis(0);
		}
	public double axisLY() {
		return - this.getRawAxis(1);
	}
	public double axisRX() {
		return this.getRawAxis(4);
	}
	public double axisRY() {
		return - this.getRawAxis(5);
	}
	public double axisLT() {
		return this.getRawAxis(2);
	}
	public double axisRT() {
		return this.getRawAxis(3);
	}
}
