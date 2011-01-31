package eu.investuotojas.jmsquote.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import eu.investuotojas.jmsquote.da.TickPrice;

@Transactional
public class TickPriceImpl implements TickPriceService
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
	public List<TickPrice> getAllTickPrice() {
		
		Query query = em.createQuery("select p FROM TickPrice p ");
		return query.getResultList();
	}

	public void save(TickPrice tickprice) {
		if(tickprice.getTickerId() == null)
        {
        	em.persist(tickprice);
        }
        else
        {
        	em.merge(tickprice);
        }
		
	}

	@SuppressWarnings("unchecked")
	public List<TickPrice> getTickPrice(Integer id) {
		
		Query query = em.createQuery("select p FROM TickPrice p where p.tickerid=:id");
		query.setParameter("id", id);
		return query.getResultList();
	}

}
