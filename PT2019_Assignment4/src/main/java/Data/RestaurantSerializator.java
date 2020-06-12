package Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Business.MenuItem;
import Business.Order;

public class RestaurantSerializator {
	ArrayList<MenuItem> mItems=new ArrayList<MenuItem>();
	HashMap<Order,ArrayList<MenuItem>> orders= new HashMap<Order,ArrayList<MenuItem>>();
	
		
		public RestaurantSerializator() {
		
//		this.mItems = mItems;
//		this.orders = orders;
	}
		
		public void serItems( ArrayList<MenuItem> mItems){
		      this.mItems=mItems;	      
		      try {
		         FileOutputStream fileOut =
		         new FileOutputStream("item.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(mItems);
		         out.close();
		         fileOut.close();
		         System.out.printf("Serialized data is saved in item.ser");
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
		   }
		   public void serOrders(HashMap<Order, ArrayList<MenuItem>> orders){
			      this.orders=orders;	      
			      try {
			         FileOutputStream fileOut =
			         new FileOutputStream("order.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(orders);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in order.ser");
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
			   }
		   public ArrayList<MenuItem>  deserItems() {
			   ArrayList<MenuItem> mItems=null;
			      try {
			         FileInputStream fileIn = new FileInputStream("item.ser");
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         mItems = (ArrayList<MenuItem> ) in.readObject();
			         in.close();
			         fileIn.close();
			      } catch (IOException i) {
			         i.printStackTrace();
			         return null;
			      } catch (ClassNotFoundException c) {
			         System.out.println("Employee class not found");
			         c.printStackTrace();
			         return null;
			      }
			      return mItems;
		   }
		   
		   public HashMap<Order,ArrayList<MenuItem>>  deserOrders() {
			   HashMap<Order,ArrayList<MenuItem>> orders=null;
			      try {
			         FileInputStream fileIn = new FileInputStream("order.ser");
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         orders = (HashMap<Order,ArrayList<MenuItem>>  ) in.readObject();
			         in.close();
			         fileIn.close();
			      } catch (IOException i) {
			         i.printStackTrace();
			         return null;
			      } catch (ClassNotFoundException c) {
			         System.out.println("Employee class not found");
			         c.printStackTrace();
			         return null;
			      }
			      return orders;
		   }

}
