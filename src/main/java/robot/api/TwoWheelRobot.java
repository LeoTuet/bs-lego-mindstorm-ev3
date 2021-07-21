package robot.api;// Bauplanklasse
import lejos.hardware.port.Port;
public class TwoWheelRobot {
	// Instanzvariable
	protected double speed;
	protected EV3Brick baustein;
	private Motor motA, motB;
	private Port portA, portB;	
	
	// Konstruktor
	public TwoWheelRobot() {
		baustein = new EV3Brick();
		motA = new Motor();	motB = new Motor();
		portA = baustein.getPort("A"); portB = baustein.getPort("B");
		motA.connect(portA); motB.connect(portB);
		speed = 0.5;
	}
	
	public void setSpeed(double sp) {		
		if(sp > 3.0 || sp < -3.0) {
			System.out.println("Zu hoch!");
			speed = 1.0;
		}
		else {
			speed = sp;
		}
	}
	
	public double getSpeed() {
		return speed;
	}
	
	// Methode zum einschalten der Motore ("Gas geben")
	public void drive() {
		motA.start(speed);
		motB.start(speed);
	}
	
	// Methode zum anhalten der Motore ("Bremsen")
	public void brake() {
		motA.stop();
		motB.stop();
	}
	
	// Methoden zum Fahren für übergebenen Zeitraum
	public void drive(double sek) {
		drive();
		Helfer.delayProgramm(sek);
		brake();
	}
	
	// Methode zum Fahren für übergebene Strecke
	public void driveDist(double cm){
		double radUmdrehungen = Helfer.getUmdrehungen(cm);		
		double fahrzeit = radUmdrehungen / Math.abs(speed);		
		drive(fahrzeit);
	}
	
	// Methode zum Drehen, Übergabeparameter: Richtung 'l' oder 'r' und Gradzahl 
	public void turn(char dir, int grad) {
		double zeit = (2 * Helfer.SPURWEITE / Helfer.DURCHMESSER) * (grad/360.) * (1/Math.abs(speed));
		if(dir == 'r') {
			motA.start(speed);
			Helfer.delayProgramm(zeit);
		} else {
			motB.start(speed);
			Helfer.delayProgramm(zeit);			
		}
		brake();
	}
	
	
	
}
