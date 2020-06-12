package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Restaurant;
import Data.RestaurantSerializator;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Control extends JFrame {

	private JPanel contentPane;
	static Restaurant rst=new Restaurant();
	RestaurantSerializator rs=new RestaurantSerializator();
	
	AdminInterface a;
	WaiterInterface w;
	ChefInterface chef=new ChefInterface();
	public Control() {
		//this.rs=r;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//rs.initializare();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblControl = new JLabel("Control");
		lblControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblControl.setBounds(175, 71, 88, 25);
		panel.add(lblControl);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.setBounds(54, 146, 113, 23);
		panel.add(btnAdministrator);
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=new AdminInterface(rst);
				a.setVisible(true);
			}
				
		});
		
		JButton btnWaiter = new JButton("Waiter");
		btnWaiter.setBounds(241, 146, 113, 23);
		panel.add(btnWaiter);
		
		
		btnWaiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w=new WaiterInterface(rst,chef);
				//w.getColumns();
//				rst.initializare();
//				rs.serOrders(rst.getOrders());
				if(rs.deserOrders()!=null)
				{
					rst.setOrders(rs.deserOrders());
				}
				w.getColumns1();
				w.setVisible(true);
			}
			
				
		});
		JButton btnChef = new JButton("Chef");
		btnChef.setBounds(161, 192, 89, 23);
		panel.add(btnChef);
		btnChef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chef.setVisible(true);
				
			}
				
		});
	}
}
