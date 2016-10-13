package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.dao.IUserDao;
import fr.adaming.model.Agent;
import fr.adaming.model.User;
import fr.adaming.service.IUserService;

@ManagedBean(name = "userMB")
@RequestScoped
public class UserManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private Agent agent;
	HttpSession session;

	@EJB
	IUserDao userDao;
	@EJB
	IUserService userService;

	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		agent = (Agent) session.getAttribute("agent");
	}

	public UserManagedBean() {
		this.user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// Methodes Ajouter

	public String ajouterUser() {
		user.setAgent(agent);
		userDao.ajouterUser(user);
		List<User> listeUsers = new ArrayList<User>();

		listeUsers = userDao.getAllUtilisateursByIdAgent(agent);
		session.setAttribute("listeUsers", listeUsers);
		return "acceuil";
	}

	// methode Supprimer

	public String supprimerUser() {
		user.setAgent(agent);

		if (userService.supprimerUserService(user.getId_user(), agent) == 1) {
			List<User> listeUsers = new ArrayList<User>();
			listeUsers = userService.getAllUtilisateursByIdAgent(agent);
			session.setAttribute("listeUsers", listeUsers);
			return "acceuil";
		}

		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("l'ID est incorrect"));

			return "supprimer";
		}
	}

	public String modfierUser() {
		user.setAgent(agent);
		
		if(userService.modifierUserService(user,agent)==1)
		{
		List<User> listeUsers = new ArrayList<User>();
		listeUsers = userService.getAllUtilisateursByIdAgent(agent);
		session.setAttribute("listeUsers", listeUsers);
		return "acceuil";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("l'ID est incorrect"));

			return "modifier";
		}
		
	}

}