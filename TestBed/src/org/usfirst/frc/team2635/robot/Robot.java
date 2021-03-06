
package org.usfirst.frc.team2635.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
  
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	CANTalon motorA;
	CANTalon motorB;
	final int channelA = 1;
	final int channelB = 2;
	
	Joystick joystick;
    public void robotInit() 
    {
        motorA = new CANTalon(channelA);
        motorB = new CANTalon(channelB);
        joystick = new Joystick(1);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */



    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
    	double stickA = joystick.getRawAxis(0);
    	double stickB = joystick.getRawAxis(4);
    	
    	motorA.set(stickA);
    	motorB.set(stickB);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
