package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.*;

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
	public JoystickButton LS = new JoystickButton(this, 9);
	public JoystickButton RS = new JoystickButton(this, 10);
	public DPadButton Up = new DPadButton(this, 0);
	public DPadButton Right = new DPadButton(this, 2);
	public DPadButton Down = new DPadButton(this, 4);
	public DPadButton Left = new DPadButton(this, 6);
	
	
	public Controller(int id) {
		super(id);
		}
	public double axisLX() {
			return deadZone(this.getRawAxis(0));
		}
	public double axisLY() {
		return deadZone(-this.getRawAxis(1));
	}
	public double axisRX() {
		return deadZone(this.getRawAxis(4));
	}
	public double axisRY() {
		return deadZone(-this.getRawAxis(5));
	}
	public double axisLT() {
		return deadZone(this.getRawAxis(2));
	}
	public double axisRT() {
		return deadZone(this.getRawAxis(3));
	}
	public boolean dPadUp() {
	return dPad() == 0;
	}
	public boolean dPadRight() {
	return dPad() == 2;
	}
	public boolean dPadDown() {
	return dPad() == 4;
	}
	public boolean dPadLeft() {
	return dPad() == 6;
	}
	public int dPad() {
		double angle = this.getPOV();
		if(angle == -1)
			return (int)angle;
		int direction = (int)Math.floor(((angle + 22.5) % 360)/45);
		System.out.println(direction);
		return direction;
	}
	public double deadZone(double distance) {
		if(distance < .05 || distance > -.05) return 0.0;
		else return distance;
	}
	public class DPadButton extends Button{
		private Controller controller;
		private int zone;
		
		public DPadButton(Controller controller, int zone) {
			this.controller = controller;
			this.zone = zone;
		}
		public boolean get() {
			return this.controller.dPad() == zone;
		}
	}
	public class DebouncedButton extends JoystickButton{
		public double latest = Timer.getFPGATimestamp();
		
		public DebouncedButton(Joystick joy,int button) {
		super(joy, button);
		}
		public boolean debounced() {
			double now = Timer.getFPGATimestamp();
			if(this.get()) {
				if((now-latest)>.25) {
					latest = now;
					return true;
				}
			}
			return false;
		}
	}
}
