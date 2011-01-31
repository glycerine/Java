package eu.investuotojas.jmsquote.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import eu.investuotojas.jmsquote.da.TickVolume;

@Transactional
public class TickVolumeImpl implements TickVolumeService
{
	
	private EntityManager em;
	
	
	@PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public EntityManager getEntityManager() {
        return em;
    }
	
	@SuppressWarnings("unchecked")
	public List<TickVolume> getAllTickVol() {
		Query query = em.createQuery("select p FROM TickVolume");
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TickVolume> getTickVol(Integer id) {
		Query query = em.createQuery("select p FROM TickVolume p where p.tickerid=:id");
		query.setParameter("id", id);
		return query.getResultList();
		
	}

	public void save(TickVolume tickvol) {
		if(tickvol.getTickerId() == null)
        {
        	em.persist(tickvol);
        }
        else
        {
        	em.merge(tickvol);
        }
		
	}

}
