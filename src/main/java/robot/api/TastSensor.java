package robot.api;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;
public class TastSensor {


		
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
			int druck = (int)(sample[0] );
			boolean druck1;
			if (druck==1){
				druck1=true;
			}
			else {druck1=false;
			}
			
			return (druck1);
	    }
		
				
		public void closeTouch() {
			sensor.close();
		}
}

	
	

