package fr.solutec.potagerb.entities;

import javax.persistence.*;

@Entity
public class TypeAction {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	
	public TypeAction() {
		super();
	}

	public TypeAction(String libelle) {
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
		return "TypeAction [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
