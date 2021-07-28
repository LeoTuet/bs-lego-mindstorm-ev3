package robot.core;

import robot.api.TwoWheelRobot;


// For The Parkour where you have to drive 80cm then turn left and drive 40cm backwards
public class DriveParkour {

    TwoWheelRobot wheelRobot = new TwoWheelRobot();

    public void drive() {
        wheelRobot.setSpeed(1);
        wheelRobot.driveDist(80);
        wheelRobot.brake();
        wheelRobot.turn('l', 90);
        wheelRobot.brake();
        wheelRobot.setSpeed(-1);
        wheelRobot.driveDist(40);
    }

}
