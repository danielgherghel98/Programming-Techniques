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
import Data.RestaurantSerializator;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class WaiterInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;
	private JTextField textField_3;
	Restaurant r;
	ChefInterface chef;
	private JButton btnAddItem;
	ArrayList<MenuItem> list;
	RestaurantSerializator rs=new RestaurantSerializator();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public WaiterInterface(Restaurant rt,ChefInterface chef1) {
		this.r=rt;
		this.chef=chef1;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getColumns();
		
		JLabel lblWaiter = new JLabel("Waiter");
		lblWaiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWaiter.setBounds(182, 11, 67, 25);
		contentPane.add(lblWaiter);
		
		textField = new JTextField();
		textField.setBounds(68, 46, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 68, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(68, 91, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOrderid = new JLabel("OrderId");
		lblOrderid.setBounds(10, 49, 46, 14);
		contentPane.add(lblOrderid);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 71, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblTable = new JLabel("Table");
		lblTable.setBounds(10, 94, 46, 14);
		contentPane.add(lblTable);
		
		list=new ArrayList<MenuItem>();
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(308, 90, 89, 23);
		contentPane.add(btnAddItem);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String m=textField_4.getText().toString();
				for(MenuItem c: r.getMItems())
					if(c.getName().equals(m))
					{
						list.add(c);
						//System.out.println(c.getName()+ " "+c.getGramaj());
					}
				
				
				
			}
		});
		
		textField_4 = new JTextField();
		textField_4.setBounds(311, 65, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	    
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(182, 45, 89, 23);
		contentPane.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Order o=new Order();
				setOrder(o);
				for(MenuItem c: list)
					System.out.println(c.getName()+ " "+c.getGramaj());
				if(list.size()>=2) {
				r.addOrder(o, list);
				
				r.addChef(chef);
				r.notifyChef(list);
				System.out.println(r.getOrders().toString());
				list=new ArrayList<MenuItem>();
				//r.setOrders(null);
				rs.serOrders(r.getOrders());
				getColumns1();
				}
				else {
					System.out.println("Trebuie introduse mai multe produse la comanda!");
				}
				
			}
			
		});
		
		
		JButton btnNewButton = new JButton("Price");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Order o=new Order();
				setOrder(o);
				double pret;
				pret=r.getPrice(o);
				textField_3.setText(pret+"");
				
			}
		});
		btnNewButton.setBounds(182, 67, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBill = new JButton("Bill");
		btnBill.setBounds(182, 90, 89, 23);
		contentPane.add(btnBill);
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Order o=new Order();
				setOrder(o);
				Bill b=new Bill(o,r);
				b.setVisible(true);
				double pret;
				pret=r.getPrice(o);
				String s;
				s="Item Id   Name    Gramaj    Pret\n";
				
				c=r.getOrders().get(o);
			    for (int i = 0; i < c.size(); i++) {
			    	
			    s+="   "+c.get(i).getItemId()+"    "+c.get(i).getName()+"         "+c.get(i).getGramaj()+"        "+c.get(i).getPret()+"\n";	
			    
			    
			    }
			    s+="TOTAL: "+pret;
			    generateBill(s);
				
				
			}
		});
		
		
//		
//		table = new JTable();
//		table.setBounds(10, 119, 414, 95);
//		contentPane.add(table);
		
//		table_1 = new JTable();
//		table_1.setBounds(10, 225, 414, 95);
//		contentPane.add(table_1);
		
		JLabel lblPrice = new JLabel("Price(RON)");
		lblPrice.setBounds(238, 331, 67, 14);
		contentPane.add(lblPrice);
		
		textField_3 = new JTextField();
		textField_3.setBounds(321, 328, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		getColumns();
	}
	 ArrayList<MenuItem> c=new ArrayList<MenuItem>();
	 HashMap<Order,ArrayList<MenuItem>> o= new HashMap<Order,ArrayList<MenuItem>>();
	 private JTextField textField_4;
	 
	 
	
	private void setOrder(Order o)
	{
		o.setOrderId(Integer.parseInt(textField.getText().toString()));
		o.setTable(Integer.parseInt(textField_2.getText().toString()));
		o.setData(textField_1.getText().toString());
		
	}
	private void getTableData1(DefaultTableModel dtm) {
	    Object[] dataForTable = new Object[3];
		//Order or=new Order();
		//setOrder(or);
		//Extract e=new Extract();
	    Set<Order> keys = r.getOrders().keySet();
        for(Order key: keys){
	        	
	            dataForTable[0] = key.getOrderId();
	            dataForTable[1] = key.getData();
	            dataForTable[2] = key.getTable();
	            dtm.addRow(dataForTable);
	            
	    }
	    
	    
	}
	public void getColumns1() {
		
		table_1=new JTable();
	    String[] columns = {"Order Id","Date","Table"};
	    
	    DefaultTableModel defm=new DefaultTableModel(columns,0);
	    getTableData1(defm);
	    //return columns;
	    
		
		contentPane.add(table_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 225, 414, 95);
		this.getContentPane().add(scrollPane);
		table_1 = new JTable(defm);
		scrollPane.setViewportView(table_1);
	    
	}
	
	public  void getTableData(DefaultTableModel dtm) {
	    Object[] dataForTable = new Object[4];
		
		//Extract e=new Extract();
	    //c=r.getMItems();
	    for (int i = 0; i < r.getMItems().size(); i++) {
	       
	        	
	            dataForTable[0] = r.getMItems().get(i).getItemId();
	            dataForTable[1] = r.getMItems().get(i).getName();
	            dataForTable[2] = r.getMItems().get(i).getGramaj();
	            dataForTable[3] = r.getMItems().get(i).getPret();
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
		scrollPane.setBounds(10, 119, 414, 95);
		this.getContentPane().add(scrollPane);
		table = new JTable(defm);
		scrollPane.setViewportView(table);
		
		
	}
	
	public void generateBill(String data)
	{
		 BufferedWriter writer = null;
	        try {
	            //create a temporary file
	            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	            File logFile = new File(timeLog);

	            // This will output the full path where the file will be written to...
	            System.out.println(logFile.getCanonicalPath());

	            writer = new BufferedWriter(new FileWriter(logFile));
	            writer.write(data);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
	}
	

}
