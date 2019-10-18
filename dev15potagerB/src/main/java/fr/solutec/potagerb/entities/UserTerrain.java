package fr.solutec.potagerb.entities;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
	
	public UserTerrain() {
		// TODO Auto-generated constructor stub
	}

	public UserTerrain(User user, Terrain terrain) {
		super();
		this.user = user;
		this.terrain = terrain;
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

	@Override
	public String toString() {
		return "UserTerrain [user=" + user.toString() + ", terrain=" + terrain.toString() + "]";
	}
	
	
}
