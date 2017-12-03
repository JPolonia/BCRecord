package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class MedicWindow {

	private JFrame frame;
	private JLabel label_MedicName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicWindow window = new MedicWindow();
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
	public MedicWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 900, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRegistMedic = new JButton("Regist medic");
		btnRegistMedic.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRegistMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Regist_medic jan_regist = new Regist_medic();
				jan_regist.getFrame().setVisible(true);
			}
		});
		btnRegistMedic.setBounds(23, 104, 101, 23);
		frame.getContentPane().add(btnRegistMedic);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LoginWindow login_jan = new LoginWindow();
				login_jan.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnLogOut.setBounds(23, 172, 101, 23);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnRegistPacient = new JButton("Regist pacient");
		btnRegistPacient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Regist_patient jan = new Regist_patient();
				jan.getFrame().setVisible(true); 
			}
		});
		btnRegistPacient.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegistPacient.setBounds(23, 138, 101, 23);
		frame.getContentPane().add(btnRegistPacient);
		
		JLabel label_Medic = new JLabel("M\u00E9dico");
		label_Medic.setBounds(23, 27, 46, 14);
		frame.getContentPane().add(label_Medic);
		
		label_MedicName = new JLabel();
		getLabel_MedicName().setBounds(78, 27, 182, 14);
		frame.getContentPane().add(getLabel_MedicName());
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
	}

	public JLabel getLabel_MedicName() {
		return label_MedicName;
	}

	public void setLabel_MedicName(String string) {
		this.label_MedicName.setText(string); 
	}
}
