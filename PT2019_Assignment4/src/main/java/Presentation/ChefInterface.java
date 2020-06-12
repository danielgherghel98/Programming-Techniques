package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Business.MenuItem;
import Business.Observer1;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;

public class ChefInterface extends JFrame implements Observer1 {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefInterface frame = new ChefInterface();
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
	public ChefInterface() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChef = new JLabel("Chef");
		lblChef.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChef.setBounds(180, 11, 56, 25);
		contentPane.add(lblChef);
		
		JLabel lblComenzi = new JLabel("Comenzi");
		lblComenzi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComenzi.setBounds(10, 46, 63, 25);
		contentPane.add(lblComenzi);
		
//		table = new JTable();
//		table.setBounds(10, 70, 414, 160);
//		contentPane.add(table);
	}
	public  void getTableData(DefaultTableModel dtm,ArrayList<MenuItem> list) {
	    Object[] dataForTable = new Object[4];
		
		//Extract e=new Extract();
	    //c=r.getMItems();
	    for (int i = 0; i < list.size(); i++) {
	       
	        	
	            dataForTable[0] = list.get(i).getItemId();
	            dataForTable[1] = list.get(i).getName();
	            dataForTable[2] = list.get(i).getGramaj();
	            dataForTable[3] = list.get(i).getPret();
	            dtm.addRow(dataForTable);
	            
	    }
	    
	    
	}
	public void update(ArrayList<MenuItem> list) {
		
		table=new JTable();
	    String[] columns = {"Item Id","Name","Gramaj","Pret"};
	    
	    DefaultTableModel defm=new DefaultTableModel(columns,0);
	    getTableData(defm,list);
	    //return columns;
	    
		
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 414, 160);
		this.getContentPane().add(scrollPane);
		table = new JTable(defm);
		scrollPane.setViewportView(table);
		
		
	}
}
