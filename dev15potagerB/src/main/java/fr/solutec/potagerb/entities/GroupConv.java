package fr.solutec.potagerb.entities;

import java.nio.channels.NonWritableChannelException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class GroupConv {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User auteur;
	
	@ManyToOne
	private Terrain terrain;
	
	private String message;
	
	@Temporal (TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, nullable = false, updatable = false)
	private Date dateMessage;
	
	@Lob
	private byte[] image;
	
	public GroupConv() {
		super();
	}

	public GroupConv(User auteur, Terrain terrain, String message, Date dateMessage) {
		super();
		this.auteur = auteur;
		this.terrain = terrain;
		this.message = message;
		this.dateMessage = dateMessage;
	}
	
	

	public GroupConv(User auteur, Terrain terrain, String message, Date dateMessage, byte[] image) {
		super();
		this.auteur = auteur;
		this.terrain = terrain;
		this.message = message;
		this.dateMessage = dateMessage;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuteur() {
		return auteur;
	}

	public void setAuteur(User auteur) {
		this.auteur = auteur;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "GroupConv [id=" + id + ", auteur=" + auteur + ", terrain=" + terrain + ", message=" + message
				+ ", dateMessage=" + dateMessage + "]";
	}
	
	
	
	
	
}
