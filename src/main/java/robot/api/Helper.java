package robot.api;

import lejos.utility.Delay;


public class Helper {
	public static final double DIAMETER = 5.6;
	public static final double TRACKWIDTH = 11.7;
	private Helper(){}
	public static void delayProgramm(double sek) {
		Delay.msDelay((int)(sek*1000));
	}
	public static double getRotations(double cm) {
		return cm/(DIAMETER *Math.PI);
	}
}
