package PT2019.demo.Assignment5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplicatie {
	ArrayList<MonitoredData> activities=new ArrayList<MonitoredData>();
	ArrayList<String> list;
	private int i;
	private int days=1;
	HashMap<String,Integer> nractivitati=new HashMap<String,Integer>();
	HashMap<String,Long> durataActivitati=new HashMap<String,Long>();
	HashMap<String,Long> durataActivitatiT=new HashMap<String,Long>();
	HashMap<String,Integer> durataActivitatiT5=new HashMap<String,Integer>();
	HashMap<NumeZi,Integer> activitati_day=new HashMap<NumeZi,Integer>();
	
	public ArrayList<MonitoredData> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<MonitoredData> activities) {
		this.activities = activities;
	}
	
	public void readFromText()
	{
		String fileName = "Activities.txt";
	    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

	        list = (ArrayList<String>) stream.map(w -> w.split("\t\t")).flatMap(Arrays::stream).collect(Collectors.toList());
	    } catch (IOException e) {

	        e.printStackTrace();
	    }
	}
	
	public void getMonitoredData() throws ParseException
	{
		for( i=0; i<list.size();i+=3) {
		System.out.println(list.get(i)+"   "+list.get(i+1)+"    "+list.get(i+2)+"\n");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
		MonitoredData m=new MonitoredData(format.parse(list.get(i)),format.parse(list.get(i+1)),list.get(i+2));
			                       //                       ^--startingTime       ^--finishingTime      ^--label
		//System.out.println(m.getStart()+"   "+m.getEnd()+"    "+m.getActivity()+"\n");
		activities.add(m);		
		}
	}
	CountDays countDays=()->{
		for(int i=1; i<activities.size();i++)
		{
			if(activities.get(i).getStart().getDate()!=activities.get(i-1).getStart().getDate())
			{
				days++;
			}
		}
		return days;
	};
	@SuppressWarnings("deprecation")
	public int count(CountDays countDay)
	{
		return countDay.countDays();	
	}
	public CountDays getcountDays()
	{
		return countDays;
	}
	NrActivitati nrActivitati=()->{
		
		for(int i=0; i<activities.size();i++)
		{
			if(nractivitati.get(activities.get(i).getActivity())==null)
			{
				nractivitati.put(activities.get(i).getActivity(),1);
			}
			else 
			{
				nractivitati.put(activities.get(i).getActivity(),nractivitati.get(activities.get(i).getActivity())+1);
			}
		}
		return nractivitati;
	};
	public NrActivitati getNrActivitati()
	{
		return nrActivitati;
	}
	public HashMap<String,Integer> numarAct(NrActivitati nrActiv)
	{
		return nrActiv.nrActivitati();	
	}
	Activitati_Day activitati_Day=()->{
		
		for(int i=0; i<activities.size();i++)
		{
			NumeZi a=new NumeZi(activities.get(i).getActivity(),activities.get(i).getStart().getDate());
			if(activitati_day.get(a)==null)
			{
				activitati_day.put(a,1);
			}
			else 
			{
				activitati_day.put(a,activitati_day.get(a)+1);
			}
		}
		return activitati_day;
	};
	public Activitati_Day getActivitati_Day()
	{
		return activitati_Day;
	}
	public HashMap<NumeZi,Integer> numarAct_Day(Activitati_Day nrActiv_Day)
	{
		return nrActiv_Day.activitati_Day();	
	}
   Durataactivitati DurataActivitati=()->{
		for(int i=0; i<activities.size();i++)
		{
			String s=new String();
			s+=activities.get(i).getStart().toString()+"     "+activities.get(i).getEnd().toString()+"     "+activities.get(i).getActivity();
			long milisec=activities.get(i).getEnd().getTime()-activities.get(i).getStart().getTime();
			long minutes=TimeUnit.SECONDS.convert(milisec,TimeUnit.MILLISECONDS);
			durataActivitati.put(s,minutes);	
		}
		return durataActivitati;
	};
	public Durataactivitati getDurataActivitati()
	{
		return DurataActivitati;
	}
	public HashMap<String,Long> durata_Activitati(Durataactivitati durata)
	{
		return durata.DurataActivitati();
		
	}
  DurataactivitatiT DurataActivitatiT=()->{
		for(int i=0; i<activities.size();i++)
		{
			long milisec=activities.get(i).getEnd().getTime()-activities.get(i).getStart().getTime();
			long minutes=TimeUnit.MINUTES.convert(milisec,TimeUnit.MILLISECONDS);
			String s=activities.get(i).getActivity();
			if(durataActivitatiT.get(s)==null)
			{
				durataActivitatiT.put(s,minutes);
			}
			else 
			{
				durataActivitatiT.put(s,durataActivitatiT.get(s)+minutes);
			}	
		}
		return durataActivitatiT;
	};
	public DurataactivitatiT getDurataActivitatiT()
	{
		return DurataActivitatiT;
	}
	public HashMap<String,Long> durata_ActivitatiT(DurataactivitatiT durataT)
	{
		return durataT.DurataActivitatiT();
		
	}
	DurataactivitatiT5 DurataActivitatiT5=()->{

		for(int i=0; i<activities.size();i++)
		{
			long milisec=activities.get(i).getEnd().getTime()-activities.get(i).getStart().getTime();
			long minutes=TimeUnit.MINUTES.convert(milisec,TimeUnit.MILLISECONDS);
			if(minutes<5) {
			if(durataActivitatiT5.get(activities.get(i).getActivity())==null)
			{
				durataActivitatiT5.put(activities.get(i).getActivity(),1);
			}
			else 
			{
				durataActivitatiT5.put(activities.get(i).getActivity(),durataActivitatiT5.get(activities.get(i).getActivity())+1);
			}
			}
		}
		return durataActivitatiT5;
	};
	public DurataactivitatiT5 getDurataActivitatiT5()
	{
		return DurataActivitatiT5;
	}
	public HashMap<String,Integer> durata_ActivitatiT5(DurataactivitatiT5 durataT5)
	{
		return durataT5.DurataActivitatiT5();	
	}
}
