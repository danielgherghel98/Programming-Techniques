package Business;

import Data.RepProduct;
import Model.Product;

public class ProductCheck {

	RepProduct rep=new RepProduct();
	
	public void  insert(Product p)
	{
		rep.insert(p);
	}
	
	public void update(Product p)
	{
		if(p.getIdProduct()!=0)
		{
			rep.update(p);
		}
	}
	
	public void delete(Product p)
	{
		if(p.getNameProduct()!=null)
		{
			rep.delete(p);
		}
	}
	
}
