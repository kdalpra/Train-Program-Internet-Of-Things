package iot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Reza {

	private JFrame frame;
	public boolean isRunning = true;
	
	public int theMin = 0;
	private JPanel panel_2;
	private JLabel label;
	private JTextField regUsr;
	private JTextField regPsw;
	private JLabel label_1;
	private JTextField regAge;
	private JLabel label_2;
	private JTextField regName;
	private JLabel label_3;
	private JButton regBtn;
	private JLabel label_4;
	private JTextField userName;
	private JLabel label_5;
	private JPasswordField passwordBox;
	private JButton loginBtn;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reza window = new Reza();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reza() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1060, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Conductor.Conductor("jsmith", "password", "John Smith", 25, 12345678);
		HashMap<String, String> logins = new HashMap<String, String>();
		logins.put("jsmith","password");
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 23, 490, 398);
		frame.getContentPane().add(panel_2);
		
		label = new JLabel("Username:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(50, 41, 140, 31);
		panel_2.add(label);
		
		regUsr = new JTextField();
		regUsr.setColumns(10);
		regUsr.setBounds(50, 76, 140, 42);
		panel_2.add(regUsr);
		
		regPsw = new JTextField();
		regPsw.setColumns(10);
		regPsw.setBounds(50, 182, 140, 42);
		panel_2.add(regPsw);
		
		label_1 = new JLabel("Password");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(50, 141, 140, 31);
		panel_2.add(label_1);
		
		//Doesn't allow letters in the age field
		regAge = new JTextField();
		regAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!Character.isDigit(c)) {
					arg0.consume();
				}
			}
		});
		regAge.setColumns(10);
		regAge.setBounds(299, 182, 140, 42);
		panel_2.add(regAge);
		
		label_2 = new JLabel("Age:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setBounds(299, 140, 140, 31);
		panel_2.add(label_2);
		
		regName = new JTextField();
		regName.setColumns(10);
		regName.setBounds(299, 76, 140, 42);
		panel_2.add(regName);
		
		label_3 = new JLabel("Full Name:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_3.setBounds(299, 41, 140, 31);
		panel_2.add(label_3);
		
		regBtn = new JButton("Register");
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//every box must be filled to register
				if(regUsr.getText().equals("") || regPsw.getText().equals("") || regAge.getText().equals("") || regName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in every box.");
				}
				
				else {
						//adds the new user to the login hashmap
						 int id = (int)(Math.random()*100000);

						 if(logins.containsKey(regUsr.getText())) {
							 JOptionPane.showMessageDialog(null, "Username already exists." );
						 }
						 else {
							 logins.put(regUsr.getText(), regPsw.getText());
							 JOptionPane.showMessageDialog(null, "User added successfully.\nID: " + String.valueOf(id) );
							 
						 }
						 regUsr.setText("");
						 regPsw.setText("");
						 regAge.setText("");
						 regName.setText("");
						 
				}
			}
		});
		regBtn.setFont(new Font("Tahoma", Font.PLAIN, 27));
		regBtn.setBounds(50, 271, 389, 84);
		panel_2.add(regBtn);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(544, 23, 490, 398);
		frame.getContentPane().add(panel);
		
		passwordBox = new JPasswordField();
		passwordBox.setBounds(225, 181, 223, 46);
		panel.add(passwordBox);
		
		userName = new JTextField();
		userName.setBounds(225, 74, 223, 46);
		panel.add(userName);
		userName.setColumns(10);
		
		loginBtn = new JButton("Log In");
		loginBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//every box must be filled in to login
				if (passwordBox.getText().equals("") || userName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter username and password.");
				}
				else {
					//checks the hashmap if the username and password combination exists
					if(logins.containsKey(userName.getText())) {
						if(logins.get(userName.getText()).equals(passwordBox.getText())) {
							frame.dispose();
							Display disp = new Display();
							disp.setVisible(true);
						}
					}
					else {
						//incorrect combination was supplied
						JOptionPane.showMessageDialog(null, "Incorrect username or password.");
					}
				}
			}
		});
		loginBtn.setBounds(59, 274, 389, 84);
		panel.add(loginBtn);
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		label_4 = new JLabel("Username:");
		label_4.setBounds(59, 74, 156, 46);
		panel.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 27));
		

		label_5 = new JLabel("Password:");
		label_5.setBounds(59, 187, 156, 35);
		panel.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 27));
	}
	

}
