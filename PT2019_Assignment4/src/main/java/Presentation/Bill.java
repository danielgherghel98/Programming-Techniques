package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Business.MenuItem;
import Business.Order;
import Business.Restaurant;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	Order o;
	Restaurant r;
	ArrayList<MenuItem> c=new ArrayList<MenuItem>();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Bill(Order o,Restaurant r) {
		this.o=o;
		this.r=r;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBill = new JLabel("Bill");
		lblBill.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBill.setBounds(186, 11, 53, 25);
		contentPane.add(lblBill);
		
//		table = new JTable();
//		table.setBounds(10, 57, 414, 120);
//		contentPane.add(table);
		
		JLabel lblTotalron = new JLabel("Total(RON)");
		lblTotalron.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalron.setBounds(217, 219, 75, 14);
		contentPane.add(lblTotalron);
		
		double pret=r.getPrice(o);
		
		textField = new JTextField();
		textField.setBounds(310, 218, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(pret+"");
		getColumns();
	}
	
	private  void getTableData(DefaultTableModel dtm) {
	    Object[] dataForTable = new Object[4];
		
		//Extract e=new Extract();
		c=r.getOrders().get(o);
	    for (int i = 0; i < c.size(); i++) {
	       
	        	
	            dataForTable[0] = c.get(i).getItemId();
	            dataForTable[1] = c.get(i).getName();
	            dataForTable[2] = c.get(i).getGramaj();
	            dataForTable[3] = c.get(i).getPret();
	            dtm.addRow(dataForTable);
	            
	    }
	    
	    
	}
	public void getColumns() {
		
		table=new JTable();
	    String[] columns = {"Item Id","Name","Gramaj","Pret"};
	    
	    DefaultTableModel defm=new DefaultTableModel(columns,0);
	    getTableData(defm);
	    //return columns;
	    
		
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 414, 120);
		this.getContentPane().add(scrollPane);
		table = new JTable(defm);
		scrollPane.setViewportView(table);
	    
	}

}
