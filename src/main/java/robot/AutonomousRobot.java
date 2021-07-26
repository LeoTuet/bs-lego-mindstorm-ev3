package robot;

import robot.api.LightSensor;
import robot.api.TwoWheelRobot;
import robot.api.UltrasoundSensor;

public class AutonomousRobot extends TwoWheelRobot {
    private LightSensor lightSensor;
    private UltrasoundSensor ultrasoundSensor;

    public AutonomousRobot() {
        super();
        lightSensor = new LightSensor();
        lightSensor.connect(brick.getPort("S4"));
        ultrasoundSensor = new UltrasoundSensor();
        ultrasoundSensor.connect(brick.getPort("S3"));
    }

    public void driveSafely() {
        while (this.getLightSensor().sampleLight() > 10) {
            drive();
        }
        brake();
    }

    public void driveSafelyDist(double cm) {
        for(int i = 0; i < cm; i++){
            if(this.getLightSensor().sampleLight() <= 10){
                break;
            }
            driveDist(1);
        }
        brake();
    }

    public void driveSafely(double sec) {
        while (this.getLightSensor().sampleLight() > 10) {
            drive(sec);
        }
        brake();
    }

    public void showLightSensorData() {
        System.out.println("Lightsensor: /n" + lightSensor.sampleLight());
    }

    public void showUltraSoundSensorData() {
        System.out.println("Ultrasoundsensor: /n" + ultrasoundSensor.sampleSonic());
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
            turn('r', 3);
        }
        //adds personality
        try {
            Thread.sleep(1000 + (int)(Math.random() * 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void ramObstacle() {
        double tempSpeed = getSpeed();
        setSpeed(3);
        driveSafelyDist(ultrasoundSensor.sampleSonic());
        setSpeed(tempSpeed);
    }

    private boolean endOfTableDetected() {
        return this.getLightSensor().sampleLight() < 10;
    }

    private boolean obstacleDetected() {
        // TODO: 26.07.21 use ultrasound to detect if obstacle in front
        return false;
    }
}
