package fr.solutec.potagerb.entities;

import javax.persistence.*;

@Entity
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String mail;
	private String pw;
	private String tel;
	private int age;
	
	/*@OneToMany
	private Terrain terrain;*/

	public User(String pseudo, String nom, String prenom, String mail, String pw, String tel, int age) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pw = pw;
		this.tel = tel;
		this.age = age;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}*/

	@Override
	public String toString() {
		return "User [id=" + id + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", pw=" + pw + ", tel=" + tel + ", age=" + age;// + ", terrain=" + terrain + "]";
	}
	
}
