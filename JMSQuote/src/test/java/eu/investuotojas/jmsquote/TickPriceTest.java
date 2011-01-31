package eu.investuotojas.jmsquote;

import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import eu.investuotojas.jmsquote.da.TickPrice;
import eu.investuotojas.jmsquote.service.TickPriceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-context.xml"})
@Transactional()
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class TickPriceTest extends AbstractTransactionalJUnit4SpringContextTests 
{
	@Resource
	private TickPriceService service;
	
	@Test
    public void testTickPriceSave()
    {

		TickPrice da = new TickPrice();
		da.setField(1);
		da.setPrice(1111.0);
		da.setTickerId(1);
		Calendar cal = Calendar.getInstance();
		da.setTimestamp(cal.getTimeInMillis());
		service.save(da);
    }

	public TickPriceService getService() {
		return service;
	}

	public void setService(TickPriceService service) {
		this.service = service;
	}

}
