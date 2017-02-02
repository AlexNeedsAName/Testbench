package org.usfirst.frc.team3641.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot
{
	public void robotInit()
	{	
    	Dashboard.getInstance();
    	Teleop.getInstance();
    	Sensors.getInstance();
    	Shooter.getInstance();
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
