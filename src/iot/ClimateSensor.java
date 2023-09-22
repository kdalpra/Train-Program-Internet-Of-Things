package iot;

public class ClimateSensor extends Sensor {
	
	private double humidity = 0;
	private double temperature = 0;
	
	public ClimateSensor(int sensorType, int sensorNumber) {
		super(sensorType, sensorNumber);
	}
	
	public double getTemperature() {
		return temperature;
	}
	public double getHumidity() {
		return humidity;
	}

}
