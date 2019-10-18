package fr.solutec.potagerb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class UserTerrainConstraint implements Serializable {

	private Long user;
	
	private Long terrain;
	
	public UserTerrainConstraint() {
		// TODO Auto-generated constructor stub
	}

}
