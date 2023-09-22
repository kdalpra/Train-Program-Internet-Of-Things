package iot;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.annotation.Resource;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Display extends JFrame {
	public boolean isRunning = false;

	private JPanel contentPane;
	private String logs = "Train Logs:\n";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Display() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHorn = new JLabel("Horn");
		lblHorn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorn.setForeground(Color.LIGHT_GRAY);
		lblHorn.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		lblHorn.setBounds(345, 329, 200, 44);
		contentPane.add(lblHorn);
		
		JLabel wheelMsg = new JLabel("");
		wheelMsg.setHorizontalAlignment(SwingConstants.CENTER);
		wheelMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		wheelMsg.setBounds(37, 305, 200, 44);
		contentPane.add(wheelMsg);
		
		JLabel objectMsg = new JLabel("");
		objectMsg.setHorizontalAlignment(SwingConstants.CENTER);
		objectMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		objectMsg.setBounds(247, 305, 200, 44);
		contentPane.add(objectMsg);
		
		JLabel animalMsg = new JLabel("");
		animalMsg.setHorizontalAlignment(SwingConstants.CENTER);
		animalMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		animalMsg.setBounds(446, 305, 200, 44);
		contentPane.add(animalMsg);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/wheel1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(37, 94, 200, 200);
		contentPane.add(lblNewLabel);
		
		JLabel objectLbl = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/object1.png")).getImage();
		objectLbl.setIcon(new ImageIcon(img2));
		objectLbl.setBounds(247, 94, 200, 200);
		contentPane.add(objectLbl);

		JLabel animalLbl = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/animal1.png")).getImage();
		animalLbl.setIcon(new ImageIcon(img3));
		animalLbl.setBounds(446, 94, 200, 200);
		contentPane.add(animalLbl);
		
		JLabel gateLbl = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/gate1.png")).getImage();
		gateLbl.setIcon(new ImageIcon(img4));
		gateLbl.setBounds(656, 94, 200, 200);
		contentPane.add(gateLbl);
		
		JLabel gateMsg = new JLabel("");
		gateMsg.setHorizontalAlignment(SwingConstants.CENTER);
		gateMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		gateMsg.setBounds(656, 305, 200, 44);
		contentPane.add(gateMsg);
		
		JLabel hornTxt = new JLabel("");
		hornTxt.setHorizontalAlignment(SwingConstants.CENTER);
		hornTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		hornTxt.setBounds(345, 476, 200, 44);
		contentPane.add(hornTxt);
		
		JLabel hornLbl = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/horn1.png")).getImage();
		hornLbl.setIcon(new ImageIcon(img5));
		hornLbl.setBounds(345, 319, 200, 200);
		contentPane.add(hornLbl);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 40));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!isRunning) {
					isRunning = true;
					btnNewButton.setText("Running...");
					theLoop(lblNewLabel, objectLbl, animalLbl, wheelMsg, objectMsg, animalMsg, btnNewButton, gateLbl, gateMsg, hornLbl, hornTxt);
				}
			}
		});
		btnNewButton.setBounds(247, 549, 428, 75);
		contentPane.add(btnNewButton);
		
		JLabel lblWheelSlip = new JLabel("Wheel Slip Detection");
		lblWheelSlip.setForeground(Color.LIGHT_GRAY);
		lblWheelSlip.setHorizontalAlignment(SwingConstants.CENTER);
		lblWheelSlip.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		lblWheelSlip.setBounds(37, 39, 200, 44);
		contentPane.add(lblWheelSlip);
		
		JLabel lblObjectDetection = new JLabel("Object Detection");
		lblObjectDetection.setHorizontalAlignment(SwingConstants.CENTER);
		lblObjectDetection.setForeground(Color.LIGHT_GRAY);
		lblObjectDetection.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		lblObjectDetection.setBounds(247, 39, 200, 44);
		contentPane.add(lblObjectDetection);
		
		JLabel lblAnimalDetection = new JLabel("Animal Detection");
		lblAnimalDetection.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimalDetection.setForeground(Color.LIGHT_GRAY);
		lblAnimalDetection.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		lblAnimalDetection.setBounds(446, 39, 200, 44);
		contentPane.add(lblAnimalDetection);
		
		JLabel lblGateDetection = new JLabel("Gate Detection");
		lblGateDetection.setHorizontalAlignment(SwingConstants.CENTER);
		lblGateDetection.setForeground(Color.LIGHT_GRAY);
		lblGateDetection.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		lblGateDetection.setBounds(656, 39, 200, 44);
		contentPane.add(lblGateDetection);
		
		JButton btnViewLogs = new JButton("Logs");
		btnViewLogs.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		btnViewLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, logs);
			}
		});
		btnViewLogs.setBounds(799, 549, 89, 75);
		contentPane.add(btnViewLogs);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 889, 527);
		contentPane.add(panel);

	}
	
	//parses the wheel sensor data, and returns a warning code if a wheel's RPM is too high
	public int checkWheel(String line) {
		String temp = "";
		int wheelNum = 0;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == ',') {
				try {
				if(Integer.parseInt(temp) > 525) {
					return wheelNum;
				}
				}catch(Exception e){
					return -1;
				}
				wheelNum++;
				temp = "";
				
			}
			else {
				temp = temp + line.charAt(i);
			}
		}
		try {
		if(Integer.parseInt(temp) > 525) {
			return wheelNum;
		}}
		catch(Exception e) {
			return -1;
		}
		return -1;
	}
	
	//parses the moving object sensor data and returns the direction that the object/animal is moving
	public String checkAnimal(String line) {
		if(line.length() < 3) {
			return " ";
		}
		String temp = "";
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == ',') {
				temp = "";
			}
			else {
				temp = temp + line.charAt(i);
			}
		}
		if(temp.length() == 0 || temp.length() > 2) {
			return " ";
		}
		return temp;
	}
	
	//parses the moving object sensor data and returns the distance of the object/animal 
	public int checkAnimalNum(String line) {
		if(line.length() < 3) {
			return 0;
		}
		
		try {
		String temp = "";
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == ',') {
				return Integer.parseInt(temp);
			}
			else {
				temp = temp + line.charAt(i);
			}
		}
	}catch(Exception e){
		return 0;
	}
		return 0;
	}
	
	//parses the immobile object sensor and returns a distance value if an object is detected
	public int checkObject(String line) {
		if(line.equals(" ")) {
			return 0;
		}
		try {
			if(Integer.parseInt(line) > 0) {
				return Integer.parseInt(line);
		}}
		catch(Exception e){
			return 0;
		}
		return 0;
	}
	public int checkGate(String line) {
		try {
			int x = Integer.parseInt(line);
			return x;
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	//changes the icons accordingly
	public void updateDisplay(JLabel lbl, String imgStr) {
		Image img2 = new ImageIcon(this.getClass().getResource(imgStr)).getImage();
		lbl.setIcon(new ImageIcon(img2));
	}
	
	//changes the warning messages accordingly
	public void updateMsg(JLabel lbl, String msg) {
		lbl.setText(msg);
	}
	
	
	//main function, checks new data from the sensors
	public void theLoop( JLabel lblNewLabel, JLabel objectLbl, JLabel animalLbl, JLabel wheelMsg, JLabel objectMsg, 
			JLabel animalMsg, JButton btnNewButton, JLabel gateLbl, JLabel gateMsg, JLabel hornLbl, JLabel hornTxt) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int timeInterval = 0;
					int alert = -15;
					int alert2 = -15;
					int alert3 = -15;
					int alert4 = -15;
					int horn = -45;
					
						//````````` Gets Data From Sensors `````````\\
					
					InputStream is = getClass().getResourceAsStream("/wheels.txt");
					InputStream is2 = getClass().getResourceAsStream("/objects.txt");
					InputStream is3 = getClass().getResourceAsStream("/animals.txt");
					InputStream is4 = getClass().getResourceAsStream("/gates.txt");
		
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
					BufferedReader br3 = new BufferedReader(new InputStreamReader(is3));
					BufferedReader br4 = new BufferedReader(new InputStreamReader(is4));
					
					String line;
					String objectLine;
					String animalLine;
					String gateLine;
					

					while((line = br.readLine()) != null 
							&& (objectLine = br2.readLine()) != null 
							&& (animalLine = br3.readLine()) != null
							&& (gateLine = br4.readLine()) != null) {
						
						//````````` Gets Data From Sensors `````````\\
						
						
						//````````` Wheel Slip Detection `````````\\
						int wheelCode = checkWheel(line);
						if(wheelCode != -1) {
							alert = timeInterval;
							System.out.println("Wheel Slip Detected On Wheel #" + String.valueOf(wheelCode) + " At Time Interval: " + String.valueOf(timeInterval) );
							logs += "Wheel Slip Detected On Wheel #" + String.valueOf(wheelCode) + " At Time Interval: " + String.valueOf(timeInterval) + "\n";
							updateDisplay(lblNewLabel, "/wheel2.png");
							updateMsg(wheelMsg, "Wheel #" + String.valueOf(wheelCode));
						}
						//````````` Wheel Slip Detection `````````\\
						
						
						//````````` Object Detection `````````\\
						int objectCode = checkObject(objectLine);
						if(objectCode != 0) {
							alert2 = timeInterval;
							System.out.println("Object Detected " + String.valueOf(objectCode) +" Feet Away At Time Interval: "+ String.valueOf(timeInterval));
							logs += "Object Detected " + String.valueOf(objectCode) +" Feet Away At Time Interval: "+ String.valueOf(timeInterval) + "\n";
							updateDisplay(objectLbl, "/object2.png");
							updateMsg(objectMsg, String.valueOf(objectCode) + " Feet");
						}
						//````````` Object Detection `````````\\
						
						
						//````````` Animal Detection `````````
						int animalCode = checkAnimalNum(animalLine);
						String animalDir = checkAnimal(animalLine);
						if(animalCode != 0) {
							alert3 = timeInterval;
							System.out.println("Object Detected Moving At: " + String.valueOf(animalCode) + " MPH, With A Direction Of: " + animalDir+ " At Time Interval: " + String.valueOf(timeInterval));
							logs += "Object Detected Moving At: " + String.valueOf(animalCode) + " MPH, With A Direction Of: " + animalDir + " At Time Interval: " + String.valueOf(timeInterval) +"\n";
							updateDisplay(animalLbl, "/animal2.png");
							updateMsg(animalMsg, String.valueOf(animalCode) + " MPH, " + animalDir);
						}
						//````````` Animal Detection `````````\\
						
						
						//````````` Gate Detection `````````\\
						int gateCode = checkGate(gateLine);
						//1 gate ahead, 2 gate not down!
						if(gateCode == 1) {
							alert4 = timeInterval;
							horn = timeInterval;
							System.out.println("Upcoming Gate: 1 Mile.");
							logs += "Upcoming Gate: 1 Mile." + " At Time Interval: " + String.valueOf(timeInterval) + "\n";
							updateDisplay(gateLbl, "/gate3.png");
							updateDisplay(hornLbl, "/horn2.png");
							updateMsg(gateMsg, "Gate Crossing Ahead: 1 Mile");
							updateMsg(hornTxt, "Horn Activated.");
						}
						if(gateCode == 2) {
							alert4 = timeInterval;
							horn = timeInterval;
							System.out.println("Upcoming Gate Is Not Down! 1 Mile");
							logs += "Upcoming Gate Is Not Down! 1 Mile" + " At Time Interval: " + String.valueOf(timeInterval) + "\n";
							updateDisplay(gateLbl, "/gate2.png");
							updateDisplay(hornLbl, "/horn2.png");
							updateMsg(gateMsg, "Gate Is Not Down!");
							updateMsg(hornTxt, "Horn Activated.");
						}
						//````````` Gate Detection `````````\\
						
						
						//````````` Alert Completion `````````\\
						if(timeInterval == alert + 15) {
							updateDisplay(lblNewLabel, "/wheel1.png");
							updateMsg(wheelMsg, " ");
						}
						if(timeInterval == alert2 + 15) {
							updateDisplay(objectLbl, "/object1.png");
							updateMsg(objectMsg, " ");
						}
						if(timeInterval == alert3 + 15) {
							updateDisplay(animalLbl, "/animal1.png");
							updateMsg(animalMsg, " ");
						}
						if(timeInterval == alert4 + 15) {
							updateDisplay(gateLbl, "/gate1.png");
							updateMsg(gateMsg, " ");
						}
						if(timeInterval == horn + 30) {
							System.out.println("Gate Reached.");
						}
						if(timeInterval == horn + 40) {
							updateDisplay(hornLbl, "/horn1.png");
							updateMsg(hornTxt, " ");
						}
						//````````` Alert Completion`````````\\
						
						
						timeInterval++;
						Thread.sleep(500);
					}
					br.close();
					br2.close();
					br3.close();
					br4.close();
					btnNewButton.setText("Train Has Stopped.");
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}
}
