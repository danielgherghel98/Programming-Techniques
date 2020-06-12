package Data;

import Model.Product;

public class RepProduct {

	public String insert(Product o)
	{
		String s="Insert into Product(idProduct,nameProduct,pret,stoc) values ('" + o.getIdProduct() + "','" + o.getNameProduct() + "','" + o.getPret() + "','" + o.getStoc() + "')"; 
		return s;
	}
	
	public String update(Product o)
	{
		String s="Update Product set nameProduct='" + o.getNameProduct() + "',pret='" + o.getPret() + "',stoc='" + o.getStoc() +  "'where nameProduct='"+o.getNameProduct()+"'"; 
		return s;
	}
	
	public String delete(Product o)
	{
		String s="Delete from Product where nameProduct='"+o.getNameProduct()+"'";
		return s;
	}
}
