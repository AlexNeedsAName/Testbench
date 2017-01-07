package org.usfirst.frc.team3641.robot;

public class Constants
{
	public static final int PS4_PORT = 1;
	
	//Talons
	public static final int LEFT_TALON = 1;
	public static final int RIGHT_TALON = 2;
	
	//UDP Constants
	public static final int PI_PORT = 5800; //Only ports 5800-5810 are open this year :(
	public static final String PI_IP_ADDR = "10.36.41.x"; //TODO: Get Real Address
	
	public static final int DRIVER_PORT = 5801;
	public static final String DRIVER_IP_ADDR = "10.36.41.x"; //TODO: Get Real Address (I think it's 9, but I need to check)

	//Vision Constants
	public static final double TRACKING_KP = 0.0; //TODO: Build robot, then tune this value
	public static final double TRACKING_KI = 0.0; //TODO: Build robot, then tune this value
	
	public static final int SEND_REQUEST = 1;
	public static final int GET_RESPONSE = 2;
	public static final int TURN_TO_TARGET = 3;
	public static final int TRACKED = 4;
	
	public static final double ACCEPTABLE_ERROR = 2;
	
	public static final int CAMERA_CENTER = 160;
	public static final double DEGREES_PER_PIXEL = 0.2140625;
	
	public static final double RADIUS_TO_CM = 0; //TODO: Find this Value
	
	
}
