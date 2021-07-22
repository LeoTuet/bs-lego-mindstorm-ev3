package robot.api;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;
public class TouchSensor {


		
		private Port port;
		private EV3TouchSensor sensor;
		private SampleProvider sp;
		
		
		
		public void connect(Port port)
		{
			sensor = new EV3TouchSensor(port);
			sp = sensor.getMode("Touch");
		}
		
		boolean sampleTouch (){
			float[] sample = new float[sp.sampleSize()];
			sp.fetchSample(sample, 0);
			int touch = (int)(sample[0] );
			boolean isTouched;
			if (touch==1){
				isTouched=true;
			}
			else {isTouched=false;
			}
			
			return (isTouched);
	    }
		
				
		public void closeTouch() {
			sensor.close();
		}
}

	
	

