package robot.core;

import robot.api.LightSensor;
import robot.api.TouchSensor;
import robot.api.TwoWheelRobot;
import robot.api.UltrasoundSensor;

import java.util.Random;


public class AutomDrive {

    TwoWheelRobot wheelRobot;
    LightSensor lightSensorRight, lightSensorLeft;
    BetterTouchSensor touchSensor;
    UltrasoundSensor ultrasoundSensor;
    Random random;

    public AutomDrive() {
        wheelRobot = new TwoWheelRobot();
        touchSensor = new BetterTouchSensor("S4");
        ultrasoundSensor = new UltrasoundSensor("S2");
        lightSensorRight = new LightSensor("S3");
        lightSensorLeft = new LightSensor("S1");
    }

    public void startStop() {
        autoDrive();
    }

    public void startAutoDrive() {
        while (!touchSensor.wasReTouched()) {

        }
        System.out.println("exited waiting for start");
        autoDrive();
    }

    public void autoDrive() {
        while (!touchSensor.wasReTouched()) {
            findCube();
            driveSave();
            autoDrive();
        }
        System.out.println("exited movement");
        startAutoDrive();
    }

    public void driveSave() {
        while (lightSensorRight.sampleLight() >= 10 && lightSensorLeft.sampleLight() >= 10) {
            wheelRobot.driveForward();
        }
        wheelRobot.brake();
        wheelRobot.driveBackwards(2);
    }

    public void randomTurn() {
        random = new Random();
        String leftOrRight = "rl";
        wheelRobot.turn(leftOrRight.charAt(random.nextInt(leftOrRight.length())), 92 + random.nextInt(180));
    }

    public boolean detectCube() {
        return ultrasoundSensor.sampleSonic() <= 50;
    }

    public void findCube() {
        while (!detectCube()) {
            wheelRobot.turn('r', 5);
        }
    }

}
