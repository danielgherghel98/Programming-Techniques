package Business;

import Data.RepClient;
import Model.Client;


public class ClientCheck {

	RepClient rep=new RepClient();
	
	public void  insert(Client c)
	{
		rep.insert(c);
	}
	
	public void update(Client c)
	{
		if(c.getIdClient()!=0)
		{
			rep.update(c);
		}
	}
	
	public void delete(Client c)
	{
		if(c.getIdClient()!=0)
		{
			rep.delete(c);
		}
	}
}
