package PT2019.demo.Assignment5;

public class NumeZi {

	private String nume;
	private int zi;
	
	
	public NumeZi(String nume, int zi) {
		this.nume = nume;
		this.zi = zi;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getZi() {
		return zi;
	}
	public void setZi(int zi) {
		this.zi = zi;
	}
	@Override
	public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NumeZi other = (NumeZi) obj;
        
        if (this.zi != other.zi) {
            return false;
        }
        if ((this.nume == null) ? (other.nume != null) : !this.nume.equals(other.nume)) {
            return false;
        }
       
        return true;
    }
	
	@Override
    public int hashCode() {
        //System.out.println("Employee -  hashCode" );
        int hash = 3;
        hash = 67 * hash + this.zi;
        hash = 67 * hash + (this.nume != null ? this.nume.hashCode() : 0);
        return hash;
    }
}
