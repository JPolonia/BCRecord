package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import socket.ClientSocketConection;
import socket.SocketObject;

import logic.Manager;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class LoginWindow {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	JTextArea textArea;
	private JLabel lblInfo;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(new Color(100, 149, 237));
		getFrame().getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\workspace\\BCRecord\\img\\login_ico.png"));
		label.setBounds(169, 30, 128, 128);
		getFrame().getContentPane().add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(169, 228, 77, 22);
		getFrame().getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(169, 281, 67, 17);
		getFrame().getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 297, 136, 20);
		getFrame().getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(169, 250, 136, 20);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
				
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 10));
		textArea.setBackground(new Color(100, 149, 237));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBounds(158, 319, 163, 14);
		getFrame().getContentPane().add(textArea);
		
		lblInfo = new JLabel("");
		lblInfo.setBounds(203, 156, 67, 30);
		frame.getContentPane().add(lblInfo);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("medic");
		comboBox.addItem("patient");
		comboBox.setBounds(169, 205, 136, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRole.setBounds(169, 183, 56, 16);
		frame.getContentPane().add(lblRole);
		getFrame().setBounds(100, 100, 496, 428);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Boolean error = Manager.Login(textField.getText(),new String(passwordField.getPassword()),String.valueOf(comboBox.getSelectedItem()));
			
				if(error == false) {
					switch(String.valueOf(comboBox.getSelectedItem())) {
						case "medic": 
							MedicInterface med = new MedicInterface();
							med.getFrame().setVisible(true);
							frame.dispose();
							break;
						case "paciente":
							PatientWindow pat = new PatientWindow();
							pat.getFrame().setVisible(true);
							frame.dispose();
							break;
						default: 
							break;
				}
				} else {
					lblInfo.setText("Login Failed!");
				}

				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(193, 330, 89, 23);
		getFrame().getContentPane().add(btnLogin);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
