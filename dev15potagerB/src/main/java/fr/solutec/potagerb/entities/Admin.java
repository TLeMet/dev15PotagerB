package fr.solutec.potagerb.entities;

import javax.persistence.*;

@Entity
public class Admin {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String pseudo;
	private String pw;
	
	public Admin() {
		super();
	}

	public Admin( String pseudo, String pw) {
		super();
		this.pseudo = pseudo;
		this.pw = pw;
	}
	
}
