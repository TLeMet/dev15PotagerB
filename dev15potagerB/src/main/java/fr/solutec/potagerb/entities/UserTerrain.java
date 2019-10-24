package fr.solutec.potagerb.entities;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Temporal;

@Entity
@IdClass(UserTerrainConstraint.class)
public class UserTerrain implements Serializable{
	
	/*@EmbeddedId
	UserTerrainConstraint id;
	*/
	
	@Id
	@ManyToOne
	private User user;
	
	@Id
	@ManyToOne
	private Terrain terrain;
	
	@Column(columnDefinition = "boolean default false", nullable=false)
	private boolean etat;
	private String message;
	
	@CreationTimestamp
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, nullable = false, updatable = false)
	private Date dateDemande;
	 
	
	public UserTerrain() {
		// TODO Auto-generated constructor stub
	}

	public UserTerrain(User user, Terrain terrain, boolean etat, String message, Date dateDemande) {
		super();
		this.user = user;
		this.terrain = terrain;
		this.etat = etat;
		this.message = message;
		this.dateDemande = dateDemande;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	@Override
	public String toString() {
		return "UserTerrain [user=" + user + ", terrain=" + terrain + ", etat=" + etat + ", message=" + message
				+ ", dateDemande=" + dateDemande + "]";
	}

	//fefef
}
