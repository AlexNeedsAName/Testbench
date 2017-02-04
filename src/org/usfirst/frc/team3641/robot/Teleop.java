package org.usfirst.frc.team3641.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;

public class Teleop
{
	private static Teleop instance;
	private static PS4 dualshock;
	private static Extreme3DPro operator; 
	private static boolean circlePressedLastLoop = false;
	private static double dashboardPower = 0;
	//private static SerialPort serial;
	
	public static Teleop getInstance()
	{
		if(instance == null) instance = new Teleop();
		return instance;
	}
	
	private Teleop()
	{
		dualshock = new PS4(Constants.PS4_PORT);
		operator = new Extreme3DPro(Constants.E3D_PORT);
		dashboardPower = Preferences.getInstance().getDouble("Power", 0);
	}
	
	public static void run()
	{
		dualshock.readValues();
		Sensors.poll();
		
		double throttle = operator.getThrottle();
		SmartDashboard.putNumber("Throttle", (int) (throttle * Constants.SHOOTER_MAX_RPM));
		
		if(dualshock.getTriangleButton()) Shooter.set(dashboardPower);
		else if(operator.getButton(12)) Shooter.setRPM((int) (throttle * Constants.SHOOTER_MAX_RPM));
		else if(operator.getButton(11)) Shooter.set(throttle);
		else Shooter.reset();
		
	}
	
}
