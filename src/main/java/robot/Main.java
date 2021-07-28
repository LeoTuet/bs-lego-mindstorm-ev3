package robot;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
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
        TwoWheelRobot wheelRobot = new TwoWheelRobot();
        while (true){
            if (wheelRobot.lightSensor.sampleLight() > 40){
                wheelRobot.setSpeed(0.5);
                wheelRobot.driveDist(1);
                wheelRobot.brake();
            } else {
                wheelRobot.setSpeed(-0.5);
                wheelRobot.driveDist(10);
                wheelRobot.turn('r', 45);
            }

        }
    }
}
