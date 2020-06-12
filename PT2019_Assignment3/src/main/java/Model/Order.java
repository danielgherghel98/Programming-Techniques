package Model;

public class Order {

	private int idClient;
	private int idProduct;
	private int cantitate;
	private int idOrder;
	
	public Order(int idOrder,int idClient, int idProduct, int cantitate) {
		super();
		this.idClient = idClient;
		this.idProduct = idProduct;
		this.cantitate = cantitate;
		this.idOrder = idOrder;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
}
