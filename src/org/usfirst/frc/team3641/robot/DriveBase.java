package org.usfirst.frc.team3641.robot;
import com.ctre.CANTalon;

public class DriveBase
{
	private static DriveBase instance;
	private static CANTalon left, right;
	
	public static DriveBase getInstance()
	{
		if(instance == null) instance = new DriveBase();
		return instance;
	}
	
	private DriveBase()
	{
		left = new CANTalon(Constants.LEFT_TALON);
		right = new CANTalon(Constants.RIGHT_TALON);
	}
	
	public static void driveArcade(double power, double rotation)
	{
		double leftPower = power + rotation;
		double rightPower = power - rotation;
		
		double maxPower;
		if(leftPower > rightPower) maxPower = leftPower;
		else maxPower = rightPower;
		
		if(maxPower > 1)
		{
			leftPower/= maxPower;
			rightPower/= maxPower;
		}
		
		left.set(leftPower);
		right.set(rightPower);
	}
	public static void driveTank(double leftPower, double rightPower)
	{
		double maxPower;
		if(leftPower > rightPower) maxPower = leftPower;
		else maxPower = rightPower;
		
		if(maxPower > 1)
		{
			leftPower/= maxPower;
			rightPower/= maxPower;
		}
		
		left.set(leftPower);
		right.set(rightPower);
	}
}
