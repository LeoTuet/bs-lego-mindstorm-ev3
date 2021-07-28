package robot.api;

import lejos.hardware.port.Port;

public class TwoWheelRobot {

    protected double speed;
    protected EV3Brick brick;
    private Motor motA, motB;

    public TwoWheelRobot() {
        brick = new EV3Brick();
        motA = new Motor();
        motB = new Motor();
        motA.connect(brick.getPort("A"));
        motB.connect(brick.getPort("B"));
        speed = 0.5;
    }

    public void setSpeed(double sp) {
        if (sp > 3.0 || sp < -3.0) {
            System.out.println("to high!");
            speed = 1.0;
        } else {
            speed = sp;
        }
    }

    public double getSpeed() {
        return speed;
    }

    // method to drive forward
    public void driveForward() {
        motA.start(speed);
        motB.start(speed);
    }

    // method to drive backwards
    public void driveBackwards() {
        double negativeSpeed = getSpeed() < 0 ? getSpeed() : getSpeed() * -1;
        motA.start(negativeSpeed);
        motB.start(negativeSpeed);
    }

    // method to stop
    public void brake() {
        motA.stop();
        motB.stop();
    }

    // method to drive forward a specific time
    public void driveForward(double sek) {
        driveForward();
        Helper.delayProgramm(sek);
        brake();
    }

    // method to drive backwards a specific time
    public void driveBackwards(double sek) {
        driveForward();
        Helper.delayProgramm(sek);
        brake();
    }


    // method to drive a specific length
    public void driveDist(double cm) {
        boolean isNegative = String.valueOf(cm).contains("-");
        double weelRotations = Helper.getRotations(cm);
        double driveTime = weelRotations / Math.abs(speed);
        if (isNegative) {
            driveBackwards(driveTime);
        } else {
            driveForward(driveTime);
        }
    }

    // method to rotate use 'l' for left or 'r' for right and the degree as an int
    public void turn(char dir, int grad) {
        double zeit = (2 * Helper.TRACKWIDTH / Helper.DIAMETER) * (grad / 360.) * (1 / Math.abs(speed));
        if (dir == 'r') {
            motA.start(speed);
            Helper.delayProgramm(zeit);
        } else {
            motB.start(speed);
            Helper.delayProgramm(zeit);
        }
        brake();
    }


}
