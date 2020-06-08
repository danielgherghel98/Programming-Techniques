package PT2019.demo.DemoProject;

public class Monom {
	
	protected float coeficient;
	protected int putere;
	
	public Monom(float coeficient,int putere)
	{
		this.coeficient=coeficient;
		this.putere=putere;
	}
	public float getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(float coeficient) {
		this.coeficient = coeficient;
	}
	public float getPutere() {
		return putere;
	}
	public void setPutere(int putere) {
		this.putere = putere;
	}
	
	
	
	public Monom adunare(Monom m) {
		return new Monom ( this.coeficient+ m.coeficient, putere);
	}

	
	protected Monom scadere(Monom m) {
		return new Monom( this.coeficient - m.coeficient, this.putere);
	}

	
	protected Monom inmultire(Monom m) {
		return new Monom( this.coeficient * m.coeficient, this.putere + m.putere);
	}

	
	protected Monom impartire(Monom m) {
		return new Monom( this.coeficient / m.coeficient, this.putere - m.putere);
	}

	protected Monom derivare() {
		return new Monom( this.coeficient * this.putere, this.putere - 1);
	}

	
	protected Monom integrare() {
		return new Monom( this.coeficient / (this.putere + 1), this.putere + 1);
	}
	
	public String toString() {
		String s="";
		
			if (this.coeficient > 0) {
				s = s + " " + "+" + this.coeficient;
			}
			else if (this.coeficient < 0) 
					{
						s = s + " " +this.coeficient;
					}
			if (this.coeficient!=0) {	
			if( this.putere ==1)
			{
					s = s + "x" ;
				} 
			else if(this.putere>1) 
				{
					s = s + "x^" + this.putere;
				}
			}
		
		return s;
	}
}
