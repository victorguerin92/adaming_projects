package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.User;

@Local
public interface IUserDao {
	
	public void ajouterUser(User u);
	public int supprimerUser(long id, Agent agent);
	public List<User> getallUser();
	public  User getByIdUser(long id);
	List<User> getAllUtilisateursByIdAgent(Agent a);
	public int modifierUser(User u, Agent agent);
	

}
