package robot.core;

import robot.api.LightSensor;
import robot.api.TouchSensor;
import robot.api.TwoWheelRobot;
import robot.api.UltrasoundSensor;

import java.util.Random;


public class AutomDrive {

    TwoWheelRobot wheelRobot;
    LightSensor lightSensor;
    TouchSensor touchSensor;
    UltrasoundSensor ultrasoundSensor;
    Random random;

    public AutomDrive() {
        wheelRobot = new TwoWheelRobot();
        touchSensor = new TouchSensor("S1");
        ultrasoundSensor = new UltrasoundSensor("S2");
        lightSensor = new LightSensor("S3");
    }

    public void startStop() {
        autoDrive();
        touchSensor.setTouched(false);
        startAutoDrive();
    }

    public void startAutoDrive() {
        while (!touchSensor.sampleTouch()) {
        }
        autoDrive();
    }

    public void autoDrive() {
        while (!touchSensor.sampleTouch()) {
            driveSave();
            wheelRobot.driveDist(-10);
            randomTurn();
            autoDrive();
        }
    }

    public void driveSave() {
        while (lightSensor.sampleLight() >= 10) {
            wheelRobot.driveForward();
            System.out.println("test");
        }
        wheelRobot.brake();
    }

    public void randomTurn() {
        random = new Random();
        String leftOrRight = "rl";
        wheelRobot.turn(leftOrRight.charAt(random.nextInt(leftOrRight.length())), 92 + random.nextInt(180));
    }

}
