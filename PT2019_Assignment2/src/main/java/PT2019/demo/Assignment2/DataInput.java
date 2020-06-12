package PT2019.demo.Assignment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class DataInput extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataInput frame = new DataInput();
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
	public DataInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputData = new JLabel("Input Data");
		lblInputData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInputData.setBounds(167, 11, 91, 22);
		contentPane.add(lblInputData);
		
		JLabel lblMinimalArrivingTime = new JLabel("Minimum Arriving Time");
		lblMinimalArrivingTime.setBounds(25, 68, 147, 22);
		contentPane.add(lblMinimalArrivingTime);
		
		JLabel lblMaximumArrivingTime = new JLabel("Maximum Arriving Time");
		lblMaximumArrivingTime.setBounds(25, 101, 147, 22);
		contentPane.add(lblMaximumArrivingTime);
		
		JLabel lblMinimumnprocessingTime = new JLabel("Minimum Processing Time");
		lblMinimumnprocessingTime.setBounds(25, 137, 165, 22);
		contentPane.add(lblMinimumnprocessingTime);
		
		JLabel lblMaximumProcessingTime = new JLabel("Maximum Processing Time");
		lblMaximumProcessingTime.setBounds(25, 170, 165, 22);
		contentPane.add(lblMaximumProcessingTime);
		
		textField = new JTextField("2");
		textField.setBounds(200, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("9");
		textField_1.setBounds(200, 102, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("2");
		textField_2.setBounds(200, 138, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField("6");
		textField_3.setBounds(200, 169, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStart.setBounds(319, 135, 89, 23);
		contentPane.add(btnStart);
		
		JLabel lblSimulationTime = new JLabel("Simulation Time");
		lblSimulationTime.setBounds(25, 203, 116, 22);
		contentPane.add(lblSimulationTime);
		
		textField_4 = new JTextField("15");
		textField_4.setBounds(200, 204, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNumarCozi = new JLabel("Numar Cozi");
		lblNumarCozi.setBounds(25, 234, 77, 22);
		contentPane.add(lblNumarCozi);
		
		textField_5 = new JTextField("5");
		textField_5.setBounds(200, 235, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cozi cozi=new Cozi();
				int minArr=Integer.parseInt(textField.getText());
				int maxArr=Integer.parseInt(textField_1.getText());
				int minPro=Integer.parseInt(textField_2.getText());
				int maxPro=Integer.parseInt(textField_3.getText());
				int sim=Integer.parseInt(textField_4.getText());
				int nrCozi=Integer.parseInt(textField_5.getText());
				
				Processing p=new Processing(minArr,maxArr,minPro,maxPro,sim,nrCozi,cozi);
				//p.initializare();
				Thread t=new Thread(p);
				t.start();
				//cozi.setVisible(true);
			}
				
		});
	}
}
