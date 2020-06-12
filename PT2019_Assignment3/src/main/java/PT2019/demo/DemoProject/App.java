package PT2019.demo.DemoProject;

import Data.Conection;
import Data.ConnectionFactory;
import Presentation.COMAND;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Conection c = new Conection();
    	c.createConection();
    	System.out.println( "Succes!" );
    	COMAND cm=new COMAND();
    	cm.setVisible(true);
        
    }
}
