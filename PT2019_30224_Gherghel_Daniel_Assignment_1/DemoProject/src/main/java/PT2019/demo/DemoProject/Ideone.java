package PT2019.demo.DemoProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ideone {
	public Ideone(String s,Polinom p)
	{  
		Pattern pattern=Pattern.compile("([+-]?[^-+]+)");
		Matcher matcher = pattern.matcher(s);
		
		int x=0;
		int coeficient,putere;
		
		while(matcher.find())
		{
			x=x+1;
			String c=matcher.group(1);
			coeficient=Integer.parseInt(c.substring(0,2));
			if(c.length()>2) {
			putere=Integer.parseInt(c.substring(c.length()-1));
			}
			else {
				putere=Integer.parseInt(c);
			}
			p.getPolinom().add(new Monom(coeficient,putere));
			
		}
		
	}
}
