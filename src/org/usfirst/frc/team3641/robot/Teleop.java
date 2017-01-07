package org.usfirst.frc.team3641.robot;

public class Teleop
{
	private static Teleop instance;
	private static PS4 dualshock;
	
	public static Teleop getInstance()
	{
		if(instance == null) instance = new Teleop();
		return instance;
	}
	
	private Teleop()
	{
		dualshock = new PS4(Constants.PS4_PORT);
	}
	
	public static void run()
	{
		dualshock.readValues();
		
		//Put any functions that should block normal drive base input here:
		if(dualshock.getCircleButton()) Tracking.target();
		else
		{
			Tracking.resetState();
			DriveBase.driveArcade(dualshock.getLeftY(), dualshock.getRightX());
		}
		
		//Put any functions that should not interfere with the drive base here:
		Debug.logBatteryVoltage();
	}
	
}
