// Generated with RobotBuilder version 0.0.1
package org.usfirst.frc2876.Robot2013.subsystems;

import org.usfirst.frc2876.Robot2013.RobotMap;
import org.usfirst.frc2876.Robot2013.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Shooter extends Subsystem {
    // The following variables are automatically assigned by
    // robotbuilder and will be updated the next time you export to
    // Java from robot builder. Do not put any code or make any change
    // in the following block or it will be lost on an update. To
    // prevent this subsystem from being automatically updated, delete
    // the following line.
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    Jaguar shootingAngleJaguar = RobotMap.SHOOTER_SHOOTINGANGLE_JAGUAR;
    Jaguar shootingJaguar = RobotMap.SHOOTER_SHOOTINGJAGUAR;
    AnalogChannel ac = RobotMap.SHOOTER_POT;
    PIDController sc;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //
    // TODO move the shooter to the lowest and highest points it can
    // physically be at and record the pot readings in these constants
    final double HIGH_LIMIT = RobotMap.MAXVOLT;
    final double LOW_LIMIT = 0;

    public Shooter() {
        potInit();
    }
    
    private void potInit() {
        sc = new PIDController(.25, 0.001, 0, ac, shootingAngleJaguar);
        sc.setPercentTolerance(2.0);
        sc.setOutputRange(-.2, .2);
        sc.setInputRange(LOW_LIMIT, HIGH_LIMIT);
        sc.enable();
        LiveWindow.addActuator("Shooter", "angle PID", sc);

    }

    public void setPotSetpoint(double v) {
        sc.setSetpoint(v);
    }

    public boolean isFinishedAdjustingShooter() {
        return sc.onTarget();
    }

    public void endShooterPID() {
        // sc.disable();
        // shootingAngleJaguar.set(0);
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
        setDefaultCommand(new ShootIdle());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }

    public void startShooter() {
        shootingJaguar.set(1);
    }

//    public void jaguarAngle(double speed) {
//        shootingAngleJaguar.set(speed);
//    }
//
//    public void endjaguarAngle() {
//        shootingAngleJaguar.set(0);
//    }

    public void endShooter() {
        shootingJaguar.set(0);
    }
}
