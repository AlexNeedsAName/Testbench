package org.usfirst.frc.team3641.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter
{
	private static Shooter instance;
	private static CANTalon left, right;
	private static PID pid;
	
	public static Shooter getInstance()
	{
		if(instance == null) instance = new Shooter();
		return instance;
	}
	
	public Shooter()
	{
		left = new CANTalon(1);
		right = new CANTalon(2);
		right.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		right.configEncoderCodesPerRev(20);
		pid = new PID(Constants.SHOOTER_KP, Constants.SHOOTER_KI, Constants.SHOOTER_KD, Constants.SHOOTER_FF, "Shooter");
	}
	
	public static double getEncoderRate()
	{
		return right.getEncVelocity() * Constants.ENCODER_RATE_MULTIPLIER;
	}
	
	public static void setRPM(double target)
	{
		SmartDashboard.putNumber("Target RPM", target);
		double current = Shooter.getEncoderRate();
		double error = target - current;
		double output = pid.pid(error, target);
		set(output);
	}
	
	public static void set(double power)
	{
		if(power > 1) power = 1;
		SmartDashboard.putNumber("Power Out", power);
		SmartDashboard.putNumber("RPM", Sensors.getShooterRPM());
		SmartDashboard.putNumber("RPM over Time", Sensors.getShooterRPM());
		right.set(power);
		left.set(-power);
	}
	
	public static void reset()
	{
		SmartDashboard.putNumber("Target RPM", 0);
		set(0);
		pid.reset();
	}
}
