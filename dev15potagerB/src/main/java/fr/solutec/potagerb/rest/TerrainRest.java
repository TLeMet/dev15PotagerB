package fr.solutec.potagerb.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.potagerb.dao.TerrainRepository;
import fr.solutec.potagerb.entities.Terrain;
import fr.solutec.potagerb.entities.User;

@RestController
@CrossOrigin("*")
public class TerrainRest {
	
	class tyTerrain{
		
	}

	@Autowired
	private TerrainRepository terrResp;
	
	// Affichage de tous les terrains
	@RequestMapping(value="/terrains", method= RequestMethod.GET)
	public List<Terrain> getAllTerrains(){
		return (List<Terrain>) terrResp.findAll();
	}
	
	// Recherche d'un terrain par id terrain
	@RequestMapping(value="/terrains/{id}", method= RequestMethod.GET)
	public Optional<Terrain> getTerrain(@PathVariable Long id){
		return terrResp.findById(id);
	}
	
	/*// Recherche d'un terrain par id propriétaire
	@RequestMapping(value="/terrainsprop/{p}", method = RequestMethod.GET)
	public Optional<Terrain> getTerrainByIdProprio(@PathVariable User p){
		return terrResp.findByIdProp(p); 
	} */
	

	// Recherche d'un terrain par type
	@RequestMapping(value="/terrains/type/{id}", method= RequestMethod.GET)
	public List<Terrain> getTerrainByType(@PathVariable Long id){
		return terrResp.findByTypeId(id);
	} 
	
	// Recherche d'un terrain par surface min
	@RequestMapping(value="/terrains/surface/{surf}", method= RequestMethod.GET)
	public Optional<Terrain> getTerrainBySurfaceMin(@PathVariable double surf){
		return terrResp.findBySurfaceGreaterThanEqual(surf);
	}
	
	// Recherche terrain par nom
	@RequestMapping(value="/terrains/nom/{nom}")
	public Optional<Terrain> getTerrainByName(@PathVariable String nom){
		return terrResp.findByNom(nom);
	}
	
	
	
	// Insertion terrain
	@RequestMapping(value="/terrains", method= RequestMethod.POST)
	public Terrain saveTerrain(@RequestBody Terrain t) {
		return terrResp.save(t);
	}
	
	
	
}
