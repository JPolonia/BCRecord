package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JanelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
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
	public JanelaPrincipal() {
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
				
				RegistMedic jan_regist = new RegistMedic();
				jan_regist.getFrame().setVisible(true);
			}
		});
		btnRegistMedic.setBounds(23, 51, 103, 23);
		frame.getContentPane().add(btnRegistMedic);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	

}
