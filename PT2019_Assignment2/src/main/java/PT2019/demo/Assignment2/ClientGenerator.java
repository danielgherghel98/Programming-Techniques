package PT2019.demo.Assignment2;

import java.util.Random;

public class ClientGenerator {

	private int id;
	private int minArrive;
	private int maxArrive;
	private int minProcess;
	private int maxProcess;
	public ClientGenerator(int id,int minArrive, int maxArrive, int minProcess, int maxProcess) {
		
		this.id=id;
		this.minArrive = minArrive;
		this.maxArrive = maxArrive;
		this.minProcess = minProcess;
		this.maxProcess = maxProcess;
	}
	
	public Client generate()
	{
		Random rand = new Random(); 
		int arrive=rand.nextInt((maxArrive - minArrive) + 1) + minArrive;
		int process=rand.nextInt((maxProcess - minProcess) + 1) + minProcess;
		return new Client(this.id,arrive,process,0);
	}
	
}
