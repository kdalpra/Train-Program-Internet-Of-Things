package iot;

public class Sensor {
	public static final int OBJECT = 0;
	public static final int CLIMATE = 1;
	public static final int WHEEL = 2;
	
	private int sensorType;
	private int sensorNumber;
	private int battery;
	
	public Sensor(int sensorType, int sensorNumber) {
		this.sensorType = sensorType;
		this.sensorNumber = sensorNumber;
		this.battery = 100;
	}
	
	
	public int getSensorType() {
		return sensorType;
	}
	public int getSensorNumber() {
		return sensorNumber;
	}
	public void setSensorNumber(int sensorNumber) {
		this.sensorNumber = sensorNumber;
	}
	
	
	

}
