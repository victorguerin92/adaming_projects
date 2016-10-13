package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;

@Stateless
public class AgentDaoImpl implements IAgentDao {
	
	@PersistenceContext(unitName = "PU_TP_JSF_EJB_JPA")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> isExist(String login, String mdp) {
		
		String req="SELECT c FROM Agent c WHERE c.login=?1 AND c.password=?2 ";
		Query query = em.createQuery(req);
		query.setParameter(1, login);
		query.setParameter(2, mdp);
		
		List<Agent> ListeAgent = query.getResultList();
		
		return ListeAgent;
	}
	
	

}
