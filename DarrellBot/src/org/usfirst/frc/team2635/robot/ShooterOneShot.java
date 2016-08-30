package org.usfirst.frc.team2635.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class ShooterOneShot extends Shooter {
boolean shootIt;
OneShot<Boolean> myOneShot;

public ShooterOneShot(CANTalon motorL, CANTalon motorR) {
	super(motorL, motorR);
	myOneShot = new OneShot<>(false);
	// TODO Auto-generated constructor stub
}
public void shootTheThing(boolean shoot){
	if (myOneShot.oneShot(shoot)){
		this.set(0.5);
	} else {
		set(0.0);
	}
}

}
