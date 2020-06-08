package PT2019.demo.DemoProject;

import java.util.ArrayList;

public class Operatii {
	public Operatii() {
		
	}
	
	public Polinom addPolinom(Polinom p1,Polinom p2)
	{
		Polinom rez=new Polinom();
		for (Monom aux : p1.polinom) {
			rez.polinom.add(aux);
		}
		for (Monom aux : p2.polinom) {
			rez.polinom.add(aux);
		}
		
		for (Monom aux1 : p1.polinom)
		{
			for(Monom aux2 : p2.polinom)
				{
					if (aux1.getPutere() == aux2.getPutere())
					{
						rez.polinom.add(aux1.adunare(aux2));
						rez.polinom.remove(aux1);
						rez.polinom.remove(aux2);
					}
				}
		}
		rez.polinom.sort(new ComparatorMonoame());
		return rez;
	}
	
	public Polinom subPolinom(Polinom p1,Polinom p2)
	{
		Polinom rez=new Polinom();
		for (Monom aux : p1.polinom) {
			rez.polinom.add(aux);
		}
		for (Monom aux : p2.polinom) {
			float c=-aux.getCoeficient();
			aux.setCoeficient(c);
			rez.polinom.add(aux);
		}
		
		for (Monom aux1 : p1.polinom)
		{
			for(Monom aux2 : p2.polinom)
				{
					if (aux1.getPutere() == aux2.getPutere())
					{
						rez.polinom.add(aux1.adunare(aux2));
						rez.polinom.remove(aux1);
						rez.polinom.remove(aux2);
					}
				}
		}
		rez.polinom.sort(new ComparatorMonoame());
		return rez;
	}
	
	public Polinom multPolinom(Polinom p1,Polinom p2)
	{
		Polinom rez=new Polinom();
		Polinom rez1=new Polinom();
		for (Monom aux : p1.polinom) {
			rez.polinom.add(aux);
		}
		for (Monom aux : p2.polinom) {
			rez.polinom.add(aux);
		}
		
		for (Monom aux1 :p1.polinom)
		{
			for(Monom aux2 : p2.polinom)
				{
						rez.polinom.add(aux1.inmultire(aux2));
						rez.polinom.remove(aux1);
						rez.polinom.remove(aux2);
					
				}
		}
		
		ArrayList<Monom> delete1 = new ArrayList<Monom>(); 
		for (Monom aux1 : rez.polinom)
		{
			for(Monom aux2 : rez.polinom.subList(rez.polinom.indexOf(aux1)+1, rez.polinom.size()))
				{
					if (aux1.getPutere() == aux2.getPutere())
					{
						rez1.polinom.add(aux1.adunare(aux2));
						delete1.add(aux1);
						delete1.add(aux2);
					}
				}
		}
		rez.polinom.removeAll(delete1);
		
		for (Monom aux : rez.polinom)
		{
			rez1.polinom.add(aux);
		}
		rez1.polinom.sort(new ComparatorMonoame());
		return rez1;
	}
	
	public Polinom derivarePolinom(Polinom p1)
	{
		Polinom rez=new Polinom();
		for (Monom aux1 : p1.polinom)
		{
			rez.polinom.add(aux1.derivare());
		}
		return rez;
	}
	
	public Polinom integrarePolinom(Polinom p1)
	{
		Polinom rez=new Polinom();
		for (Monom aux1 : p1.polinom)
		{
			rez.polinom.add(aux1.integrare());
		}
		return rez;
	}
	
	public String impartirePolinom(Polinom p1,Polinom p2)
	{
		Polinom rest=new Polinom();
		
		p1.polinom.sort(new ComparatorMonoame());
		p2.polinom.sort(new ComparatorMonoame());
		int gradp1=0;
		int gradp2=0;
		for (Monom aux1 : p1.polinom)
		{
			if (aux1.getPutere() > gradp1) 
				gradp1 = (int) aux1.getPutere();
			
			
		}
		for (Monom aux1 : p2.polinom)
		{
			if (aux1.getPutere() > gradp2) 
				gradp2 = (int) aux1.getPutere();
			
			
		}
		int i=(int) (gradp1-gradp2);
		int j=0;
		String s="Catul: ";
		Polinom aux=new Polinom();
		for (Monom aux1 : p1.polinom)
		{
			aux.polinom.add(aux1);
			
			
		}
		if (gradp1<gradp2)
			s=s+0;
		else
			while(i>=0)
			{
				Polinom interm=new Polinom();
				Polinom interm1=new Polinom();
				String c="";
				String v="";
				float a=aux.polinom.get(j).coeficient/p2.polinom.get(0).coeficient;
				float b=aux.polinom.get(j).putere-p2.polinom.get(0).putere;
				interm.getPolinom().add(new Monom(a,(int) b));
				Monom m=new Monom(a,(int) b);
				s=s+m.toString();
				interm1=multPolinom(p2,interm);
				aux=subPolinom(aux,interm1);
				gradp1--;
				i--;
				j++;
			}
		s=s+"  ";
		s=s+"Restul: ";
		s=s+aux.toString();
		System.out.println(s+"\n");
		rest.polinom.sort(new ComparatorMonoame());
		return s;
	}

}
