package robot.scripts;

import lejos.hardware.port.Port;
import robot.api.EV3Brick;
import robot.api.LightSensor;
import robot.api.TwoWheelRobot;

import java.util.Random;


public class AutomDrive {

    TwoWheelRobot wheelRobot;
    LightSensor lightSensor;
    EV3Brick brick;
    Port port;
    Random rand;
    String leftOrRight;

    public AutomDrive() {
        wheelRobot = new TwoWheelRobot();
        lightSensor = new LightSensor();
        brick = new EV3Brick();
        port = brick.getPort("S3");
        rand = new Random();
        lightSensor.connect(port);
        wheelRobot.setSpeed(0.5);
    }

    public void drive() {
        while (lightSensor.sampleLight() >= 10) {
            wheelRobot.drive();
        }
        System.out.println("test");
        wheelRobot.brake();
        wheelRobot.setSpeed(-0.5);
        wheelRobot.driveDist(10);
        wheelRobot.setSpeed(0.5);
        leftOrRight = "rl";
        wheelRobot.turn(leftOrRight.charAt(rand.nextInt(leftOrRight.length())), 92 + rand.nextInt(180));
        wheelRobot.driveDist(5);
        // drive();
    }

}
