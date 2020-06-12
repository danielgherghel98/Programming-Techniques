package Model;

public class Client {
	
	private int idClient;
	private String nameClient;
	private String adresa;
	
	
	public Client(int idClient, String nameClient, String adresa) {
		super();
		this.idClient = idClient;
		this.nameClient = nameClient;
		this.adresa = adresa;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNameClient() {
		return nameClient;
	}
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	
}
