package eu.investuotojas.jmsquote;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.investuotojas.jmsquote.jms.QueueSender;
import eu.investuotojas.jmsquote.service.TickPriceJdbcService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-context.xml"})
public class JdbcTest extends AbstractJUnit4SpringContextTests
{
	@Autowired
	protected QueueSender sender ;
	
	@Autowired
	protected TickPriceJdbcService priceService;
	
	@Test	
	public void jdbcJMSTest()
	{
		/*System.out.println("jms test send");
		
		for(int i=0;i<1000;i++)
		{
			//sender.sendPrice(999, 1, 1.1, Calendar.getInstance().getTimeInMillis());
			sender.send(999,  1.2,2, Calendar.getInstance().getTimeInMillis());
		}
		
		
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	@Test
	public void jdbcTest()
	{
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++)
		{
			priceService.save(878,  1.2,2, Calendar.getInstance().getTimeInMillis());
		}
		System.out.println("jdbcTest: "+(System.currentTimeMillis()-start));
	}


}