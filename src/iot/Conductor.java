package iot;

public class Conductor {
	
	private static String username;
	private static String password;
	private static String conductorName;
	private static int age;
	private static int id;
	
	public Conductor() {
		Conductor.username = "jsmith";
		Conductor.password = "password";
		Conductor.conductorName = "John Smith";
		Conductor.age = 25;
		Conductor.id = 12345678;
	}
	
	public static void Conductor(String username, String password, String conductorName, int age, int id) {
		Conductor.username = username;
		Conductor.password = password;
		Conductor.conductorName = conductorName;
		Conductor.age = age;
		Conductor.id = id;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static void setUsername(String username) {
		Conductor.username = username;
	}
	public static String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		Conductor.password = password;
	}
	
	
	public String getConductorName() {
		return conductorName;
	}
	public void setConductorName(String conductorName) {
		Conductor.conductorName = conductorName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		Conductor.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		Conductor.id = id;
	}



	
	
}
