package eu.investuotojas.jmsquote.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.investuotojas.jmsquote.da.TickPrice;
import eu.investuotojas.jmsquote.da.TickVolume;
import eu.investuotojas.jmsquote.service.TickPriceService;
import eu.investuotojas.jmsquote.service.TickVolumeService;

@Component 
public class QueueListener implements MessageListener
{
	@Autowired
	protected TickPriceService tickPrice;
	
	@Autowired
	protected TickVolumeService tickVolume;
	
    public void onMessage( final Message message )
    {
    	if ( message instanceof TextMessage )
    	{
    		final TextMessage textMessage = (TextMessage) message;
    		try
    		{
                 System.out.println( textMessage.getText() );
    		}
            catch (final JMSException e)
            {
            	e.printStackTrace();
            }
    	}
    	 else if (message instanceof MapMessage) 
		 {
    		 try
    		 {
				 MapMessage mapMessage = (MapMessage) message;
				 //log.debug(mapMessage.getString("tickerId")+"<<<<<<<<<<<<<<<<<<<<<<<"+msg.getJMSTimestamp());
				 
				 if(null != mapMessage.getString("price"))
				 {
					 TickPrice tp = new TickPrice();
					 
					 tp.setTimestamp(mapMessage.getLong("timestamp"));
					 tp.setTickerId(mapMessage.getInt("tickerId"));
					 tp.setField(mapMessage.getInt("field"));
					 tp.setPrice(mapMessage.getDouble("price"));
					 
					 tickPrice.save(tp);
				 }
				 else
				 {
					 TickVolume tv = new TickVolume();
					 
					 tv.setTimestamp(mapMessage.getLong("timestamp"));
					 tv.setTickerId(mapMessage.getInt("tickerId"));
					 tv.setField(mapMessage.getInt("field"));
					 
					 tv.setSize(mapMessage.getInt("size"));
					 tickVolume.save(tv);
				 }
    		 }
    		 catch (final JMSException e)
             {
             	e.printStackTrace();
             }
			 
		 }
    }
}
