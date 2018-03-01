package org.usfirst.frc6442.Robot2018StartAgain;

public class RobotValues {
	
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
	
	
}
