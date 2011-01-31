package eu.investuotojas.jmsquote.service;

import java.util.List;

import eu.investuotojas.jmsquote.da.TickPrice;

public interface TickPriceService 
{
	public List<TickPrice> getTickPrice(final Integer id);
	
	public void save(final TickPrice tickprice);
	
	public List<TickPrice> getAllTickPrice();
}
