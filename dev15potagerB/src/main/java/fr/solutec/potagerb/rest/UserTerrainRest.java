package fr.solutec.potagerb.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		
	// Recherche d'un terrain par id terrain
	@RequestMapping(value="/userterrains/{id}", method= RequestMethod.GET)
	public Optional<UserTerrain> getUserTerrain(@PathVariable Long id){
		return userTerrRep.findById(id);
	}
	
	// Recherche des utilisateurs associés à un terrain via l'id terrain
	@RequestMapping(value="/userofterrain/{id}", method= RequestMethod.GET)
	public List<UserTerrain> getUserOfTerrain(@PathVariable Long id) {
		return (List<UserTerrain>) userTerrRep.findByTerrainId(id);
	}
	
	// Suppression des users d'un terrain via l'id terrain
	@RequestMapping(value="/userofterrain/{id}", method= RequestMethod.DELETE)
	public boolean supprTerrain(@PathVariable Long id) {
		userTerrRep.deleteByTerrainId(id);
		return true;
	}
}
