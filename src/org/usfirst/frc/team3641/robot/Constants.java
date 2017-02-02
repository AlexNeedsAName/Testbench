package org.usfirst.frc.team3641.robot;

public class Constants
{
	public static final int PS4_PORT = 0;
	
	public static final double SHOOTER_KP = 0.00003;
	public static final double SHOOTER_KI = 0;//0.0000025;
	public static final double SHOOTER_KD = 0;//0.00000025;
	public static final double SHOOTER_FF = 5500;
	
	
	public static final double ENCODER_RATE_MULTIPLIER = -7.5; // ticks/s * 60s/min * 1rev/8ticks = 7.5 RPM 
	//55430 = 730
	//Talons
	public static final int LEFT_TALON = 1;
	public static final int LEFT_SLAVE_TALON = 2;
	public static final int RIGHT_TALON = 3;
	public static final int RIGHT_SLAVE_TALON = 4;
	
	//Victors (for Alek)
	public static final int LEFT_VICTOR = 1;
	public static final int LEFT_SLAVE_VICTOR = 2;
	public static final int RIGHT_VICTOR = 3;
	public static final int RIGHT_SLAVE_VICTOR = 4;
	
	//UDP Constants
	public static final int PI_PORT = 5800; //Only ports 5800-5810 are open this year :(
	public static final String PI_IP_ADDR = "10.36.41.x"; //TODO: Get Real Address
	
	public static final int DRIVER_PORT = 5801;
	public static final String DRIVER_IP_ADDR = "10.36.42.81";

	//Vision Constants
	public static final double GEAR_TRACKING_KP = 0.0; //TODO: Build robot, then tune this value
	public static final double GEAR_TRACKING_KI = 0.0; //TODO: Build robot, then tune this value
	public static final double FUEL_TRACKING_KP = 0.0; //TODO: Build robot, then tune this value
	public static final double FUEL_TRACKING_KI = 0.0; //TODO: Build robot, then tune this value
	
	public static final int FUEL_MODE = 1;
	public static final int GEAR_MODE = 2;
	
	public static final int SEND_REQUEST = 1;
	public static final int GET_RESPONSE = 2;
	public static final int TURN_TO_TARGET = 3;
	public static final int SLIDE_GEAR_MECHANISM = 4;	
	public static final int TRACKED_GEAR = 5;
	public static final int TRACKED_FUEL = 6;
	
	public static final double ACCEPTABLE_FUEL_ERROR = 2; //Degrees
	public static final double ACCEPTABLE_GEAR_ERROR = 5; //Pixels
	
	public static final int CAMERA_CENTER = 160;
	public static final double DEGREES_PER_PIXEL = 0.2140625;
	
	public static final double RADIUS_TO_CM = 0; //TODO: Find this Value

	public static final double ENCODER_TO_CM = 0; //TODO: Build Robot and find Value
	
	//Auton Modes
	public static final int START = 0;
	public static final int DRIVE_FORWARDS = 1;
	public static final int DONE = 2;
	
	public static final int DO_NOTHING = 0;
	public static final int CROSS_BASELINE = 1;
	public static final int LINE_ALIGN = 2;
	public static final int MOUSE_CONTROL = 3;
	public static final int DEFAULT_AUTO = 4;

	
	
}
