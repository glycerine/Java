package eu.investuotojas.jmsquote.service;

public interface TickPriceJdbcService 
{
	public void save(Integer tickerId,Double price,Integer field,long timestamp);
}
