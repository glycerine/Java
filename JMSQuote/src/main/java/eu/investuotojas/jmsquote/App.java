package eu.investuotojas.jmsquote;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ib.client.Contract;
import com.ib.client.EClientSocket;

import eu.investuotojas.jmsquote.client.IBClient;
import eu.investuotojas.jmsquote.jms.QueueSender;

/**
 * Application starts here
 *
 */
public class App implements Runnable
{
	private Logger log = Logger.getLogger(getClass());
	
    public static void main( String[] args )
    {
    	Thread t = (new Thread(new App()));
		t.start();
        
       
    }

	public void run() 
	{
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		 QueueSender sender = (QueueSender)context.getBean("queueSender");
		 IBClient cl = new IBClient();
		 cl.setSender(sender);
		 EClientSocket m_client = new EClientSocket(cl);
		  
		 Contract contra = new Contract();
		 contra.m_currency= "USD";
		 contra.m_expiry = "201103";
		 contra.m_exchange = "GLOBEX";
		 contra.m_secType = "FUT";
		 contra.m_symbol = "ES";
		 
		 m_client.eConnect("127.0.0.1", 4001, 74156);
		 
		 m_client.reqMktData(100001, contra, "", false);
		 log.debug("><><><>?<> "+74156);
		 while (true) 
		 {
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		 }
	}
}
