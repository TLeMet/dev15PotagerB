package fr.solutec.potagerb.entities;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
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
	@Column(nullable = false)
	private String nom;
	private String gps;
	private String adresse;
	@Column(nullable= false)
	private String ville;
	@Column(nullable=false)
	private double surface;
	private Time hOuverture;
	private Time hFermeture;
	@Column(nullable=true)
	private int maxUser;
	private String description;
	//Photo!
	
	/*@ManyToMany @JoinTable(
			name = "User_Terrain", 
			joinColumns = @JoinColumn(name = "idUser"),
			inverseJoinColumns = @JoinColumn(name = "idTerrain"))
	Set<User> userOfTerrain;
	*/
	@ManyToOne
	private TypeTerrain type;
	
	@ManyToOne
	private User proprietaire;
	
	public Terrain() {}

	public Terrain(String nom, String gps, String adresse, String ville, double surface, Time hOuverture,
			Time hFermeture, int maxUser, String description, TypeTerrain type,
			User proprietaire) {
		super();

		this.nom = nom;
		this.gps = gps;
		this.adresse = adresse;
		this.ville = ville;
		this.surface = surface;
		this.hOuverture = hOuverture;
		this.hFermeture = hFermeture;
		this.maxUser = maxUser;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
				+ maxUser + ", description=" + description + ", type=" + type + ", proprietaire=" + proprietaire + "]";
	}

	
}
