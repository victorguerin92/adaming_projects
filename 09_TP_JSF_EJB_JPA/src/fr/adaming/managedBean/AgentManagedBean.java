package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import fr.adaming.model.Agent;
import fr.adaming.model.User;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IUserService;

@ManagedBean(name = "agentMB")
@SessionScoped
public class AgentManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mail;
	private String password;
	private Agent agent;

	private List<User> liste;
	@EJB
	IAgentService agentService;
	
	@EJB
	private IUserService userService;

	/**
	 * 
	 */
	public AgentManagedBean() {
		super();
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent
	 *            the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String isExist() {
		List<Agent> ListAgent = agentService.isExistService(mail, password);

		if (ListAgent.size() == 1) {
			agent = ListAgent.get(0);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agent", agent);
			liste=userService.getAllUtilisateursByIdAgent(agent);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listeUsers", liste);
			return "sucess";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("le login ou le mot de passe est incorrect"));

			return "fail";
		}

	}

	public String retourAccueil() {
		return "accueil";

	}

	public String seDeconnecter() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
}
