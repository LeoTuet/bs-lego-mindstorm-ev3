package robot.api;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;


public class LightSensor {
    EV3ColorSensor sensor;
    SensorMode mode;

    public void connect(Port port) {
        sensor = new EV3ColorSensor(port);
        mode = sensor.getRedMode();
        sensor.setFloodlight(true);
    }

    public byte[] sampleLightArray() {
        float[] sample = new float[1];
        byte[] values = new byte[10];

        for (byte i = 0; i < 10; i++) {
            mode.fetchSample(sample, 0);
            values[i] = (byte) (sample[0] * 100 + 0.5);
        }
        return values;
    }


    public int sampleLight() {
        int lightvalue = 0;
        for (byte a : sampleLightArray()) {
            lightvalue = lightvalue + a;
        }
        return (int) (lightvalue / 10 + 0.5);
    }

    public void closeLight() {
        sensor.close();
    }


}
