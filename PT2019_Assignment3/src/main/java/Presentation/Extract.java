package Presentation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Data.Conection;
import Model.Client;

public class Extract {

	static Connection con= null;
	static Conection cn=new Conection();
	
	static ArrayList<Client> getClientData()
	{
		ArrayList<Client> c=new ArrayList<Client>();
		String s="select * from Clients";
		con=cn.createConection();
		ResultSet rs=null;
		Statement statement=null;
	    try {
	        //con.createConnection();
	        statement= (Statement) con.createStatement();
	       
	        rs = statement.executeQuery(s);
	        Client client;
	        while (rs.next()) {
	        	String nume,adresa;
	        	int id;
	        	
	            id=rs.getInt("idClient");
	            nume=rs.getString("nameClient");
	            adresa=rs.getString("adresa");
	            client=new Client(id,nume,adresa);
	            System.out.println(client);

	            c.add(client);
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
	    return c;
		
	}
}
