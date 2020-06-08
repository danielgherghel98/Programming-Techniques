package PT2019.demo.DemoProject;

import java.util.Comparator;

public class ComparatorMonoame implements Comparator<Monom> {

	public int compare(Monom m1, Monom m2) {
		// TODO Auto-generated method stub
		int x;
		if( m1.getPutere() < m2.getPutere() ) 
			x=1;
		else if ( m1.getPutere() > m2.getPutere() )
			x=-1;
		else
			x=0;
		return x;
	}

}
