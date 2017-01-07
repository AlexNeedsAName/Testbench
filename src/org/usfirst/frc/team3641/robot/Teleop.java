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
		dualshock = new PS4(1);
	}
	
	public static void run()
	{
		dualshock.readValues();
	}
	
}
