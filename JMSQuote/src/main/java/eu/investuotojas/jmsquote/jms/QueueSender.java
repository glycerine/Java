package eu.investuotojas.jmsquote.jms;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

	 
@Component
public class QueueSender 
{
	@Autowired
    protected JmsTemplate jmsTemplate;
 

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Autowired
    public QueueSender( final JmsTemplate jmsTemplate )
    {
        this.jmsTemplate = jmsTemplate;
    }
 
    public void send( final String message )
    {
    	System.out.println("......");
    	try
    	{
        jmsTemplate.convertAndSend( "Queue.Name", message );
    	}
    	catch(Exception e)
    	{
    		 System.out.println("......"+e.getMessage());
    	}
       
    }
    public void sendPrice(Integer tickerId, Integer field, Double price, Long timestamp)
    {
    	Map <String, Object>map = new HashMap<String, Object>();
    	map.put("tickerId", tickerId);
    	map.put("field", field);
    	map.put("price", price);
    	map.put("timestamp", timestamp);
    	jmsTemplate.convertAndSend("Queue.Name", map);
    }
    
    public void sendVolume(Integer tickerId, Integer field, Integer size, Long timestamp)
    {
    	Map <String, Object>map = new HashMap<String, Object>();
    	map.put("tickerId", tickerId);
    	map.put("field", field);
    	map.put("size", size);
    	map.put("timestamp", timestamp);
    	jmsTemplate.convertAndSend("Queue.Name", map);
    }

}
