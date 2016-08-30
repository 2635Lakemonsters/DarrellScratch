
package org.usfirst.frc.team2635.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
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
    private static final int SHOOT_BUTTON = 5;
	private static final int JOYSTICKCHANNEL = 0;
	private static final int AXISY_L = 1;
	private static final int AXISY_R = 5;
	private static final int MOTOR_R = 1;
	private static final int MOTOR_L = 7;
	final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    CANTalon motorR, motorL;
    Joystick myjoystick;
    RobotDrive robotDriveTank;
    //Shooter myShooter;
    ShooterOneShot myShooterOneShot;
    
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        motorR = new CANTalon(MOTOR_R);
        motorL = new CANTalon(MOTOR_L);
        myjoystick = new Joystick(JOYSTICKCHANNEL);
        //robotDriveTank = new RobotDrive(motorL, motorR);
        //myShooter = new Shooter(motorL,motorR);
        myShooterOneShot = new ShooterOneShot(motorL,motorR);
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
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    private double modifyBeforeDrive(double invalue){
    	return invalue / 1.0;
    }
    
    public void teleopPeriodic() {
        //motor1.set(modifyBeforeDrive(myjoystick.getRawAxis(AXISY_L)));
        //motor2.set(modifyBeforeDrive(myjoystick.getRawAxis(AXISY_R)));
    	double tankL = myjoystick.getRawAxis(AXISY_L);
    	double tankR = myjoystick.getRawAxis(AXISY_R);
        //robotDriveTank.tankDrive(tankL, tankR);
        //myShooter.set(tankL);
        boolean shootIt = myjoystick.getRawButton(SHOOT_BUTTON);
        myShooterOneShot.shootTheThing(shootIt);
        
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
