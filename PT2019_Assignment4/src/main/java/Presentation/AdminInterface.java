package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Business.MenuItem;
import Business.Restaurant;
import Data.RestaurantSerializator;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class AdminInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static JTable table;
	Restaurant r;
	RestaurantSerializator rs=new RestaurantSerializator();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminInterface(Restaurant rt) {
		this.r=rt;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAdministrator.setBounds(147, 11, 121, 14);
		panel.add(lblAdministrator);
		
		JLabel lblItemid = new JLabel("ItemId");
		lblItemid.setBounds(23, 42, 46, 14);
		panel.add(lblItemid);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(23, 67, 46, 14);
		panel.add(lblName);
		
		JLabel lblGramaj = new JLabel("Gramaj");
		lblGramaj.setBounds(23, 92, 46, 14);
		panel.add(lblGramaj);
		
		JLabel lblPret = new JLabel("Pret");
		lblPret.setBounds(23, 117, 46, 14);
		panel.add(lblPret);
		
		textField = new JTextField();
		textField.setBounds(68, 36, 106, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 64, 106, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(68, 92, 106, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(68, 117, 106, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(276, 38, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuItem m=new MenuItem();
				setItem(m);
				add(m);
				rs.serItems(r.getMItems());
				getColumns();
			}
				
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(276, 63, 89, 23);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuItem m=new MenuItem();
				setItem(m);
				update(m);
				rs.serItems(r.getMItems());
				getColumns();
			}
				
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(276, 88, 89, 23);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuItem m=new MenuItem();
				setItem(m);
				delete(m);
				rs.serItems(r.getMItems());
				getColumns();
			}
				
		});
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.setBounds(276, 113, 89, 23);
		panel.add(btnShowAll);
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rs.deserItems()!=null)
				{
					r.setMItems(rs.deserItems());
				}
				getColumns();
			}
				
		});
		
		
		//set();
		
	}
	
	//static Restaurant r1=new Restaurant();
	static ArrayList<MenuItem> c=new ArrayList<MenuItem>();
	private void setItem(MenuItem m)
	{
		m.setItemId(Integer.parseInt(textField.getText().toString()));
		m.setGramaj(Integer.parseInt(textField_2.getText().toString()));
		m.setName(textField_1.getText().toString());
		m.setPret(Double.parseDouble(textField_3.getText().toString()));
	}
	private void add(MenuItem m) {
		r.addMItem(m);
	}
	private void update(MenuItem m)
	{
		r.updateMItem(m);
	}
	private void delete(MenuItem m)
	{
		//System.out.println("da");
		r.deleteMItem(m);
	}
	private  void getTableData(DefaultTableModel dtm) {
	    Object[] dataForTable = new Object[4];
		
		//Extract e=new Extract();
		c=r.getMItems();
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
		scrollPane.setBounds(23, 148, 371, 125);
		this.getContentPane().add(scrollPane);
		table = new JTable(defm);
		scrollPane.setViewportView(table);
	    
	}
}
