package robot.core;

import robot.api.TouchSensor;

public class BetterTouchSensor extends TouchSensor {

    private boolean lastTouchState;


    public BetterTouchSensor(String port) {
        super(port);
        lastTouchState = false;
    }

    public boolean wasReTouched() {
        boolean result = false;
        boolean touched = this.sampleTouch();
        if (!lastTouchState && touched) result = true;
        lastTouchState = touched;
        if (result) System.out.println(result);
        return result;
    }

}
