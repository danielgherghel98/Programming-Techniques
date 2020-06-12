package PT2019.demo.Assignment5;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
        Aplicatie a=new Aplicatie();
        a.readFromText();
        System.out.println("Log-ul cu activitati:\n");
        a.getMonitoredData();
        System.out.println("\n\n\n");
        System.out.println("Numar de zile aparute in log: ");
        System.out.println(a.count(a.getcountDays())+"\n\n\n");
        //a.print();
        System.out.println("Numarul de aparitii a fiecarei activitati in log: \n");
        HashMap<String,Integer> map=a.numarAct(a.getNrActivitati());
        for(Entry<String, Integer> hash : map.entrySet() )
        System.out.println(hash.getKey()+"     "+hash.getValue());
        System.out.println("\n\n\n");
        System.out.println("Numarul de aparitii a fiecarei activitati in fiecare zi:\n");
        HashMap<NumeZi,Integer> map1=a.numarAct_Day(a.getActivitati_Day());
        for(Entry<NumeZi, Integer> hash1 : map1.entrySet() )
        System.out.println("Activitate: "+hash1.getKey().getNume()+"   Ziua: "+hash1.getKey().getZi()+"   Repetari: "+"     "+hash1.getValue());
        System.out.println("\n\n\n");
        System.out.println("Durata activitati:\n");
        HashMap<String,Long> map2=a.durata_Activitati(a.getDurataActivitati());
        for(Entry<String, Long> hash2 : map2.entrySet() )
        System.out.println(hash2.getKey()+"    "+"Durata(Secunde):"+" "+hash2.getValue()+"\n");
        System.out.println("\n\n\n");
        System.out.println("Durata fiecarei activitati pe toata perioada log-ului:\n");
        HashMap<String,Long> map3=a.durata_ActivitatiT(a.getDurataActivitatiT());
        for(Entry<String, Long> hash3 : map3.entrySet() )
        System.out.println("Activitate: "+hash3.getKey()+"    "+"Durata(minute)"+"     "+hash3.getValue()+"\n");
        System.out.println("\n\n\n");
        System.out.println("Activitati care au o durata mai mica de 5 secunde in peste 90% din cazuri:\n");
        HashMap<String,Integer> map4=a.durata_ActivitatiT5(a.getDurataActivitatiT5());
        for(Entry<String, Integer> hash4 : map4.entrySet() )
        {
        	if(hash4.getValue()>=0.9*map.get(hash4.getKey()))
        	{
        		System.out.println("Activitatea:  "+hash4.getKey());
        	}
        }
    }
}
