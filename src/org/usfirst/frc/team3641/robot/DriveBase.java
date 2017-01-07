package org.usfirst.frc.team3641.robot;

public class DriveBase
{
	private static DriveBase instance;
	
	public static DriveBase getInstance()
	{
		if(instance == null) instance = new DriveBase();
		return instance;
	}
	
	private DriveBase()
	{
		
	}
}
