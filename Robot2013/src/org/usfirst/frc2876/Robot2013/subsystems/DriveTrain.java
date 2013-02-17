// Generated with RobotBuilder version 0.0.1
package org.usfirst.frc2876.Robot2013.subsystems;
import org.usfirst.frc2876.Robot2013.RobotMap;
import org.usfirst.frc2876.Robot2013.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class DriveTrain extends Subsystem {
    // The following variables are automatically assigned by
    // robotbuilder and will be updated the next time you export to
    // Java from robot builder. Do not put any code or make any change
    // in the following block or it will be lost on an update. To
    // prevent this subsystem from being automatically updated, delete
    // the following line.
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    RobotDrive robotDrive2 = RobotMap.DRIVETRAIN_ROBOT_DRIVE_2;
    Jaguar rightDriveJaguar = RobotMap.DRIVETRAIN_RIGHTDRIVE_JAGUAR;
    Jaguar leftDriveJaguar = RobotMap.DRIVETRAIN_LEFTDRIVE_JAGUAR;
    public Encoder rightEncoder = RobotMap.DRIVETRAIN_RIGHTENCODER;
    public Encoder leftEncoder = RobotMap.DRIVETRAIN_LEFTENCODER;
    Gyro gyro = RobotMap.DRIVETRAIN_GYRO;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private static final double turnKp = 0.1;
    private static final double turnKi = 0;
    private static final double turnKd = 0.30;
    private static final double turnKf = 0.001;
    PIDController turnPID;
    
    public void DriveTrain(){
           turnPID = new PIDController(turnKp, turnKi, turnKd, turnKf, gyro, new PIDOutput() {
            public void pidWrite(double output) {
//                limitleft = output;
//                limitright = -output;
                robotDrive2.tankDrive(-output, output);
                //System.out.println("output: " + output + "  -  leftjag: " + leftJaguar.get() + "  -  rightJag: " + rightJaguar.get());
            }   
        });     

        turnPID.setOutputRange(-1, 1);
  
        turnPID.setInputRange(-90, 90);

        turnPID.setPercentTolerance(2);
        LiveWindow.addActuator("DriveTrain", "turnPID", turnPID);
           
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // The following variables are automatically assigned by
        // robotbuilder and will be updated the next time you export to
        // Java from robot builder. Do not put any code or make any change
        // in the following block or it will be lost on an update. To
        // prevent this subsystem from being automatically updated, delete
        // the following line.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveIdle());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void init(){
            turnPID.reset();
        turnPID.setSetpoint(0);    
    
    }
    
        public void setTurnSetPoint(double degrees)
    {
        gyro.reset();
        turnPID.setSetpoint(degrees);
    }


    public boolean isTurnFinished() {
        System.out.println("is turn done: " + turnPID.onTarget()
                + " deg:" + RobotMap.roundtoTwo(gyro.getAngle())
                + " out:" + RobotMap.roundtoTwo(turnPID.get())
                + " err:" + RobotMap.roundtoTwo(turnPID.getError()));

        return turnPID.onTarget();
    }

    public void endTurn() {
        turnPID.disable();
    }
    
    public void drive(Joystick left,Joystick right ){
        
        robotDrive2.tankDrive(left, right);
    }
    
    public void startEncoder(Encoder encoder){
       encoder.reset();
       encoder.start();  
    }
    
        public double getLeftEncoder() {
        SmartDashboard.putNumber("left encoder: ", leftEncoder.getRaw());
        return leftEncoder.getRaw();
    }
    
    public double getRightEncoder() {
        SmartDashboard.putNumber("right encoder: ", rightEncoder.getRaw());
        return rightEncoder.getRaw();
    }
    
    public double getLeftEncoderDistance() {
        SmartDashboard.putNumber("left encoder distance: ", leftEncoder.getDistance());
        return leftEncoder.getDistance();
    }
    
    public double getRightEncoderDistance() {
        SmartDashboard.putNumber("right encoder distance: ", rightEncoder.getDistance());
        return rightEncoder.getDistance();
    }
                
    }