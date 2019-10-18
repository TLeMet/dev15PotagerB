package fr.solutec.potagerb.entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Tache {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateCreated;
	private Date dateScheduled;
	private Boolean done;
	private Date dateDone;
	
	@ManyToOne
	private Terrain terrain;
	
	@ManyToOne
	private User userIssued;
	
	@ManyToOne
	private User userDone;
	
	@ManyToOne
	private TypeAction action;
	
	@ManyToOne
	private TypePlante plante;

	public Tache() {
		super();
	}

	public Tache(Long id, Date dateCreated, Date dateScheduled, Boolean done, Date dateDone, Terrain terrain,
			User userIssued, User userDone, TypeAction action, TypePlante plante) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.dateScheduled = dateScheduled;
		this.done = done;
		this.dateDone = dateDone;
		this.terrain = terrain;
		this.userIssued = userIssued;
		this.userDone = userDone;
		this.action = action;
		this.plante = plante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateScheduled() {
		return dateScheduled;
	}

	public void setDateScheduled(Date dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Date getDateDone() {
		return dateDone;
	}

	public void setDateDone(Date dateDone) {
		this.dateDone = dateDone;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public User getUserIssued() {
		return userIssued;
	}

	public void setUserIssued(User userIssued) {
		this.userIssued = userIssued;
	}

	public User getUserDone() {
		return userDone;
	}

	public void setUserDone(User userDone) {
		this.userDone = userDone;
	}

	public TypeAction getAction() {
		return action;
	}

	public void setAction(TypeAction action) {
		this.action = action;
	}

	public TypePlante getPlante() {
		return plante;
	}

	public void setPlante(TypePlante plante) {
		this.plante = plante;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", dateCreated=" + dateCreated + ", dateScheduled=" + dateScheduled + ", done="
				+ done + ", dateDone=" + dateDone + ", terrain=" + terrain + ", userIssued=" + userIssued
				+ ", userDone=" + userDone + ", action=" + action + ", plante=" + plante + "]";
	}

	
	
}
