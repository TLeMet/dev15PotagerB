package fr.solutec.potagerb.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.potagerb.dao.AdminRepository;
import fr.solutec.potagerb.dao.TerrainRepository;
import fr.solutec.potagerb.dao.UserTerrainRepository;
import fr.solutec.potagerb.entities.Terrain;
import fr.solutec.potagerb.entities.UserTerrain;

@RestController
@CrossOrigin("*")
public class UserTerrainRest {

	@Autowired
	private UserTerrainRepository userTerrRep;
	
	// Affichage de tous les terrains
	@RequestMapping(value="/userterrainsall", method= RequestMethod.GET)
	public List<UserTerrain> getAllUserTerrain(){
		return (List<UserTerrain>) userTerrRep.findAll();
	}
	
	// Recherche des utilisateurs associés à un terrain via l'id terrain
	@RequestMapping(value="/userofterrain/{id}", method= RequestMethod.GET)
	public List<UserTerrain> getUserOfTerrain(@PathVariable Long id) {
		return (List<UserTerrain>) userTerrRep.findByTerrainId(id);
	}
	
	// Suppression des users d'un terrain via l'id terrain
	@RequestMapping(value="/del.usersofterrain/{id}", method= RequestMethod.DELETE)
	public boolean supprTerrain(@PathVariable Long id) {
		userTerrRep.supprTerrain(id);
		return true;
	}
	
	// Compter nb utilisateurs d'un terrain par l'id terrain
	@RequestMapping(value="/cnt.userofterrain/{id}", method= RequestMethod.GET)
	public int countUserOfTerrain(@PathVariable Long id) {
		int nbUser = userTerrRep.countUserOfTerrain(id);
		return nbUser;
	}
	
	// Supprimer un User d'un terrain 
	@RequestMapping(value="/del.userofterrain/{idUser}/{idTerrain}", method= RequestMethod.DELETE)
	public boolean supprUserOfTerrain(@PathVariable Long idUser, @PathVariable Long idTerrain) {
		userTerrRep.supprUserOfTerrain(idUser, idTerrain);
		return true;
	}
	
	// Liste des terrains d'un user via l'id user
	@RequestMapping(value="/terrainofuser/{id}", method= RequestMethod.GET)
	public List<UserTerrain> getTerrainOfUser(@PathVariable Long id) {
		return (List<UserTerrain>) userTerrRep.findByUserId(id);
	}
	
	// Liste des demandes associées à un terrain 
	@RequestMapping(value="/requestofterrain/{id}", method= RequestMethod.GET)
	public List<Object> getRequestOfTerrain(@PathVariable Long id){
		return userTerrRep.requestOfTerrain(id);
	}
	
}
