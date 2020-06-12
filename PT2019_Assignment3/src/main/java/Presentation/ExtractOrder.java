package Presentation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Data.Conection;
import Model.Order;

public class ExtractOrder {

	static Connection con= null;
	static Conection cn=new Conection();
	
	static ArrayList<Order> getOrderData()
	{
		ArrayList<Order> o=new ArrayList<Order>();
		String s="select * from Orders";
		con=cn.createConection();
		ResultSet rs=null;
		Statement statement=null;
	    try {
	        //con.createConnection();
	        statement= (Statement) con.createStatement();
	       
	        rs = statement.executeQuery(s);
	        Order order;
	        while (rs.next()) {
	        	
	        	int ido,idc,idp,cant;
	        	
	        	
	            idp=rs.getInt("idProduct");
	            ido=rs.getInt("idOrder");
	            idc=rs.getInt("idClient");
	            cant=rs.getInt("cantitate");
	            
	            order=new Order(ido,idc,idp,cant);
	            

	            o.add(order);
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
	    return o;
		
	}
}
