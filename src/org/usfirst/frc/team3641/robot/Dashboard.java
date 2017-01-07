package org.usfirst.frc.team3641.robot;

public class Dashboard
{
	private static Dashboard instance;
	private static UDP driverStation;

	public static Dashboard getInstance()
	{
		if(instance == null) Dashboard.getInstance();
		return instance;
	}

	private Dashboard()
	{
		driverStation = new UDP(Constants.DRIVER_IP_ADDR, Constants.DRIVER_PORT);
	}
	
	public static void log(String message)
	{
		driverStation.sendData(message);
	}
}
