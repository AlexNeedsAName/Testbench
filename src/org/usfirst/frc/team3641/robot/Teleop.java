package org.usfirst.frc.team3641.robot;

import edu.wpi.first.wpilibj.SerialPort;

public class Teleop
{
	private static Teleop instance;
	private static PS4 dualshock;
	//private static SerialPort serial;
	
	public static Teleop getInstance()
	{
		if(instance == null) instance = new Teleop();
		return instance;
	}
	
	private Teleop()
	{
		dualshock = new PS4(Constants.PS4_PORT);
		//serial = new SerialPort(115200, SerialPort.Port.kOnboard);
	}
	
	public static void run()
	{
		dualshock.readValues();
		
		Sensors.poll();
		if(dualshock.getCircleButton())	Shooter.set(.875);
		else Shooter.reset();
	}
	
}
