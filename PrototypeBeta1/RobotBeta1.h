#ifndef _ROBOTBETA1_H
#define _ROBOTBETA1_H

// TODO put these in a separate file/place.

// There are 16 buttons on the joystick.  The numbering starts at 1, not 0.  Add one to number of buttons 

#define JOYSTICK_NUM_BUTTONS 16 + 1
#define JOYSTICK_FIRST_BUTTON 1
#define JOYSTICK_LAST_BUTTON JOYSTICK_FIRST_BUTTON + JOYSTICK_NUM_BUTTONS

extern int dbg_flag;

class RobotBeta1 : public SimpleRobot {
public:
		RobotBeta1(void);
		~RobotBeta1(void);
		void Autonomous(void);
		void OperatorControl(void);
		void UpdateDashboard(void);
		
private:
	    Jaguar *leftMotor;
	    Jaguar *rightMotor;
	    Jaguar *conveyor;
	    Jaguar *shooter;
		RobotDrive *robotDrive;
		Joystick *stickLeft;
		Joystick *stickRight;
		Joystick *stickCopilot;
		Gyro *gyro;
		Servo *pan;
		Servo *tilt;
		Encoder *encoder;
		DriverStation *driverStation;	
		
		PCVideoServer *pc;
		DashboardDataFormat *dashboard;
		
		TrackingThreshold tt1 /*PINK*/, tt2 /*GREEN*/;		// these are the 2 colors to track 		
		ParticleAnalysisReport pa1 /*PINK*/ , pa2 /*GREEN*/;	//Particle Analysis Report
		
		bool rightButtons[JOYSTICK_NUM_BUTTONS];
		bool leftButtons[JOYSTICK_NUM_BUTTONS];
		bool copilotButtons[JOYSTICK_NUM_BUTTONS];
		time_t now, lastTime;
		float tcLeft, tcRight;
		
		void moveToTrailor(double distanceToTrailor);
		void driveStrait(long maxTime);
		void turn90Right(void);
		void turn130Left(void); 
        void turnDeg(double degrees);
        void turnRad(double radians);
		void resetGyro(void);
		void initializeAlliance(void);
		void initializeColors(void);
		void initializeCamera(void);
		void initializeButtons(void);
		void recieveAndReactToCameraData(void);
		void readButtons(Joystick *stick, bool *buttons, char *side);
		void actOnButtons(void);
		void updateConveyor(void);
		void updateShooter(void);
		void updatePanTilt(void);
		double distanceToTrailor(double pxH);
		float accelmonitor(float YVal);
		
};

#endif