package org.usfirst.frc6442.Robot2018StartAgain;

import edu.wpi.first.wpilibj.Preferences;

public class RobotValues {
	public Preferences prefs = Preferences.getInstance();
	
	public boolean skipCAN = true;
	
	// PDW IO Position Assignment
	public int leftDrivePWM = 1;
	public int rightDrivePWM = 0;
	public int feederPWM = 3;
	public int launcherPWM = 4;
	public int grabberRightPWM = 7;
	public int grabberLeftPWM = 8;
	
	// CAN Module ID Assignment
	public int pdpId = 0;
	public int pcmId = 0;
	
	// PCM Channels
	public int solenoidForward = 0;
	public int solenoidReverse = 1;
	
	// PWM Invert
	public boolean leftDriveInvert    = false;
	public boolean rightDriveInvert   = true;

	public boolean feederInvert       = false;
	public boolean launcherInvert     = false;

	public boolean grabberRightInvert = false;
	public boolean grabberLeftInvert  = false;
	
	// Launching
	public double highSpeed = 0.5;
	public double lowSpeed = 0.2;
	public double highSpin = 1;
	public double lowSpin = 0.3;
	public double highFeed = 0.5;
	public double lowFeed = 0.2;
	public double highFeedTime = 1;
	public double lowFeedTime = 2;

	public double gyroTurnErrorMargin = 3;
	
	// Securing
	public int leftGrabModulo = 2;
	public int rightGrabModulo = 2;
	public int leftGrabOn = 0;
	public int rightGrabOn = 1;
	public double grabSpeed = 0.2;
	
	
	public void update() {
		// BEGIN autogenerated with values-boilerplate.js
		skipCAN = getBoolean("skipCAN", true);
		leftDrivePWM = getInt("leftDrivePWM", 1);
		rightDrivePWM = getInt("rightDrivePWM", 0);
		feederPWM = getInt("feederPWM", 3);
		launcherPWM = getInt("launcherPWM", 4);
		grabberRightPWM = getInt("grabberRightPWM", 7);
		grabberLeftPWM = getInt("grabberLeftPWM", 8);
		pdpId = getInt("pdpId", 0);
		pcmId = getInt("pcmId", 0);
		solenoidForward = getInt("solenoidForward", 0);
		solenoidReverse = getInt("solenoidReverse", 1);
		leftDriveInvert = getBoolean("leftDriveInvert", false);
		rightDriveInvert = getBoolean("rightDriveInvert", true);
		feederInvert = getBoolean("feederInvert", false);
		launcherInvert = getBoolean("launcherInvert", false);
		grabberRightInvert = getBoolean("grabberRightInvert", false);
		grabberLeftInvert = getBoolean("grabberLeftInvert", false);
		highSpeed = getDouble("highSpeed", 0.5);
		lowSpeed = getDouble("lowSpeed", 0.2);
		highSpin = getDouble("highSpin", 1);
		lowSpin = getDouble("lowSpin", 0.3);
		highFeed = getDouble("highFeed", 0.5);
		lowFeed = getDouble("lowFeed", 0.2);
		highFeedTime = getDouble("highFeedTime", 1);
		lowFeedTime = getDouble("lowFeedTime", 2);
		gyroTurnErrorMargin = getDouble("gyroTurnErrorMargin", 3);
		leftGrabModulo = getInt("leftGrabModulo", 2);
		rightGrabModulo = getInt("rightGrabModulo", 2);
		leftGrabOn = getInt("leftGrabOn", 0);
		rightGrabOn = getInt("rightGrabOn", 1);
		grabSpeed = getDouble("grabSpeed", 0.2);
		// END autogenerated with values-boilerplate.js
	}
	
	public double get(String key) {
		return prefs.getDouble(key, 0);
	}
	
	public double getDouble(String key, double defaultValue) {
		if (!prefs.containsKey(key)) {
			prefs.putDouble(key, defaultValue);
			return defaultValue;
		}
		return prefs.getDouble(key, defaultValue);
	}
	
	public int getInt(String key, int defaultValue) {
		if (!prefs.containsKey(key)) {
			prefs.putInt(key, defaultValue);
			return defaultValue;
		}
		return prefs.getInt(key, defaultValue);
	}
	
	public boolean getBoolean(String key, boolean defaultValue) {
		if (!prefs.containsKey(key)) {
			prefs.putBoolean(key, defaultValue);
			return defaultValue;
		}
		return prefs.getBoolean(key, defaultValue);
	}
}
