package iot;

public class WheelSensor extends Sensor{
	private double rpm = 0;
	
	public WheelSensor(int sensorType, int sensorNumber) {
		super(sensorType, sensorNumber);
	}
	
	public boolean detectWheelSlipping() {
		//todo
		return false;
	}

	public void calculateRPM() {
		double calculated = 0;
		//todo
		this.rpm = calculated;
	}
	
	public double getRPM() {
		calculateRPM();
		return rpm;
	}
	
}
