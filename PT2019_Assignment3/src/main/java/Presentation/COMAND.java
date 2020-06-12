package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class COMAND extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					COMAND frame = new COMAND();
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
	public COMAND() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CLIENTS");
		btnNewButton.setBounds(23, 146, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CLIENT c=new CLIENT();
				c.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("PRODUCTS");
		btnNewButton_1.setBounds(161, 146, 103, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PRODUCT P=new PRODUCT();
				P.setVisible(true);
			}
		});
		
		JButton btnOrders = new JButton("ORDERS");
		btnOrders.setBounds(307, 146, 89, 23);
		contentPane.add(btnOrders);
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ORDER o=new ORDER();
				o.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("SELECT AN OPTION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(130, 58, 180, 31);
		contentPane.add(lblNewLabel);
	}

}
