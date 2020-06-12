package PT2019.demo.Assignment2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueC implements Runnable
{
	private  LinkedList<Client> q=new LinkedList<Client>(); 
    private int runTime;
   // private int timpcurent=0;
    

    
    public QueueC() {
		
	}
	public boolean isEmpty()
    {
    	if(this.q.isEmpty())
    	{
    		return true;
    	}
    	return false;
    	
    }
	public LinkedList<Client> getQ() {
		return q;
	}

	public void setQ(LinkedList<Client> q) {
		this.q = q;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public void add(Client c)
	{
		Client cl=c;
		if(isEmpty())
		{
			cl.setWaiting(cl.getProcessing());
		}
		else 
		{
			cl.setWaiting((q.getLast().getWaiting()+cl.getProcessing()));
		}
		
		this.q.add(cl);
		//System.out.println("Se adauga clientul:\n"+"Id: "+cl.getId()+"\n"+"Arriving time: "+cl.getArriving()+"\n"+"Processing time: "+cl.getProcessing()+"\n"+"Waiting time: "+cl.getWaiting()+"\n\n\n");
		
		
	}
	
	public void delete()
	{
		this.q.removeFirst();
	}
	
	public synchronized void run()
	{
		while(!isEmpty())
		{
			//System.out.println("Se proceseaza clientul:\n"+"Id: "+q.peek().getId()+"\n"+"Arriving time: "+q.peek().getArriving()+"\n"+"Processing time: "+q.peek().getProcessing()+"\n"+"Waiting time: "+q.peek().getWaiting()+"\n\n\n");
			try {
				
				Thread.sleep(q.peek().getProcessing()*this.runTime);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("S-a procesat clientul:\n"+"Id: "+q.peek().getId()+"\n");//+"\n"+"Arriving time: "+q.peek().getArriving()+"\n"+"Processing time: "+q.peek().getProcessing()+"\n"+"Waiting time: "+q.peek().getWaiting()+"\n\n\n");
			q.removeFirst();
			//System.out.println("S-a proceseat clientul:\n"+"Id: "+q.peek().getId()+"\n"+"Arriving time: "+q.peek().getArriving()+"\n"+"Processing time: "+q.peek().getProcessing()+"\n\n\n");
			
			
		}
	}
	
 
}
