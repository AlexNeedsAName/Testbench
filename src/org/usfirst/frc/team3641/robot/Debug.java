package org.usfirst.frc.team3641.robot;

public class Debug
{
	private static Debug instance;
	
	public static Debug getInstance()
	{
		if(instance == null) instance = new Debug();
		return instance;
	}
	
	private Debug()
	{
		
	}
	
	public static void logBatteryVoltage()
	{
		Dashboard.log("Debug: Battery Voltage: " + PDP.getVoltage());
	}

}
