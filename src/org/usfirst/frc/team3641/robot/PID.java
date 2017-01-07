package org.usfirst.frc.team3641.robot;

public class PID
{
	private double errorRefresh;
	private double KP, KI;

	public PID(double kp, double ki)
	{
		errorRefresh = 0;
		KP = kp;
		KI = ki;
	}
	public double pid(double error)
	{
		errorRefresh += error;
		double output = (error * KP) + (errorRefresh * KI);
		return output;
	}
}
