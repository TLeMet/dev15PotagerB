package fr.solutec.potagerb.entities;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Terrain {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String gps;
	private String adresse;
	private String ville;
	private double surface;
	private Time hOuverture;
	private Time hFermeture;
	private int maxUser;
	
	/*@ManyToMany Set<User> jardineurs;
	@ManyToMany @JoinTable(
			name = "user_terrain", 
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumn = @JoinColumn(name = "terrain_id"))
	Set<User> jardineurs;*/
	
	
	
}
