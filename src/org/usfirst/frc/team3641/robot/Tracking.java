package org.usfirst.frc.team3641.robot;

public class Tracking
{
	private static Tracking instance;
	private static UDP pi;
	
	public static Tracking getInstance()
	{
		if(instance == null) instance = new Tracking();
		return instance;
	}
	
	private Tracking()
	{
    	pi = new UDP(Constants.PI_IP_ADDR, Constants.PI_PORT);
	}

}
