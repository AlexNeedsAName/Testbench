package org.usfirst.frc.team3641.robot;

public class Auton
{
	private static Auton instance;
	private static int autonState;
	
	private static boolean alreadyDriving = false;
	private static double initalEncoder;
	private static double finalEncoder;
	
	private static boolean turn = false;
	
	public static Auton getInstance()
	{
		if(instance == null) instance = new Auton();
		return instance;
	}
	
	private Auton()
	{
		autonState = Constants.START;
	}
	
	public static void run(int autonMode)
	{
		switch(autonMode)
		{
			case Constants.DO_NOTHING:
				break;
			case Constants.CROSS_BASELINE:
				crossBaseline();
				break;
			case Constants.LINE_ALIGN:
				if (turn == false) {
		    		DriveBase.turnDegrees(4, 2);
		    		turn = true;
		    	}
				break;

		}
	}
	
	private static void crossBaseline()
	{
		if(autonState == Constants.START)
		{
			autonState = Constants.DRIVE_FORWARDS;
			alreadyDriving = false;
		}
		
		if(autonState == Constants.DRIVE_FORWARDS)
		{
			if(driveForwards(284, .5))
			{
				autonState = Constants.DONE;
				alreadyDriving = false;
			}
		}
		
	}
	
	private static boolean driveForwards(double distance, double speed)
	{
		if(!alreadyDriving)
		{
			initalEncoder = DriveBase.readEncoder();
			finalEncoder = initalEncoder + distance * Constants.ENCODER_TO_CM;
			alreadyDriving = true;
		}
		
		if(DriveBase.readEncoder() <= finalEncoder)
		{
			DriveBase.driveArcade(speed, 0);
			return false;
		}
		else return true;
		
		
	}

}
