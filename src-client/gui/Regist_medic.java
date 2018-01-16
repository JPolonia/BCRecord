package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import database.PostgreSQL;
import socket.ClientSocketConection;
import socket.SocketObject;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Regist_medic {

	private JFrame frame;
	private JTextField Name_textField;
	private JTextField Username_textField;
	private JPasswordField passwordField;
	JLabel label_warning ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist_medic window = new Regist_medic();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Regist_medic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMedicRegistration = new JLabel("Medic registration");
		lblMedicRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMedicRegistration.setBounds(38, 40, 163, 31);
		frame.getContentPane().add(lblMedicRegistration);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(38, 113, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(38, 151, 59, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(38, 190, 59, 14);
		frame.getContentPane().add(lblPassword);
		
		Name_textField = new JTextField();
		Name_textField.setBounds(94, 110, 107, 20);
		frame.getContentPane().add(Name_textField);
		Name_textField.setColumns(10);
		
		Username_textField = new JTextField();
		Username_textField.setBounds(104, 148, 107, 20);
		frame.getContentPane().add(Username_textField);
		Username_textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 187, 104, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnRegist = new JButton("Regist");
		btnRegist.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRegist.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SocketObject objServer;
				ClientSocketConection client = new ClientSocketConection();
		    	SocketObject objClient = new SocketObject(3,client.getServerIP()); 
				
		    	
		    	
		    	client.newConnection();
		    	
		    	objClient.setNewUser(Username_textField.getText());
		    	objClient.setNewPassword(new String(passwordField.getPassword()));
		    	objClient.setCommand("INSERT MEDIC");
		    	
		    	System.out.println("INSERT INFO: " + objClient.getNewUser() + " " + objClient.getNewPassword());
				
		    	//Sends regist info to server
				client.sendObject(objClient);
		    
				//Waits for server response
				System.out.println("Waiting for server response...");
				objServer = client.getObject();
				
				//Checks if regist is correct
				if (objServer.getCommand().compareTo("INSERT OK") == 0) {			
					System.out.println("New User registed sucessfully\n");
					frame.dispose();
				} else {
					System.out.println("Failed to Regist...\n");
					label_warning.setText("Failed to Regist...");
					client.close();
				}
			}
			
				
				
		});
		
		btnRegist.setBounds(272, 216, 63, 23);
		frame.getContentPane().add(btnRegist);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				frame.dispose();
				
			}
		});
		
		btnCancel.setBounds(345, 216, 65, 23);
		frame.getContentPane().add(btnCancel);
		
		label_warning = new JLabel("");
		label_warning.setBounds(73, 225, 104, 14);
		frame.getContentPane().add(label_warning);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
