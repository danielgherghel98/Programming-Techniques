package PT2019.demo.DemoProject;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class View extends JFrame {
	
	JFrame frame = new JFrame("Calculator Polinoame");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	private JLabel aPolinom1 = new JLabel("Polinom 1: ");
	private JLabel aPolinom2 = new JLabel("Polinom 2: ");
	private JTextField Polinom1 = new JTextField(25);
	private JTextField Polinom2 = new JTextField(25);
	private JLabel rezult = new JLabel("Rezultatul: ");
	private JTextField rezultat = new JTextField(25);

	private JButton adunare = new JButton("Adunare");
	private JButton scadere = new JButton("Scadere");
	private JButton inmultire = new JButton("Inmultire");
	private JButton impartire = new JButton("Impartire");
	private JButton derivare1 = new JButton("Derivare Polinom1");
	private JButton derivare2 = new JButton("Derivare Polinom2");
	private JButton integrare1 = new JButton("Integrare Polinom1");
	private JButton integrare2 = new JButton("Integrare Polinom2");

	
	
	public View()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 120);
		panel1.add(aPolinom1);
		panel1.add(Polinom1);
		panel1.add(aPolinom2);
		panel1.add(Polinom2);
		panel1.add(rezult);
		panel1.add(rezultat);
		panel2.add(adunare);
		panel2.add(scadere);
		panel2.add(inmultire);
		panel2.add(impartire);
		panel3.add(derivare1);
		panel3.add(derivare2);
		panel3.add(integrare1);
		panel3.add(integrare2);
		
		panel4.add(panel2);
		panel4.add(panel3);
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
		
        
		 adunare.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String s1=Polinom1.getText();
	            	String s2=Polinom2.getText();
	                Polinom p1=new Polinom();
	                Operatii o=new Operatii();
	                Polinom p2=new Polinom();
	                Ideone i1=new Ideone(s1,p1);
	                Ideone i2=new Ideone(s2,p2);
	                rezultat.setText(o.addPolinom(p1,p2).toString());
	            }
	        });
	        
	        scadere.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String s1=Polinom1.getText();
	            	String s2=Polinom2.getText();
	                Polinom p1=new Polinom();
	                Polinom p2=new Polinom();
	                Operatii o=new Operatii();
	                Ideone i1=new Ideone(s1,p1);
	                Ideone i2=new Ideone(s2,p2);
	                rezultat.setText(o.subPolinom(p1,p2).toString());
	            }
	        });
	        
	        inmultire.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String s1=Polinom1.getText();
	            	String s2=Polinom2.getText();
	                Polinom p1=new Polinom();
	                Polinom p2=new Polinom();
	                Operatii o=new Operatii();
	                Ideone i1=new Ideone(s1,p1);
	                Ideone i2=new Ideone(s2,p2);
	                rezultat.setText(o.multPolinom(p1,p2).toString());
	            }
	        });
	        
	        derivare1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String s1=Polinom1.getText();
	                Polinom p1=new Polinom();
	                Operatii o=new Operatii();
	                Ideone i1=new Ideone(s1,p1);
	                rezultat.setText(o.derivarePolinom(p1).toString());
	            }
	        });
	        
	        derivare2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String s2=Polinom2.getText();
	                Polinom p2=new Polinom();
	                Operatii o=new Operatii();
	                Ideone i2=new Ideone(s2,p2);
	                rezultat.setText(o.derivarePolinom(p2).toString());
	            }
	        });
	        
	        integrare1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String s1=Polinom1.getText();
	                Polinom p1=new Polinom();
	                Operatii o=new Operatii();
	                Ideone i1=new Ideone(s1,p1);
	                rezultat.setText((o.integrarePolinom(p1)).toString());
	               // setRez(p1.toString());
	            }
	        });
	        
	        integrare2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String s2=Polinom2.getText();
	                Polinom p2=new Polinom();
	                Ideone i2=new Ideone(s2,p2);
	                Operatii o=new Operatii();
	                rezultat.setText((o.integrarePolinom(p2)).toString());
	               // setRez(p1.toString());
	            }
	        });
	        
	        impartire.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               String s1=Polinom1.getText();
	            	String s2=Polinom2.getText();
	                Polinom p1=new Polinom();
	                Polinom p2=new Polinom();
	                Operatii o=new Operatii();
	                Ideone i1=new Ideone(s1,p1);
	                Ideone i2=new Ideone(s2,p2);
	                String s3=o.impartirePolinom(p1,p2);
	                rezultat.setText(s3);
	            }
	        });
	        
	       
	       
	        
	
	           
		
		frame.getContentPane().setLayout(new GridLayout(0,1));
		frame.add(panel1);
		frame.add(panel4);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}
