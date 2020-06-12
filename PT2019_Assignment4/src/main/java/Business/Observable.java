package Business;

import java.util.ArrayList;

public interface Observable {
	public void addChef(Observer1 ob); 
    public void deleteChef(Observer1 ob); 
    public void notifyChef(ArrayList<MenuItem> list);
}
