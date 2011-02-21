package eu.investuotojas.jmsquote.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.investuotojas.jmsquote.service.TickPriceJdbcService;


@Component 
public class JdbcListener implements MessageListener
{
	
	private Logger log = Logger.getLogger(getClass());

	@Autowired
	protected TickPriceJdbcService priceService;
	
	@Autowired
	protected eu.investuotojas.jmsquote.service.TickVolumeJdbcService volumeService;
	private Integer counter =0;
	public void onMessage(Message message) 
	{
		 if (message instanceof MapMessage) 
		 {
    		 try
    		 {
				 MapMessage mapMessage = (MapMessage) message;
				 
				 //log.debug(mapMessage.getString("tickerId")+">>>>><"+message.getJMSTimestamp());
				 
				 if(null != mapMessage.getString("price"))
				 { 
					 priceService.save(mapMessage.getInt("tickerId"),mapMessage.getDouble("price"),mapMessage.getInt("field"),mapMessage.getLong("timestamp"));
					 log.debug(mapMessage.getLong("timestamp"));
					 //System.out.println("counter2 "+counter);
					 /*log.debug(mapMessage.getLong("timestamp"));
					log.debug(mapMessage.getInt("tickerId"));
					log.debug(mapMessage.getInt("field"));
					log.debug(mapMessage.getDouble("price"));*/
					 
					 
				 }
				 else
				 {
					 counter++;
					 log.debug("counter "+counter);
					// System.out.println("counter "+counter);
					 volumeService.save(mapMessage.getInt("tickerId"),mapMessage.getInt("size"),mapMessage.getInt("field"),mapMessage.getLong("timestamp"));
					 /*log.debug(mapMessage.getLong("timestamp"));
					 log.debug(mapMessage.getInt("tickerId"));
					 log.debug(mapMessage.getInt("field"));
					 
					 log.debug(mapMessage.getInt("size"));*/
					
				 }
    		 }
    		 catch (final JMSException e)
             {
             	e.printStackTrace();
             }
			 
		 }
		
	}

}
