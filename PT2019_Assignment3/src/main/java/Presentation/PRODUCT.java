package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Business.OrederCheck;
import Business.ProductCheck;
import Data.Conection;
import Data.RepOrder;
import Data.RepProduct;
import Model.Client;
import Model.Order;
import Model.Product;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PRODUCT extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PRODUCT frame = new PRODUCT();
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
	public PRODUCT() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nume ");
		lblNewLabel.setBounds(38, 64, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdresa = new JLabel("Stoc");
		lblAdresa.setBounds(38, 117, 46, 14);
		contentPane.add(lblAdresa);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 61, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 114, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblClient = new JLabel("PRODUCTS");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClient.setBounds(187, 0, 75, 30);
		contentPane.add(lblClient);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(294, 60, 89, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				Conection cn=new Conection();
				
				
					Product c=new Product(0,textField_1.getText(),Double.parseDouble(textField_3.getText()),Integer.parseInt(textField_2.getText()));
					ProductCheck cl=new ProductCheck();
					//Product p=new Product(1,"paste",3.75,60);
					cl.insert(c);
					RepProduct cr=new RepProduct();
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
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(294, 85, 89, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				Conection cn=new Conection();
				
				
					Product c=new Product(1,textField_1.getText(),Double.parseDouble(textField_2.getText()),Integer.parseInt(textField_3.getText()));
					ProductCheck cl=new ProductCheck();
					//Product p=new Product(1,"paste",3.75,60);
					cl.insert(c);
					RepProduct cr=new RepProduct();
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
		btnDelete.setBounds(294, 110, 89, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				Conection cn=new Conection();
				
				
					Product c=new Product(1,textField_1.getText(),Double.parseDouble(textField_2.getText()),Integer.parseInt(textField_3.getText()));
					ProductCheck cl=new ProductCheck();
					cl.insert(c);
					RepProduct cr=new RepProduct();
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
		
		
		
		JLabel lblPret = new JLabel("Pret");
		lblPret.setBounds(38, 92, 46, 14);
		contentPane.add(lblPret);
		
		textField_3 = new JTextField();
		textField_3.setBounds(127, 86, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		getColumns();
	}
	
	private static void getTableData(DefaultTableModel dtm) {
	    Object[] dataForTable = new Object[4];
		
		ExtractProduct e=new ExtractProduct();
		ArrayList<Product> p=e.getProductData();
	    for (int i = 0; i < p.size(); i++) {
	       
	        	
	            dataForTable[0] = p.get(i).getIdProduct();
	            dataForTable[1] = p.get(i).getNameProduct();
	            dataForTable[2] = p.get(i).getPret();
	            dataForTable[3] = p.get(i).getStoc();
	            dtm.addRow(dataForTable);
	            
	    }
	    
	    
	}
	
	public void getColumns() {
		
		table=new JTable();
	    String[] columns = {"idProduct","nameProduct","pret","stoc"};
	    
	    DefaultTableModel defm=new DefaultTableModel(columns,0);
	    getTableData(defm);
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 162, 345, 89);
		this.getContentPane().add(scrollPane);
		table = new JTable(defm);
		scrollPane.setViewportView(table);
	    
	}
}

