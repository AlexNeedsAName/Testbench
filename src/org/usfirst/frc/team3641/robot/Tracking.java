package org.usfirst.frc.team3641.robot;

public class Tracking
{
	private static Tracking instance;
	private static UDP pi;
	private static PID TrackingPID;
	
	private static int center;
	private static double angleOff, targetAngle, distance;
	
	private static int visionState;
	
	public static Tracking getInstance()
	{
		if(instance == null) instance = new Tracking();
		return instance;
	}
	
	private Tracking()
	{
    	pi = new UDP(Constants.PI_IP_ADDR, Constants.PI_PORT);
    	TrackingPID = new PID(Constants.TRACKING_KP, Constants.TRACKING_KI);
	}
	
	public static void target()
	{
		switch(visionState)
		{
			case Constants.SEND_REQUEST:
				pi.sendData("Request");
				visionState = Constants.GET_RESPONSE;
				break;
				
			case Constants.GET_RESPONSE:
				String response = pi.flush(null);
				if(response != null && response.contains(";"))
				{
					String data[] = response.split(";");
					center = Integer.parseInt(data[0]);
					distance = Integer.parseInt(data[1]) * Constants.RADIUS_TO_CM;
					visionState = Constants.TURN_TO_TARGET;
				}
				break;
				
			case Constants.TURN_TO_TARGET:
				angleOff = (center - Constants.CAMERA_CENTER) * Constants.DEGREES_PER_PIXEL;
				targetAngle = DriveBase.getAngle() + angleOff;
				double error = calcError(targetAngle, DriveBase.getAngle());
				if(Math.abs(error) < Constants.ACCEPTABLE_ERROR) visionState = Constants.TRACKED;
				else DriveBase.driveArcade(0, TrackingPID.pid(error));
				//Shooter.Prep(distance);
				break;
			case Constants.TRACKED:
				//Shooter.Fire(distance);
				break;
		}
		
	}
		
	public static void resetState()
	{
		visionState = Constants.SEND_REQUEST;
	}
	
	private static double calcError(double target, double current)
	{
		double counterClockwiseDistance, clockwiseDistance;
		
		if(target == current) return 0;
		else
		{
			counterClockwiseDistance = fixDegrees(target - current);
			clockwiseDistance = fixDegrees(360 - (target - current));
			
			if(counterClockwiseDistance > clockwiseDistance) return counterClockwiseDistance;
			else return -clockwiseDistance;
		}
		
	}
	
	private static double fixDegrees(double degrees)
	{
		while(degrees >= 360) degrees -= 360;
		while(degrees < 0) degrees += 360;
		return degrees;
	}

}
