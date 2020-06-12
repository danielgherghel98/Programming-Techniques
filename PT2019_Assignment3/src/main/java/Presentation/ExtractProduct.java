package Presentation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Data.Conection;
import Model.Product;

public class ExtractProduct {

	static Connection con= null;
	static Conection cn=new Conection();
	
	static ArrayList<Product> getProductData()
	{
		ArrayList<Product> p=new ArrayList<Product>();
		String s="select * from Product";
		con=cn.createConection();
		ResultSet rs=null;
		Statement statement=null;
	    try {
	        //con.createConnection();
	        statement= (Statement) con.createStatement();
	       
	        rs = statement.executeQuery(s);
	        Product product;
	        while (rs.next()) {
	        	String nume;
	        	int id,stoc;
	        	double pret;
	        	
	            id=rs.getInt("idProduct");
	            nume=rs.getString("nameProduct");
	            pret=rs.getDouble("pret");
	            stoc=rs.getInt("stoc");
	            
	            product=new Product(id,nume,pret,stoc);
	            

	            p.add(product);
	        }

	        
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    finally
	    {
	    	try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return p;
		
	}
}
