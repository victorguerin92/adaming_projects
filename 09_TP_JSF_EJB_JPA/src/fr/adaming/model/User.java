package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_u")
	private long id_user;
	private String nom;
	
	@Column(name="dn")
	@Temporal(TemporalType.DATE)
	private Date daten;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="agent_id",referencedColumnName="id_a")
	private Agent agent;
	/**
	 * 
	 */
	public User() {
		super();
	}
	/**
	 * @param nom
	 * @param daten
	 */
	public User(String nom, Date daten) {
		super();
		this.nom = nom;
		this.daten = daten;
	}
	/**
	 * @param id_user
	 * @param nom
	 * @param daten
	 */
	public User(long id_user, String nom, Date daten) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.daten = daten;
	}
	/**
	 * @return the id_user
	 */
	public long getId_user() {
		return id_user;
	}
	/**
	 * @param id_user the id_user to set
	 */
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the daten
	 */
	public Date getDaten() {
		return daten;
	}
	/**
	 * @param daten the daten to set
	 */
	public void setDaten(Date daten) {
		this.daten = daten;
	}
	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}
	/**
	 * @param agent the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", nom=" + nom + ", daten=" + daten + "]";
	}
	
	
	
	

}
