package PT2019.demo.DemoProject;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polinom p1,p2,p3;
		String s="";
		p1=new Polinom();
		p2=new Polinom();
		p3=new Polinom();
		//p1.getPolinom().add(new Monom(1,2));
		p1.getPolinom().add(new Monom(6,1));
		p1.getPolinom().add(new Monom(8,0));
		p1.getPolinom().add(new Monom(3,2));
		//p1.getPolinom().add(new Monom(1,3));
		//p2.getPolinom().add(new Monom(7,2));
		p2.getPolinom().add(new Monom(2,1));
		p2.getPolinom().add(new Monom(-1,0));
		//p3=p1.impartirePolinom(p2);
		//for(Monom aux : p1.getPolinom())
		//{
		//	s= s + aux.toString();
		//}
		//System.out.println(s+"\n");
		/*Ideone i=new Ideone("+4x^2-2x^4-6x^0",p3);
		for(Monom aux : p3.getPolinom())
		{
			s= s + aux.toString();
		}
		System.out.println("\n"+s);
		*/
		View vedere=new View();
		
		
	}

}
