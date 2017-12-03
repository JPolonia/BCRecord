package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.sql.*;

public class MedicInterface extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicInterface frame = new MedicInterface();
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
	public MedicInterface() {
		frame = new JFrame();
		frame.setBackground(Color.CYAN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente:");
		lblNewLabel.setBounds(10, 4, 60, 48);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(69, 18, 297, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data Nasc:");
		lblNewLabel_1.setBounds(405, 13, 90, 31);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(467, 18, 130, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("SNS:");
		lblNewLabel_2.setBounds(632, 13, 53, 31);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(663, 18, 130, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("D.1ªC:");
		lblNewLabel_3.setBounds(844, 9, 60, 39);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(881, 18, 130, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Nº Processo:");
		lblNewLabel_4.setBounds(1064, 13, 90, 31);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(1140, 18, 130, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(1280, 18, 20, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 52, 1342, 678);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Rastreio", null, panel, null);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Não");
		rdbtnNewRadioButton.setBounds(34, 33, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Sim");
		rdbtnNewRadioButton_1.setBounds(34, 77, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		/**
		 * Responsible to make sure only one button is selected
		 */
		ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);
		
		JLabel lblDataDeAferio = new JLabel("Data de Aferição:");
		lblDataDeAferio.setBounds(324, 33, 109, 23);
		panel.add(lblDataDeAferio);
		
		JLabel lblNewLabel_5 = new JLabel("Data de Rastreio:");
		lblNewLabel_5.setBounds(324, 79, 109, 19);
		panel.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(426, 34, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(426, 78, 86, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Identificação (N/Conc./Volta):");
		lblNewLabel_6.setBounds(34, 174, 297, 38);
		panel.add(lblNewLabel_6);
		
		textField_8 = new JTextField();
		textField_8.setBounds(208, 183, 244, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 273, 1317, 23);
		panel.add(separator);
		
		JLabel lblResidncia = new JLabel("Residência:");
		lblResidncia.setBounds(34, 325, 76, 14);
		panel.add(lblResidncia);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(34, 365, 76, 14);
		panel.add(lblIdade);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(34, 406, 109, 14);
		panel.add(lblEstadoCivil);
		
		textField_9 = new JTextField();
		textField_9.setBounds(109, 322, 244, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(109, 362, 43, 19);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(109, 403, 86, 20);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Gravar");
		btnNewButton_1.setBounds(1238, 616, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Localização", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Imagem", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Biopsias", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Estadiamento", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Cirurgia", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Patologia", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("QT/RT/HT", null, panel_7, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Follow up", null, panel_8, null);
		
		JButton btnNewButton = new JButton("Exportar");
		btnNewButton.setBounds(1263, 49, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPacient proc_paciente = new SearchPacient();
				proc_paciente.getFrame().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(375, 18, 20, 20);
		contentPane.add(btnNewButton_2);
	}
}
