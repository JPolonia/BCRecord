package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import database.PostgreSQL;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class BCRecordInterface {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BCRecordInterface window = new BCRecordInterface();
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
	public BCRecordInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/login_ico.png")).getImage();
		label.setIcon(new ImageIcon("D:\\git\\BCRecord\\img\\login_ico.png"));
		label.setBounds(169, 30, 128, 128);
		frame.getContentPane().add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(169, 183, 77, 22);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(169, 236, 67, 17);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 252, 136, 20);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(169, 205, 136, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String args[] = new String[2];
				
				PostgreSQL con = database.Main.main(args);
				
				
				/*args[0]="login";
				args[1]=textField.getText();
				args[2]=b;
				
				//System.out.println(args[0]);
				//System.out.println(args[1]);*/
				
				if( con.login(textField.getText(), new String(passwordField.getPassword()) )== 1)
				{
					JanelaPrincipal janel_principal = new JanelaPrincipal();
					janel_principal.getFrame().setVisible(true);
					frame.dispose();
					
				}else	
				{
					textArea.setText("Wrong login. Try again.");
				}
				con.disconect();
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(193, 285, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 10));
		textArea.setBackground(new Color(100, 149, 237));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBounds(158, 319, 163, 14);
		frame.getContentPane().add(textArea);
		frame.setBounds(100, 100, 496, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
