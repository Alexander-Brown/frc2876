// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1234.MecanumRb.subsystems;

import org.usfirst.frc1234.MecanumRb.RobotMap;
import org.usfirst.frc1234.MecanumRb.commands.Drive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Gyro driveGyro = RobotMap.driveTrainDriveGyro;
    SpeedController frontLeft = RobotMap.driveTrainFrontLeft;
    SpeedController rearLeft = RobotMap.driveTrainRearLeft;
    SpeedController frontRight = RobotMap.driveTrainFrontRight;
    SpeedController rearRight = RobotMap.driveTrainRearRight;
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    boolean isFovEnabled = false;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new Drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void toggleFov() {
    	isFovEnabled = !isFovEnabled;
    }
    
    public void drive(double x, double y, double rotation) {
    	if (isFovEnabled) {
    		double angle = driveGyro.getAngle();
        	robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
    	} else {
    		robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
    	}
    }
}

