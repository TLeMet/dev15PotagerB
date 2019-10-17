package fr.solutec.potagerb.entities;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	@ManyToMany @JoinTable(
			name = "User_Terrain", 
			joinColumns = @JoinColumn(name = "idUser"),
			inverseJoinColumns = @JoinColumn(name = "idTerrain"))
	Set<User> userOfTerrain;
	
	@ManyToOne
	private TypeTerrain type;
	
	@ManyToOne
	private User proprietaire;
	
	public Terrain() {}

	public Terrain(Long id, String nom, String gps, String adresse, String ville, double surface, Time hOuverture,
			Time hFermeture, int maxUser, Set<User> userOfTerrain, TypeTerrain type, User proprietaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.gps = gps;
		this.adresse = adresse;
		this.ville = ville;
		this.surface = surface;
		this.hOuverture = hOuverture;
		this.hFermeture = hFermeture;
		this.maxUser = maxUser;
		this.userOfTerrain = userOfTerrain;
		this.type = type;
		this.proprietaire = proprietaire;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public Time gethOuverture() {
		return hOuverture;
	}

	public void sethOuverture(Time hOuverture) {
		this.hOuverture = hOuverture;
	}

	public Time gethFermeture() {
		return hFermeture;
	}

	public void sethFermeture(Time hFermeture) {
		this.hFermeture = hFermeture;
	}

	public int getMaxUser() {
		return maxUser;
	}

	public void setMaxUser(int maxUser) {
		this.maxUser = maxUser;
	}

	public Set<User> getUserOfTerrain() {
		return userOfTerrain;
	}

	public void setUserOfTerrain(Set<User> userOfTerrain) {
		this.userOfTerrain = userOfTerrain;
	}

	public TypeTerrain getType() {
		return type;
	}

	public void setType(TypeTerrain type) {
		this.type = type;
	}

	public User getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(User proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "Terrain [id=" + id + ", nom=" + nom + ", gps=" + gps + ", adresse=" + adresse + ", ville=" + ville
				+ ", surface=" + surface + ", hOuverture=" + hOuverture + ", hFermeture=" + hFermeture + ", maxUser="
				+ maxUser + ", userOfTerrain=" + userOfTerrain + ", type=" + type + ", proprietaire=" + proprietaire
				+ "]";
	}

}
