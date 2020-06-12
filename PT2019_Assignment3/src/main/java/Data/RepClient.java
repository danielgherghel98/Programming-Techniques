package Data;

import Model.Client;

public class RepClient {

	public String insert(Client o)
	{
		String s="Insert into Clients(idClient,nameClient,adresa) values ('" + o.getIdClient() + "','" + o.getNameClient() + "','" + o.getAdresa() + "')"; 
		return s;
	}
	
	public String update(Client o)
	{
		String s="Update Clients set nameClient='" + o.getNameClient() + "',adresa='" + o.getAdresa() +  "'where nameClient='"+o.getNameClient()+"'"; 
		return s;
	}
	
	public String delete(Client o)
	{
		String s="Delete from Clients where nameClient='"+o.getNameClient()+"'";
		return s;
	}
}
