package robot.api;
import lejos.hardware.port.Port;
public class TwoWheelRobot {
	protected double speed;
	protected EV3Brick brick;
	private Motor motA, motB;
	private Port portA, portB;

	public TwoWheelRobot() {
		brick = new EV3Brick();
		motA = new Motor();	motB = new Motor();
		portA = brick.getPort("A"); portB = brick.getPort("B");
		motA.connect(portA); motB.connect(portB);
		speed = 0.5;
	}
	
	public void setSpeed(double sp) {		
		if(sp > 3.0 || sp < -3.0) {
			System.out.println("to high!");
			speed = 1.0;
		}
		else {
			speed = sp;
		}
	}
	
	public double getSpeed() {
		return speed;
	}
	
	// method to drive
	public void drive() {
		motA.start(speed);
		motB.start(speed);
	}
	
	// method to stop
	public void brake() {
		motA.stop();
		motB.stop();
	}
	
	// method to drive a specific time
	public void drive(double sek) {
		drive();
		Helper.delayProgramm(sek);
		brake();
	}
	
	// method to drive a specific length
	public void driveDist(double cm){
		double weelRotations = Helper.getRotations(cm);
		double driveTime = weelRotations / Math.abs(speed);
		drive(driveTime);
	}
	
	// method to rotate use 'l' for left or 'r' for right and the degree as an int
	public void turn(char dir, int grad) {
		double zeit = (2 * Helper.TRACKWIDTH / Helper.DIAMETER) * (grad/360.) * (1/Math.abs(speed));
		if(dir == 'r') {
			motA.start(speed);
			Helper.delayProgramm(zeit);
		} else {
			motB.start(speed);
			Helper.delayProgramm(zeit);
		}
		brake();
	}
	
	
	
}
