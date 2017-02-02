package org.usfirst.frc.team3641.robot;

public class Sensors
{
	private static double shooterEncoderSpeed;
	private static double shooterEncoderCount;
	
	private static Sensors instance;
	
	public static Sensors getInstance()
	{
		if(instance == null) instance = new Sensors();
		return instance;
	}
	
	private Sensors()
	{
		
	}
	
	public static void poll()
	{
		shooterEncoderSpeed = Shooter.getEncoderRate();
	}
	
	public static double getShooterRPM()
	{
		return shooterEncoderSpeed;///1200;
	}
		
}
