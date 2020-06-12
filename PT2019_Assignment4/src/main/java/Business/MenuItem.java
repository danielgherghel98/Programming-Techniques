package Business;

import java.io.Serializable;

public class MenuItem implements Serializable {

	private int itemId;
	private String name;
	private int gramaj;
	private double pret;
	
	
	
	public MenuItem() {
		
	}
	public MenuItem(int itemId, String name, int gramaj, double pret) {
		//super();
		this.itemId = itemId;
		this.name = name;
		this.gramaj = gramaj;
		this.pret = pret;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGramaj() {
		return gramaj;
	}
	public void setGramaj(int gramaj) {
		this.gramaj = gramaj;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	@Override
    public boolean equals(Object o) { 
  
         
        if (o == this) { 
            return true; 
        }
        if (!(o instanceof MenuItem)) { 
            return false; 
        } 
          
          
        MenuItem c = (MenuItem) o; 
          
        return this.itemId==c.getItemId() && this.gramaj==c.gramaj && this.name.equals(c.name) && this.pret==c.pret;
        
    } 
	
	
}
