package Business;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
* @invariant isWellFormed()
*/
public class Restaurant implements Serializable,Observable {
		
	ArrayList<MenuItem> mItems=new ArrayList<MenuItem>();
	ArrayList<Observer1> obs=new ArrayList<Observer1>();
	HashMap<Order,ArrayList<MenuItem>> orders= new HashMap<Order,ArrayList<MenuItem>>();
	
	MenuItem a=new MenuItem();
	MenuItem b=new MenuItem();
	MenuItem c=new MenuItem();
	public void initializare()
	{
		this.orders.clear();
		
	}
	public Restaurant() {
		
	}
	
	public HashMap<Order, ArrayList<MenuItem>> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Order, ArrayList<MenuItem>> orders) {
		this.orders = orders;
	}

	public Restaurant(ArrayList<MenuItem> mItems,HashMap<Order,ArrayList<MenuItem>> orders)
	{
		this.mItems=mItems;
		this.orders=orders;
	}
	
	public ArrayList<MenuItem> getMItems()
	{
		return this.mItems;
	}
	public void setMItems(ArrayList<MenuItem> mItems)
	{
		this.mItems=mItems;
	}
	public void addMItem(MenuItem m)
	{
		mItems.add(m);
	}
	
	public void updateMItem(MenuItem m)
	{
		for(MenuItem c: this.mItems)
			if(c.getName().equals(m.getName()))
			{
				
				c.setGramaj(m.getGramaj());
				c.setPret(m.getPret());
			}
	}
	public void deleteMItem(MenuItem n)
	{
			if(mItems.contains(n))
			{
				mItems.remove(n);
			}
	
	}
	
	protected boolean isWellFormed(){
		Set<Order> keys = this.orders.keySet();
        for(Order key: keys){
        	
        	if((orders.get(key)!=null)&&(orders.get(key).size()>1))
        	{
        		return true;
        	}
        	else 
        	{
        		return false;
        	}
        }
        return false;
        
	}
		
	public void addOrder(Order o,ArrayList<MenuItem> list)
	{
		isWellFormed();
		orders.put(o,list);
	}
	
	public double getPrice(Order o)
	{
		double pret;
		pret=0;
		for(MenuItem c: orders.get(o))
			{
				pret+=c.getPret();
			}
		return pret;
	}
	
	public void addChef(Observer1 ob) {
		this.obs.add(ob);
	}
    public void deleteChef(Observer1 ob)
    {
    	if(obs.contains(ob))
		{
    	this.obs.remove(ob);
		}
    }
    public void notifyChef(ArrayList<MenuItem> list)
    {
    	for(Observer1 o:obs)
    	{
    		o.update(list);
    	}
    	
    }
	
}
