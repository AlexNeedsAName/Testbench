package org.usfirst.frc.team3641.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot
{
	
	public void robotInit()
	{	
		Constants.runningAleksBot = SmartDashboard.getBoolean("Running Alek's Bot?", true);
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
    	Auton.run(2);

    }

    public void teleopPeriodic()
    {
        Teleop.run();
    }
    
    public void testPeriodic()
    {
    
    }
    
}
