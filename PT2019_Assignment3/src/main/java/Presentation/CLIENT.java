package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Business.ClientCheck;
import Data.Conection;
import Data.ConnectionFactory;
import Data.RepClient;
import Model.Client;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

public class CLIENT extends JFrame {

	private static JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JTable table;
	static CLIENT frame = new CLIENT();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public CLIENT() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nume ");
		lblNewLabel.setBounds(38, 55, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(38, 86, 46, 14);
		contentPane.add(lblAdresa);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 52, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 83, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblClient = new JLabel("CLIENT");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClient.setBounds(187, 0, 75, 30);
		contentPane.add(lblClient);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				Conection cn=new Conection();
				
				
					Client c=new Client(0,textField_1.getText(),textField_2.getText());
					ClientCheck cl=new ClientCheck();
					cl.insert(c);
					RepClient cr=new RepClient();
					String s=cr.insert(c);
					System.out.println(s);
					con=cn.createConection();
					ResultSet rs=null;
					PreparedStatement statement=null;
				    try {
				        //con.createConnection();
				        statement= (PreparedStatement) con.prepareStatement(s);
				        statement.execute();
				        //rs = statement.executeQuery(s);
				        
				        
				    } catch (Exception x) {
				        System.out.println("sdfgh"+x);
				    }
				    finally
				    {
				    	try {
							con.close();
						} catch (SQLException x) {
							// TODO Auto-generated catch block
							//x.printStackTrace();
							System.out.println("bababa");
						}
				    }
					
			}
		});
		btnAdd.setBounds(294, 41, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(294, 68, 89, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				Conection cn=new Conection();
				
				
					Client c=new Client(1,textField_1.getText(),textField_2.getText());
					ClientCheck cl=new ClientCheck();
					cl.insert(c);
					RepClient cr=new RepClient();
					String s=cr.update(c);
					System.out.println(s);
					con=cn.createConection();
					ResultSet rs=null;
					PreparedStatement statement=null;
				    try {
				        //con.createConnection();
				        statement= (PreparedStatement) con.prepareStatement(s);
				        statement.execute();
				        //rs = statement.executeQuery(s);
				        
				        
				    } catch (Exception x) {
				        System.out.println("sdfgh"+x);
				    }
				    finally
				    {
				    	try {
							con.close();
						} catch (SQLException x) {
							// TODO Auto-generated catch block
							//x.printStackTrace();
							System.out.println("bababa");
						}
				    }
					
			}
		});
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(294, 97, 89, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				Conection cn=new Conection();
				
				
					Client c=new Client(1,textField_1.getText(),textField_2.getText());
					ClientCheck cl=new ClientCheck();
					cl.insert(c);
					RepClient cr=new RepClient();
					String s=cr.delete(c);
					System.out.println(s);
					con=cn.createConection();
					ResultSet rs=null;
					PreparedStatement statement=null;
				    try {
				        //con.createConnection();
				        statement= (PreparedStatement) con.prepareStatement(s);
				        statement.execute();
				        //rs = statement.executeQuery(s);
				        
				        
				    } catch (Exception x) {
				        System.out.println("sdfgh"+x);
				    }
				    finally
				    {
				    	try {
							con.close();
						} catch (SQLException x) {
							// TODO Auto-generated catch block
							//x.printStackTrace();
							System.out.println("bababa");
						}
				    }
					
			}
		});
		
		
		
		getColumns();
		
		
		
		
	}
	
	
	private static void getTableData(DefaultTableModel dtm) {
	    Object[] dataForTable = new Object[3];
		
		Extract e=new Extract();
		ArrayList<Client> c=e.getClientData();
	    for (int i = 0; i < c.size(); i++) {
	       
	        	
	            dataForTable[0] = c.get(i).getIdClient();
	            dataForTable[1] = c.get(i).getNameClient();
	            dataForTable[2] = c.get(i).getAdresa();
	            dtm.addRow(dataForTable);
	            
	    }
	    
	    
	}
	
	public void getColumns() {
		
		table=new JTable();
	    String[] columns = {"idClient","nameClient","Adresa"};
	    
	    DefaultTableModel defm=new DefaultTableModel(columns,0);
	    getTableData(defm);
	    //return columns;
	    
		
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 162, 345, 89);
		this.getContentPane().add(scrollPane);
		table = new JTable(defm);
		scrollPane.setViewportView(table);
	    
	}
}
