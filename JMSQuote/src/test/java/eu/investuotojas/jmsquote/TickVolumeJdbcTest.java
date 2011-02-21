package eu.investuotojas.jmsquote;

import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-context.xml"})
public class TickVolumeJdbcTest extends AbstractJUnit4SpringContextTests 
{
	@Resource
	protected eu.investuotojas.jmsquote.service.TickVolumeJdbcService service;
	
	@Test
    public void testTickPriceSave()
    {
		long start = System.currentTimeMillis();
		for(int i=0;i<1000;i++)
		{
			service.save(878,  1,2, Calendar.getInstance().getTimeInMillis());
		}
		System.out.println("jdbcTest: "+(System.currentTimeMillis()-start));
    }

	

}
