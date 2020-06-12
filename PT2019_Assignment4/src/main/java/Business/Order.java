package Business;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable  {

	public int orderId;
	public String data;
	public int table;

	
	public Order() {
		
	}

	public Order(int orderId, String data, int table) {
		this.orderId = orderId;
		this.data = data;
		this.table = table;
	}

	public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) this.orderId;
        hash = 31 * hash + (this.data == null ? 0 : this.data.hashCode());
        hash = 31 * hash + (int) this.table;
        return hash;
    }
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	
	 @Override
     public boolean equals(Object obj) {

         if (obj == null) {
             return false;
         }
         if (getClass() != obj.getClass()) {
             return false;
         }
         final Order other = (Order) obj;
         if (this.orderId != other.orderId) {
             return false;
         }
         if ((this.data == null) ? (other.data != null) : !this.data.equals(other.data)) {
             return false;
         }
         if (this.table != other.table) {
             return false;
         }
         return true;
     }
	
}
