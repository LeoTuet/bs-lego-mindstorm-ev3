package robot.api;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;


public class LightSensor {

    private EV3ColorSensor sensor;
    private SensorMode mode;
    protected EV3Brick brick;

    public LightSensor(String port) {
        brick = new EV3Brick(); // TODO wtf leo
        connect(brick.getPort(port));
    }

    public LightSensor() {
    }

    public void connect(Port port) {
        sensor = new EV3ColorSensor(port);
        mode = sensor.getRedMode();
        sensor.setFloodlight(true);
    }

    public int[] sampleLightArray() {
        float[] sample = new float[1];
        int[] values = new int[10];

        for (int i = 0; i < 10; i++) {
            mode.fetchSample(sample, 0);
            values[i] = (int) (sample[0] * 100 + 0.5);
        }

        return values;
    }

    public int sampleLight() {
        double lightvalue = 0;
        for (int a : sampleLightArray()) {
            lightvalue = lightvalue + a;
        }
        return (int) (lightvalue / 10 + 0.5);
    }

    public void closeLight() {
        sensor.close();
    }

}
