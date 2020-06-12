package PT2019.demo.Assignment2;

import java.util.ArrayList;

public class Processing implements Runnable {

	private int id=1;
	private int minArrive;
	private int maxArrive;
	private int minProcess;
	private int maxProcess;
	private int simulation;
	private int nrCozi;
	ArrayList<QueueC> cozi=new ArrayList<QueueC>();
	Cozi coziInterface; 
	public Processing() {
		
	}
	public Processing(int minArrive, int maxArrive, int minProcess, int maxProcess, int simulation,int nrCozi,Cozi coziI) {
		this.minArrive = minArrive;
		this.maxArrive = maxArrive;
		this.minProcess = minProcess;
		this.maxProcess = maxProcess;
		this.simulation = simulation;
		this.nrCozi = nrCozi;
		this.coziInterface=coziI;
		for(int i=0; i<this.nrCozi; i++)
		{
			QueueC q=new QueueC();
			cozi.add(q);
			cozi.get(i).setRunTime(1000);
		}
		
	}
	public void initializare() {
		for(int i=0; i<nrCozi; i++)
		{
			
			Thread thread=new Thread(cozi.get(i));
			thread.start();
		}
	}
	public int getMinArrive() {
		return minArrive;
	}
	public void setMinArrive(int minArrive) {
		this.minArrive = minArrive;
	}
	public int getMaxArrive() {
		return maxArrive;
	}
	public void setMaxArrive(int maxArrive) {
		this.maxArrive = maxArrive;
	}
	public int getMinProcess() {
		return minProcess;
	}
	public void setMinProcess(int minProcess) {
		this.minProcess = minProcess;
	}
	public int getMaxProcess() {
		return maxProcess;
	}
	public void setMaxProcess(int maxProcess) {
		this.maxProcess = maxProcess;
	}
	public int getSimulation() {
		return simulation;
	}
	public void setSimulation(int simulation) {
		this.simulation = simulation;
	}
	
	public int coadaOptima()
	{
		
		for(int i=0; i<this.nrCozi; i++)
		{
			if(cozi.get(i).getQ().size()<3)
			{
				return i;
			}
		}
		return 0;
	}
	
	public synchronized void run()
	{
		int index=1;
		//this.coziInterface=coziInterface;
		//coziInterface.setVisible(true);
		//initializare();
		while (index<=this.simulation)
		{
			initializare();
			
			ClientGenerator generator=new ClientGenerator(index,this.minArrive,this.maxArrive,this.minProcess,this.maxProcess);
			Client c=generator.generate();
			index++;
			int coada=coadaOptima();
			cozi.get(coada).add(c);
			try {
				Thread.sleep(cozi.get(coada).getRunTime());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=0;
			while(!cozi.get(i).getQ().isEmpty())
			{
				Client ant = null;
				for(Client cl: cozi.get(i).getQ())
				{
					if(cl.equals(cozi.get(i).getQ().peek()))
					{
						cl.setWaiting(cl.getProcessing());
						ant=cl;
					}
					else
					{
						cl.setWaiting(cl.getProcessing()+ant.getWaiting());
					}
					ant=cl;
				}
				i++;
				
			}
			//coziInterface.setVisible(true);
			if(!cozi.get(0).getQ().isEmpty())
				coziInterface.getTextArea().setText(cozi.get(0).getQ().toString());
			if(!cozi.get(1).getQ().isEmpty())
				coziInterface.getTextArea_1().setText(cozi.get(1).getQ().toString());
			if(!cozi.get(2).getQ().isEmpty())
				coziInterface.getTextArea_2().setText(cozi.get(2).getQ().toString());
			if(!cozi.get(3).getQ().isEmpty())
				coziInterface.getTextArea_3().setText(cozi.get(3).getQ().toString());
			if(!cozi.get(4).getQ().isEmpty())
				coziInterface.getTextArea_4().setText(cozi.get(4).getQ().toString());
			
			//System.out.println("Id: "+c.getId()+"\n"+"Arriving time: "+c.getArriving()+"\n"+"Processing time: "+c.getProcessing()+"\n\n\n");
			
		}
		while(!cozi.isEmpty())
		{
			initializare();
			//int i=0;
			for(QueueC cozii:cozi)
			{
				Client ant = null;
				for(Client cl: cozii.getQ())
				{
					if(cl.equals(cozii.getQ().peek()))
					{
						cl.setWaiting(cl.getProcessing());
						ant=cl;
					}
					else
					{
						cl.setWaiting(cl.getProcessing()+ant.getWaiting());
					}
					ant=cl;
				}
				
				
			}
			//if(!cozi.get(0).getQ().isEmpty())
				coziInterface.getTextArea().setText(cozi.get(0).getQ().toString());
			//if(!cozi.get(1).getQ().isEmpty())
				coziInterface.getTextArea_1().setText(cozi.get(1).getQ().toString());
			//if(!cozi.get(2).getQ().isEmpty())
				coziInterface.getTextArea_2().setText(cozi.get(2).getQ().toString());
			//if(!cozi.get(3).getQ().isEmpty())
				coziInterface.getTextArea_3().setText(cozi.get(3).getQ().toString());
			//if(!cozi.get(4).getQ().isEmpty())
				coziInterface.getTextArea_4().setText(cozi.get(4).getQ().toString());
		}
		
	}
	
}
