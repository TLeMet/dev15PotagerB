/*
package fr.solutec.potagerb.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class User_Terrain {

	@EmbeddedId
	User_Terrain_Keys id;
	
	@ManyToOne
	@MapsId("idUser")
	@JoinColumn(name = "idUser")
	User user;
	
	@ManyToOne
	@MapsId("idTerrain")
	@JoinColumn(name = "idTerrain")
	Terrain terrain;

	public User_Terrain() {}

	public User_Terrain_Keys getId() {
		return id;
	}

	public void setId(User_Terrain_Keys id) {
		this.id = id;
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

	
}
*/