package robot;

import robot.api.LightSensor;
import robot.api.TwoWheelRobot;
import robot.api.UltrasoundSensor;

public class AutonomousRobot extends TwoWheelRobot {
    private LightSensor lightSensor;
    private LightSensor lightSensor2;
    private UltrasoundSensor ultrasoundSensor;

    public AutonomousRobot() {
        super();
        lightSensor = new LightSensor();
        lightSensor.connect(brick.getPort("S4"));
        lightSensor2 = new LightSensor();
        lightSensor2.connect(brick.getPort("S1"));
        ultrasoundSensor = new UltrasoundSensor();
        ultrasoundSensor.connect(brick.getPort("S3"));
    }

    public void driveSafely() {
        while (!obstacleDetected()) {
            drive();
        }
        brake();
    }

    public void driveSafelyDist(byte cm) {
        for(byte i = 0; i < cm; i++){
            if(this.getLightSensor().sampleLight() <= 10){
                break;
            }
            driveDist(1);
        }
        brake();
    }

    public void driveSafely(byte sec) {
        while (!obstacleDetected()) {
            drive(sec);
        }
        brake();
    }

    public void showLightSensorData() {
        System.out.println("Lightsensor: /n" + lightSensor.sampleLight());
    }

    public void showUltraSoundSensorData() {
        System.out.println(ultrasoundSensor.sampleSonic());
    }

    private LightSensor getLightSensor() {
        return this.lightSensor;
    }

    public void clearTable() {
        while (true) {
            if (obstacleDetected()) {
                ramObstacle();
            } else {
                searchObstacle();
            }
        }
    }

    private void searchObstacle() {
        while (!obstacleDetected()){
            turn('l', 3);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ramObstacle() {
        //double tempSpeed = getSpeed();
        //setSpeed(3);
        while (obstacleDetected()){
            driveSafely();
        }
        //setSpeed(tempSpeed);
    }

    private boolean endOfTableDetected() {
        return this.lightSensor.sampleLight() < 10 || this.lightSensor2.sampleLight()<10;
    }

    private boolean obstacleDetected() {
        return ultrasoundSensor.sampleSonic()<=50;
    }
}
