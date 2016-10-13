package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IUserDao;
import fr.adaming.dao.UserDaoImpl;
import fr.adaming.model.Agent;
import fr.adaming.model.User;
@Stateful
public class UserServiceImpl implements IUserService{
	
	@EJB
	IUserDao userDao=new UserDaoImpl();
	
	public void ajouterUserService(User u) {
		userDao.ajouterUser(u);
	}
	public int supprimerUserService(long id, Agent a) {
		 return userDao.supprimerUser(id,a);
	}
	public int modifierUserService(User u, Agent a) {
		return userDao.modifierUser(u, a);
	}
	public List<User> getallUserService() {
		List<User> list=userDao.getallUser();
 		return list;
	}
	public User getByIdUserService(long id) {
		
		return userDao.getByIdUser(id);
	}
	@Override
	public List<User> getAllUtilisateursByIdAgent(Agent agent) {
		
		return userDao.getAllUtilisateursByIdAgent(agent);
	} 
		
		
	

}
