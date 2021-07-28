package robot.api;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class TouchSensor {

    private EV3TouchSensor sensor;
    private SampleProvider sp;
    private boolean isTouched;
    protected EV3Brick brick;

    public TouchSensor(String port) {
        brick = new EV3Brick();
        connect(brick.getPort(port));
    }

    public TouchSensor() {
    }

    public void connect(Port port) {
        sensor = new EV3TouchSensor(port);
        sp = sensor.getMode("Touch");
    }

    public boolean sampleTouch() {
        float[] sample = new float[sp.sampleSize()];
        sp.fetchSample(sample, 0);
        int touch = (int) (sample[0]);
        if (touch == 1) {
            this.isTouched = true;
        } else {
            this.isTouched = false;
        }
        return (isTouched);
    }

    public void setTouched(boolean isTouched) {
        this.isTouched = isTouched;
    }

    public void closeTouch() {
        sensor.close();
    }

}

	
	

