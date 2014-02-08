// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2876.FRC2876AerialAssault.subsystems;
import org.usfirst.frc2876.FRC2876AerialAssault.RobotMap;
import org.usfirst.frc2876.FRC2876AerialAssault.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveTrain extends Subsystem {
    public Encoder leftEncoder = RobotMap.driveTrainLeftEncoder;
    public Encoder rightEncoder = RobotMap.driveTrainRightEncoder;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Gyro gyro = RobotMap.driveTrainGyro;
    SpeedController leftSpeedController = RobotMap.driveTrainLeftSpeedController;
    SpeedController rightSpeedController = RobotMap.driveTrainRightSpeedController;
    RobotDrive robotDrive21 = RobotMap.driveTrainRobotDrive21;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new Drive());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void tankDrive(double left, double right) {
        robotDrive21.tankDrive(left, right);
               
    }
    public void resetEncoders(){
        
        leftEncoder.reset();
        rightEncoder.reset();
    }
    public void startEncoders(){
        leftEncoder.start();
        rightEncoder.start();
    }
    
    public void stopEncoders(){
        leftEncoder.stop();
        rightEncoder.stop();
    }
}