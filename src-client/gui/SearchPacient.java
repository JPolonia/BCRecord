package gui;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.PostgreSQL;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SearchPacient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPacient frame = new SearchPacient();
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
	public SearchPacient() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 900, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(49, 59, 128, 20);
		contentPane.add(nome);
		
		textField = new JTextField();
		textField.setBounds(103, 59, 240, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Contido?");
		chckbxNewCheckBox.setBounds(49, 159, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {
					rs = PostgreSQL.getDate("SELECT * FROM paciente WHERE nome='"+nome.getText()+"'");
				}catch(Exception e) {
					e.printStackTrace();
				}*/
				
			}
		});
		btnProcurar.setBounds(254, 159, 89, 23);
		contentPane.add(btnProcurar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
