package fr.solutec.potagerb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class ImageGroup {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Lob
	private byte[] image;
	
	@OneToOne
	private Terrain terrain;

	
	public ImageGroup() {
		super();
	}


	public ImageGroup(String name, byte[] image, Terrain terrain) {
		super();
		this.name = name;
		this.image = image;
		this.terrain = terrain;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public Terrain getTerrain() {
		return terrain;
	}


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	
}
