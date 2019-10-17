package fr.solutec.potagerb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeTerrain {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	
	
	
	
	public TypeTerrain() {
		super();
	}


	public TypeTerrain(String libelle) {
		super();
		this.libelle = libelle;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "TypeTerrain [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
	
}
