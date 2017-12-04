package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import database.PostgreSQL;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Regist_patient {

	private JFrame frame;
	private JTextField textField_Name;
	private JTextField textField_birthDate;
	private JTextField textField_sns;
	private JTextField textField_date1c;
	private JTextField textField_address;
	private JTextField textField_civilState;
	private JTextField textField_username;
	private JPasswordField passwordField;
	private JLabel label_warning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist_patient window = new Regist_patient();
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
	public Regist_patient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 500, 360);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblPacientRegistration = new JLabel("Pacient registration");
		lblPacientRegistration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPacientRegistration.setBounds(21, 11, 141, 23);
		getFrame().getContentPane().add(lblPacientRegistration);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(21, 71, 39, 14);
		getFrame().getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(318, 71, 74, 14);
		getFrame().getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(318, 121, 74, 14);
		getFrame().getContentPane().add(lblPassword);
		
		JLabel lblBirthDate = new JLabel("Birth date:");
		lblBirthDate.setBounds(21, 96, 62, 14);
		getFrame().getContentPane().add(lblBirthDate);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(21, 171, 46, 14);
		getFrame().getContentPane().add(lblAdress);
		
		JLabel lblSns = new JLabel("SNS:");
		lblSns.setBounds(21, 121, 46, 14);
		getFrame().getContentPane().add(lblSns);
		
		JLabel lblDatec = new JLabel("Date 1c:");
		lblDatec.setBounds(21, 146, 46, 14);
		getFrame().getContentPane().add(lblDatec);
		
		JLabel lblCivilState = new JLabel("Civil state:");
		lblCivilState.setBounds(21, 196, 68, 14);
		getFrame().getContentPane().add(lblCivilState);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(103, 68, 141, 20);
		getFrame().getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_birthDate = new JTextField();
		textField_birthDate.setBounds(103, 93, 74, 20);
		getFrame().getContentPane().add(textField_birthDate);
		textField_birthDate.setColumns(10);
		
		textField_sns = new JTextField();
		textField_sns.setBounds(103, 118, 74, 20);
		getFrame().getContentPane().add(textField_sns);
		textField_sns.setColumns(10);
		
		textField_date1c = new JTextField();
		textField_date1c.setBounds(103, 143, 86, 20);
		getFrame().getContentPane().add(textField_date1c);
		textField_date1c.setColumns(10);
		
		textField_address = new JTextField();
		textField_address.setBounds(103, 168, 157, 20);
		getFrame().getContentPane().add(textField_address);
		textField_address.setColumns(10);
		
		textField_civilState = new JTextField();
		textField_civilState.setBounds(103, 193, 86, 20);
		getFrame().getContentPane().add(textField_civilState);
		textField_civilState.setColumns(10);
		
		textField_username = new JTextField();
		textField_username.setBounds(318, 93, 105, 20);
		getFrame().getContentPane().add(textField_username);
		textField_username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(318, 143, 105, 20);
		getFrame().getContentPane().add(passwordField);
		
		JButton btnRegist = new JButton("Regist");
		btnRegist.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegist.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				
				String[] args = new String[3];
				PostgreSQL con = database.Main.main(args);
				
				if(con.registPatient(textField_Name.getText(), textField_username.getText(), new String(passwordField.getPassword()), textField_birthDate.getText(),
						Integer.parseInt(textField_sns.getText()), textField_date1c.getText(), textField_address.getText(), textField_civilState.getText()) == 1)
				{	
					getFrame().dispose();
						
				}else	
				{
					label_warning.setText("Wrong regist");
					//textArea.setText("Wrong login. Try again.");					
				}
			}
		});
		btnRegist.setBounds(364, 274, 74, 23);
		getFrame().getContentPane().add(btnRegist);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MedicWindow jan = new MedicWindow();
				jan.getFrame().setVisible(true);
				getFrame().dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCancel.setBounds(281, 274, 74, 23);
		getFrame().getContentPane().add(btnCancel);
		
		label_warning = new JLabel("");
		label_warning.setBounds(56, 236, 114, 14);
		getFrame().getContentPane().add(label_warning);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
