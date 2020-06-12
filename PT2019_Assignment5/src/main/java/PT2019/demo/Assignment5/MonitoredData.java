package PT2019.demo.Assignment5;

import java.util.ArrayList;
import java.util.Date;

public class MonitoredData {
	
	private Date start;
	private Date end;
	private String activity;
	
	//ArrayList<MonitoredData> activities=new ArrayList<MonitoredData>();

	public MonitoredData(Date start, Date end, String activity) {
		// TODO Auto-generated constructor stub
		this.start=start;
		this.end=end;
		this.activity=activity;
	}
	

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	
	
	
}
