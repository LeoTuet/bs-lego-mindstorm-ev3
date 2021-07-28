package robot.api;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;


public class UltrasoundSensor {

    private EV3UltrasonicSensor sensor;
    private SampleProvider sp;
    protected EV3Brick brick;

    public UltrasoundSensor(String port) {
        brick = new EV3Brick();
        connect(brick.getPort(port));
    }

    public UltrasoundSensor() {
    }

    public void connect(Port port) {
        sensor = new EV3UltrasonicSensor(port);
        sp = sensor.getMode("Distance");
    }

    public int sampleSonic() {
        float[] sample = new float[sp.sampleSize()];
        sp.fetchSample(sample, 0);
        int dist = (int) (sample[0] * 100 + 0.5);
        return (dist);
    }

    public int[] sampleSonicArray() {
        float[] sample = new float[1];
        int[] values = new int[10];
        for (int i = 0; i < 10; i++) {
            sp.fetchSample(sample, 0);
            values[i] = (int) (sample[0] * 100 + 0.5);
        }
        return values;
    }

    public void closeSonic() {
        sensor.close();
    }

}
