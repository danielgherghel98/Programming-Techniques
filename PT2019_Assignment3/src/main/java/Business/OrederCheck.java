package Business;

import Data.RepOrder;
import Model.Order;
import Model.Product;


public class OrederCheck {

	RepOrder rep=new RepOrder();
	
	public void  insert(Order o,Product p)
	{
		if(o.getIdClient()!=0 && o.getIdProduct()!=0 && o.getCantitate()<=p.getStoc())
		{
			rep.insert(o);
		}
	}
	
	public void update(Order o,Product p)
	{
		if(o.getIdOrder()!=0 && o.getCantitate()<=p.getStoc())
		{
			rep.update(o);
		}
	}
	
	public void delete(Order o)
	{
		if(o.getIdOrder()!=0)
		{
			rep.delete(o);
		}
	}
}
