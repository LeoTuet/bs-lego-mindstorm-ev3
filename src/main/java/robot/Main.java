package robot;

import lejos.hardware.port.Port;
import robot.api.EV3Brick;
import robot.api.LightSensor;
import robot.api.TwoWheelRobot;

public class Main {

    public static void main(String[] args) {
        TwoWheelRobot wheelRobot = new TwoWheelRobot();
        LightSensor lightSensor = new LightSensor();
        EV3Brick brick = new EV3Brick();
        Port port3 = brick.getPort("S3");
        lightSensor.connect(port3);
        wheelRobot.setSpeed(1);
    }
}
