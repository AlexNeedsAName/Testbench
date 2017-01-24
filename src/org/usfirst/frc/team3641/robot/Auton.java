package org.usfirst.frc.team3641.robot;

public class Auton
{
	private static Auton instance;
	private static int autonState;
	
	private static boolean alreadyDriving = false;
	private static double initalEncoder;
	private static double finalEncoder;
	private static boolean runOnce;
	
	public static UDP udp;
	
	public static Auton getInstance()
	{
		runOnce = false;
		if(instance == null) instance = new Auton();
		return instance;
	}
	
	private Auton()
	{
		autonState = Constants.START;
	}
	
	public static void run(int autonMode)
	{
		String receivedData;
		Boolean continueMouseControl = true;
		switch(autonMode)
		{
			case Constants.DO_NOTHING:
				break;
			case Constants.CROSS_BASELINE:
				crossBaseline();
				break;
			case Constants.LINE_ALIGN:
					if(udp == null) udp = new UDP("beaglebone.local", 3641);
					
					//Request info about line position
					if (runOnce == false) 
					{
						udp.sendData("1");
						runOnce = true;
					}
					
					receivedData = udp.getData();
					
			        if (receivedData != null) 
			        {
						//This code allows for the incoming data to split up into parts by spaces
				        String[] parts = receivedData.split(" ");
				        String part1 = parts[0];
				        double part1_double = Double.parseDouble(part1);
				        System.out.println("RECEIVED: " + part1);
						
				        DriveBase.turnDegrees(part1_double, 2);
					}
				break;
			case Constants.MOUSE_CONTROL:
				if(udp == null) udp = new UDP("beaglebone.local", 3641);
				
				//Request info about line position
				if (runOnce == false) 
				{
					udp.sendData("1");
					runOnce = true;
				}
				
				while (continueMouseControl == true) 
				{
					receivedData = udp.getData();
					
					if (receivedData != null) 
			        {
						//This code allows for the incoming data to split up into parts by spaces
				        String[] parts = receivedData.split(" ");
				        String xQue = parts[0];
				        double xQue_double = Double.parseDouble(xQue);
				        System.out.println("RECEIVED: " + xQue);
						
				        if (xQue_double < 0) 
				        {
				        	DriveBase.setMotors(-0.7, -0.8);
				        }
				        if (xQue_double > 0) 
				        {
				        	DriveBase.setMotors(0.7, 0.8);
				        }
				        if (xQue_double == 0) {
				        	DriveBase.setMotors(0, 0);
				        }
				        //xQue_double = xQue_double*0.25;
				        //DriveBase.turnDegrees(xQue_double, 2);
					}
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
