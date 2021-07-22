package robot;

import robot.api.TwoWheelRobot;

public class Main {

    public static void main(String[] args) {
        reverseParking();
    }

    private static void reverseParking() {
        TwoWheelRobot wheelRobot = new TwoWheelRobot();
        wheelRobot.setSpeed(1);
        wheelRobot.driveDist(80);
        wheelRobot.turn('l', 90);
        wheelRobot.setSpeed(-1);
        wheelRobot.driveDist(40);
    }
}
