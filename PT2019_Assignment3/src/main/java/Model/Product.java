package Model;

public class Product {

	private int idProduct;
	private int stoc;
	private String nameProduct;
	private double pret;
	
	public Product(int idProduct, String nameProduct, double pret, int stoc) {
		super();
		this.idProduct = idProduct;
		this.stoc = stoc;
		this.nameProduct = nameProduct;
		this.pret = pret;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getStoc() {
		return stoc;
	}
	public void setStoc(int stoc) {
		this.stoc = stoc;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	
	
}
