package eu.investuotojas.jmsquote.service;

public interface TickVolumeJdbcService 
{
	public void save(Integer tickerId,Integer size,Integer field,long timestamp);
}
