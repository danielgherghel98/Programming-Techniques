package PT2019.demo.DemoProject;
import java.util.*;
import java.util.LinkedList;

public class Polinom {
	
	ArrayList<Monom> polinom;
	
	public ArrayList<Monom> getPolinom() {
		return polinom;
	}

	public void setPolinom(ArrayList<Monom> polinom) {
		this.polinom = polinom;
	}

	public Polinom() {
		polinom=new ArrayList<Monom>();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		String s="";
		for(Monom aux : polinom)
		{
			s= s + aux.toString();
		}
		return s;
	}
	
	
}
