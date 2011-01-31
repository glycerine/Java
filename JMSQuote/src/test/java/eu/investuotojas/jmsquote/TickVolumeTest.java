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

import eu.investuotojas.jmsquote.da.TickVolume;
import eu.investuotojas.jmsquote.service.TickVolumeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-context.xml"})
@Transactional()
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class TickVolumeTest extends AbstractTransactionalJUnit4SpringContextTests 
{
	@Resource
	private TickVolumeService service;
	
	@Test
    public void testTickVolumeSave()
    {

		TickVolume da = new TickVolume();
		da.setField(1);
		da.setSize(85555);
		da.setTickerId(1);
		Calendar cal = Calendar.getInstance();
		da.setTimestamp(cal.getTimeInMillis());
		service.save(da);
    }

	public void setService(TickVolumeService service) {
		this.service = service;
	}

	public TickVolumeService getService() {
		return service;
	}
}
