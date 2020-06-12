package PT2019.demo.Assignment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class Cozi extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_4;

	

	/**
	 * Create the frame.
	 */
	public Cozi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCozi = new JLabel("Cozi");
		lblCozi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCozi.setBounds(232, 11, 46, 19);
		contentPane.add(lblCozi);
		
		JLabel lblCoada = new JLabel("Coada 1");
		lblCoada.setBounds(43, 35, 46, 14);
		contentPane.add(lblCoada);
		
		JLabel lblCoada_1 = new JLabel("Coada 2");
		lblCoada_1.setBounds(136, 35, 46, 14);
		contentPane.add(lblCoada_1);
		
		JLabel lblCoada_2 = new JLabel("Coada 3");
		lblCoada_2.setBounds(232, 35, 46, 14);
		contentPane.add(lblCoada_2);
		
		JLabel lblCoada_3 = new JLabel("Coada 4");
		lblCoada_3.setBounds(333, 35, 46, 14);
		contentPane.add(lblCoada_3);
		
		JLabel lblCoada_4 = new JLabel("Coada 5");
		lblCoada_4.setBounds(440, 35, 58, 14);
		contentPane.add(lblCoada_4);
		
		textArea = new JTextArea();
		textArea.setBounds(24, 60, 82, 244);
		contentPane.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(116, 60, 82, 244);
		contentPane.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setBounds(219, 60, 82, 244);
		contentPane.add(textArea_2);
		
		textArea_3 = new JTextArea();
		textArea_3.setBounds(317, 60, 82, 244);
		contentPane.add(textArea_3);
		
		
		textArea_4 = new JTextArea();
		textArea_4.setBounds(414, 60, 84, 244);
		contentPane.add(textArea_4);
		this.setVisible(true);
		
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JTextArea getTextArea_1() {
		return textArea_1;
	}

	public void setTextArea_1(JTextArea textArea_1) {
		this.textArea_1 = textArea_1;
	}

	public JTextArea getTextArea_2() {
		return textArea_2;
	}

	public void setTextArea_2(JTextArea textArea_2) {
		this.textArea_2 = textArea_2;
	}

	public JTextArea getTextArea_3() {
		return textArea_3;
	}

	public void setTextArea_3(JTextArea textArea_3) {
		this.textArea_3 = textArea_3;
	}

	public JTextArea getTextArea_4() {
		return textArea_4;
	}

	public void setTextArea_4(JTextArea textArea_4) {
		this.textArea_4 = textArea_4;
	}

}
