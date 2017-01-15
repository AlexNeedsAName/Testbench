package org.usfirst.frc.team3641.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot
{
	
	public void robotInit()
	{	
		Constants.usingPMW = SmartDashboard.getBoolean("Using PWM?", false);
    	Teleop.getInstance();
    	DriveBase.getInstance();
    	Tracking.getInstance();
    	PDP.getInstance();
	}
    
    public void autonomousInit()
    {

    }

    public void autonomousPeriodic()
    {

    }

    public void teleopPeriodic()
    {
        Teleop.run();
    }
    
    public void testPeriodic()
    {
    
    }
    
}
