package Data;

import Model.Order;

public class RepOrder {

	
	public String insert(Order o)
	{
		String s="Insert into Orders(idOrder,idClient,idProduct,cantitate) values ('" + o.getIdOrder() + "','" + o.getIdClient() + "','" + o.getIdProduct() + "','" + o.getCantitate() + "')"; 
		return s;
	}
	
	public String update(Order o)
	{
		String s="Update Orders set idClient='" + o.getIdClient() + "',idProduct='" + o.getIdProduct() + "',cantitate='" + o.getCantitate() +  "'where idClient='"+o.getIdClient()+"'"; 
		return s;
	}
	
	public String delete(Order o)
	{
		String s="Delete from Orders where idClient='"+o.getIdClient()+"'";
		return s;
	}
	
}
