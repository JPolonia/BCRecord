package gui;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PatientWindow {

	private JFrame frame;
	private JLabel label_PatientName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientWindow window = new PatientWindow();
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
	public PatientWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(20, 21, 46, 14);
		frame.getContentPane().add(lblPaciente);
		
		label_PatientName = new JLabel("");
		label_PatientName.setBounds(76, 21, 155, 14);
		frame.getContentPane().add(label_PatientName);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
	}
	
	public JLabel getLabel_PatientName() {
		return label_PatientName;
	}

}
