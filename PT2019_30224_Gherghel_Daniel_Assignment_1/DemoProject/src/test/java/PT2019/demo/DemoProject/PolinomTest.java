package PT2019.demo.DemoProject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PolinomTest {

	Polinom p1,p2;
	@Test
	public void AddTest() {
		p1 = new Polinom();
		p2 = new Polinom();

		// p1=2x^4+2x^3-3x^1+2x^0
		p1.getPolinom().add(new Monom(2, 4));
		p1.getPolinom().add(new Monom(2, 3));
		p1.getPolinom().add(new Monom(-3, 1));
		p1.getPolinom().add(new Monom(2, 0));
		
		// p2=1x^3+x+3x^2+4x^0
		p2.getPolinom().add(new Monom(1, 3));
		p2.getPolinom().add(new Monom(1, 1));
		p2.getPolinom().add(new Monom(3, 2));
		p2.getPolinom().add(new Monom(4, 0));
		
		
		Polinom result = new Polinom();
		Operatii o=new Operatii();
		result = o.addPolinom(p1,p2);
		// result=2x^4 + 3x^3 + 3x^2 - 2x + 6
		Polinom resTrue = new Polinom();
		resTrue.getPolinom().add(new Monom(2,4));
		resTrue.getPolinom().add(new Monom(3,3));
		resTrue.getPolinom().add(new Monom(3,2));
		resTrue.getPolinom().add(new Monom(-2,1));
		resTrue.getPolinom().add(new Monom(6,0));
		
		assertEquals(result.toString(),resTrue.toString());
	}
	
	@Test
	public void SubTest() {
		p1 = new Polinom();
		p2 = new Polinom();
		Operatii o=new Operatii();

		// p1=2x^4 + 2x^3 - 3x + 2
		p1.getPolinom().add(new Monom(2, 4));
		p1.getPolinom().add(new Monom(2, 3));
		p1.getPolinom().add(new Monom(-3, 1));
		p1.getPolinom().add(new Monom(2, 0));
		
		// p2=x^3 + x+ 3x^2 + 4
		p2.getPolinom().add(new Monom(1, 3));
		p2.getPolinom().add(new Monom(1, 1));
		p2.getPolinom().add(new Monom(3, 2));
		p2.getPolinom().add(new Monom(4, 0));
		
		
		Polinom result = new Polinom();
		result = o.subPolinom(p1,p2);
		
		// result=2x^4 + x^3 - 3x^2 - 4x - 2
		Polinom resTrue = new Polinom();
		resTrue.getPolinom().add(new Monom(2,4));
		resTrue.getPolinom().add(new Monom(1,3));
		resTrue.getPolinom().add(new Monom(-3,2));
		resTrue.getPolinom().add(new Monom(-4,1));
		resTrue.getPolinom().add(new Monom(-2,0));
		
		assertEquals(result.toString(),resTrue.toString());
	}
	
	@Test
	public void MultTest() {
		p1 = new Polinom();
		p2 = new Polinom();
		Operatii o=new Operatii();
		// p1=-3x + 2
		p1.getPolinom().add(new Monom(-3, 1));
		p1.getPolinom().add(new Monom(2, 0));
		
		// p2=3x^2 + 4
		p2.getPolinom().add(new Monom(3, 2));
		p2.getPolinom().add(new Monom(4, 0));
		
		
		Polinom result = new Polinom();
		result = o.multPolinom(p1,p2);
		// result= -9x^3 + 6x^2 - 12x + 8
		Polinom resTrue = new Polinom();
		resTrue.getPolinom().add(new Monom(-9,3));
		resTrue.getPolinom().add(new Monom(6,2));
		resTrue.getPolinom().add(new Monom(-12,1));
		resTrue.getPolinom().add(new Monom(8,0));
		
		assertEquals(result.toString(),resTrue.toString());
	}
	
	@Test
	public void ImpTest() {
		p1 = new Polinom();
		p2 = new Polinom();
		Operatii o=new Operatii();

		// p1=2x - 2
		p2.getPolinom().add(new Monom(2, 1));
		p2.getPolinom().add(new Monom(-1, 0));
		
		// p2=3x^2 + 6x + 8
		p1.getPolinom().add(new Monom(3, 2));
		p1.getPolinom().add(new Monom(6, 1));
		p1.getPolinom().add(new Monom(8, 0));
		
		
		String result ="";
		result = o.impartirePolinom(p1,p2);
		String resTrue="Catul:  +1.5x +3.75  Restul:  +11.75";
		
		assertEquals(result,resTrue);
	}
	
	
	@Test
	public void DerivareTest() {
		p1 = new Polinom();
		Operatii o=new Operatii();
		
		// p1=2x^4 + 2x^3 - 3x + 2
		p1.getPolinom().add(new Monom(2, 4));
		p1.getPolinom().add(new Monom(2, 3));
		p1.getPolinom().add(new Monom(-3, 1));
		
		
		
		Polinom result = new Polinom();
		result = o.derivarePolinom(p1);
		// result=8x^3 + 6x^2 - 3
		Polinom resTrue = new Polinom();
		
		resTrue.getPolinom().add(new Monom(8,3));
		resTrue.getPolinom().add(new Monom(6,2));
		resTrue.getPolinom().add(new Monom(-3,0));
		
		assertEquals(result.toString(),resTrue.toString());
	}
	
	@Test
	public void IntegrareTest() {
		p1 = new Polinom();
		Operatii o=new Operatii();
		

		// p1=5x^4 + 8x^3 - 4x + 2
		p1.getPolinom().add(new Monom(5, 4));
		p1.getPolinom().add(new Monom(8, 3));
		p1.getPolinom().add(new Monom(-4, 1));
		p1.getPolinom().add(new Monom(2, 0));
		
	
		Polinom result = new Polinom();
		result = o.integrarePolinom(p1);
		// result=x^5 + 2x^4 - 2x^2 + 2x
		Polinom resTrue = new Polinom();
		resTrue.getPolinom().add(new Monom(1,5));
		resTrue.getPolinom().add(new Monom(2,4));
		resTrue.getPolinom().add(new Monom(-2,2));
		resTrue.getPolinom().add(new Monom(2,1));
		
		assertEquals(result.toString(),resTrue.toString());
	}
}
