package org.usfirst.frc.team2635.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class Shooter {
	CANTalon motorL, motorR;

	public Shooter(CANTalon motorL, CANTalon motorR) {
		super();
		this.motorL = motorL;
		this.motorR = motorR;
	}

	public void set(double setpoint) {
		this.motorL.set(setpoint);
		this.motorR.set(-setpoint);
	}
}
