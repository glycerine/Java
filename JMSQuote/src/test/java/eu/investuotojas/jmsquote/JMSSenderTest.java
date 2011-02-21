package eu.investuotojas.jmsquote;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.jms.MapMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.investuotojas.jmsquote.jms.QueueSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-context.xml"})
public class JMSSenderTest extends AbstractJUnit4SpringContextTests
{
	@Autowired
	protected QueueSender sender ;
	
	
	@Test	
	public void jmsTest()
	{
		System.out.println("jms test send");
		
		/*for(int i=0;i<10;i++)
		{
			sender.sendPrice(999, 1, 1.1, Calendar.getInstance().getTimeInMillis());
			
		}
		
		
		sender.send("super duper TEST MESSAGE>>>>>>>>>>>>>>>>>>>>");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
