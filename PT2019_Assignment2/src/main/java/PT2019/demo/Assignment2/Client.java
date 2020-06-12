package PT2019.demo.Assignment2;

public class Client {

	private int id;
	private int arriving;
	private int processing;
	private int waiting;
	
	
	public Client(int id, int arriving, int processing, int waiting) {
		this.id = id;
		this.arriving = arriving;
		this.processing = processing;
		this.waiting = waiting;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArriving() {
		return arriving;
	}
	public void setArriving(int arriving) {
		this.arriving = arriving;
	}
	public int getProcessing() {
		return processing;
	}
	public void setProcessing(int processing) {
		this.processing = processing;
	}
	public int getWaiting() {
		return waiting;
	}
	public void setWaiting(int waiting) {
		this.waiting = waiting;
	}

	@Override
	public String toString() {
		return "Id=" + id + "\nArriving=" + arriving + "\nProcessing=" + processing + "\nWaiting=" + waiting
				+ "\n\n";
	}
	
	
}
