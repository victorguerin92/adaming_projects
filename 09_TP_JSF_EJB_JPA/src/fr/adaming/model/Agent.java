package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agents")
public class Agent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_a")
	private long id_agent;
	private String login;
	
	@Column(name="mdp")
	private String password;
	
	@OneToMany(mappedBy="agent",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	private List<User> listeUsers;

	/**
	 * 
	 */
	public Agent() {
		super();
	}

	/**
	 * @param login
	 * @param password
	 */
	public Agent(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/**
	 * @param id_agent
	 * @param login
	 * @param password
	 */
	public Agent(long id_agent, String login, String password) {
		super();
		this.id_agent = id_agent;
		this.login = login;
		this.password = password;
	}

	/**
	 * @return the id_agent
	 */
	public long getId_agent() {
		return id_agent;
	}

	/**
	 * @param id_agent the id_agent to set
	 */
	public void setId_agent(long id_agent) {
		this.id_agent = id_agent;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the listeUsers
	 */
	public List<User> getListeUsers() {
		return listeUsers;
	}

	/**
	 * @param listeUsers the listeUsers to set
	 */
	public void setListeUsers(List<User> listeUsers) {
		this.listeUsers = listeUsers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agent [id_agent=" + id_agent + ", login=" + login + ", password=" + password + ", listeUsers="
				+ listeUsers + "]";
	}
	
	

}
