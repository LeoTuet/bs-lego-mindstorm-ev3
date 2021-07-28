package robot;

import robot.api.LightSensor;
import robot.api.TwoWheelRobot;

public class Main {

    public static void main(String[] args) {
        /*
        TwoWheelRobot wheelRobot = new TwoWheelRobot();
        wheelRobot.setSpeed(0.5);
        wheelRobot.driveDist(80);
        wheelRobot.brake();
        wheelRobot.turn('l', 90);
        wheelRobot.brake();
        wheelRobot.setSpeed(-0.5);
        wheelRobot.driveDist(40);
    */
        LightSensor lightSensor = new LightSensor();
        lightSensor.connect(3);
        lightSensor.sampleLight();

    }
}
