package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.User;
@Local
public interface IUserService {
	public void ajouterUserService(User u);
	public int supprimerUserService(long id, Agent a);
	public int modifierUserService(User u,Agent a);
	public List<User> getallUserService();
	public User getByIdUserService(long id);
	public List<User> getAllUtilisateursByIdAgent(Agent agent);
}
