package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;

@Local
public interface IAgentDao {
	public List<Agent> isExist(String login, String mdp);
		
		
	

}
