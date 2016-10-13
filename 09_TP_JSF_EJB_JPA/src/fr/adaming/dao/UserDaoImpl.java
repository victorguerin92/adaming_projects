package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;
import fr.adaming.model.User;

@Stateless
public class UserDaoImpl implements IUserDao {

	@PersistenceContext(unitName = "PU_TP_JSF_EJB_JPA")
	private EntityManager em;

	@Override
	public void ajouterUser(User u) {
		System.out.println(u);
		em.merge(u);
	}

	@Override
	public int supprimerUser(long id_user, Agent agent) {

		String req = "SELECT d FROM User d where d.id_user=?1 AND d.agent.id_agent=?2";
		try {

			Query query = em.createQuery(req);

			query.setParameter(1, id_user);
			query.setParameter(2, agent.getId_agent());

			User u = (User) query.getSingleResult();

			em.remove(u);
			return 1;

		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int modifierUser(User u, Agent agent) {

		String req = "SELECT d FROM User d where d.id_user=?1 AND d.agent.id_agent=?2";
		try {

			Query query = em.createQuery(req);

			query.setParameter(1, u.getId_user());
			query.setParameter(2, agent.getId_agent());

			User user1 = em.find(User.class, u.getId_user());

			user1.setDaten(u.getDaten());
			user1.setNom(u.getNom());

			em.merge(user1);

			return 1;
		} catch (Exception e) {
		}

		return 0;
	}

	@Override
	public List<User> getallUser() {
		String req = "SELECT c FROM User c";

		Query query = em.createQuery(req);

		@SuppressWarnings("unchecked")
		List<User> liste = query.getResultList();

		for (User u : liste) {
			System.out.println(u);
		}
		return liste;
	}

	@Override
	public User getByIdUser(long id) {

		String jpqlReq2 = "SELECT d FROM User d WHERE d.id=?1";

		Query query2 = em.createQuery(jpqlReq2);
		query2.setParameter(1, id);

		User u = (User) query2.getSingleResult();

		return u;
	}

	@Override
	public List<User> getAllUtilisateursByIdAgent(Agent a) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM users c where c.agent_id=?1";

		Query query = em.createNativeQuery(req, User.class);
		query.setParameter(1, a.getId_agent());

		@SuppressWarnings("unchecked")
		List<User> liste = query.getResultList();

		return liste;
	}

		
	

}
