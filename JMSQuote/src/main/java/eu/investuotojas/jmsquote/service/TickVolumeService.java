package eu.investuotojas.jmsquote.service;

import java.util.List;

import eu.investuotojas.jmsquote.da.TickVolume;

public interface TickVolumeService 
{
	public List<TickVolume> getTickVol(final Integer id);
	public void save(final TickVolume tickvol);
	public List<TickVolume> getAllTickVol();
}
