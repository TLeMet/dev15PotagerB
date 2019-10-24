package fr.solutec.potagerb.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.potagerb.dao.GroupConvRepository;
import fr.solutec.potagerb.dao.ImageGroupRepository;
import fr.solutec.potagerb.dao.TerrainRepository;
import fr.solutec.potagerb.dao.UserTerrainRepository;
import fr.solutec.potagerb.entities.GroupConv;
import fr.solutec.potagerb.entities.ImageGroup;
import fr.solutec.potagerb.entities.Terrain;
import fr.solutec.potagerb.entities.UserTerrain;


@RestController
@CrossOrigin("*")
public class TerrainRest {
	

	@Autowired
	private TerrainRepository terrRep;
	
	@Autowired
	private UserTerrainRepository userTerrRep;
	
	@Autowired
	private ImageGroupRepository imGrRep;
	
	@Autowired
	private GroupConvRepository groupConvRep;
	
	// Affichage de tous les terrains
	@RequestMapping(value="/terrains", method= RequestMethod.GET)
	public List<Terrain> getAllTerrains(){
		return (List<Terrain>) terrRep.findAll();
	}
	
	// Recherche d'un terrain par id terrain
	@RequestMapping(value="/terrains/{id}", method= RequestMethod.GET)
	public Optional<Terrain> getTerrain(@PathVariable Long id){
		return terrRep.findById(id);
	}
	
	// Recherche d'un terrain par id propriétaire
	@RequestMapping(value="/terrainsprop/{id}", method = RequestMethod.GET)
	public List<Terrain> getTerrainByIdProprio(@PathVariable Long id){
		return terrRep.findByProprietaireId(id); 

	}
	

	// Recherche d'un terrain par type
	@RequestMapping(value="/terrains/type/{id}", method= RequestMethod.GET)
	public List<Terrain> getTerrainByType(@PathVariable Long id){
		return terrRep.findByTypeId(id);
	} 

	
	// Recherche d'un terrain par surface min
	@RequestMapping(value="/terrains/surface/{surf}", method= RequestMethod.GET)
	public Optional<Terrain> getTerrainBySurfaceMin(@PathVariable double surf){
		return terrRep.findBySurfaceGreaterThanEqual(surf);
	}
	
	// Recherche terrain par nom
	@RequestMapping(value="/terrains/nom/{nom}", method= RequestMethod.GET)
	public Optional<Terrain> getTerrainByName(@PathVariable String nom){
		return terrRep.findByNomIgnoreCase(nom);
	}
	
	 // Recherche terrain par nom ou ville contenant lettre
	@RequestMapping(value="/terrains/nomville/{input}", method= RequestMethod.GET)
	public List<Terrain> getTerrainByNameOrVille(@PathVariable String input){
		return terrRep.SearchByVilleAndNom("%"+input+"%"); 
	} 
	
		
	// Insertion terrain
	@RequestMapping(value="/terrains", method= RequestMethod.POST)
	public Terrain saveTerrain(@RequestBody Terrain t) {
		return terrRep.save(t);
	}
	
	// Supression d'un terrain
	@Transactional
	@RequestMapping(value="/terrains/{id}", method= RequestMethod.DELETE)
	public boolean supprTerrain(@PathVariable Long id) {
		
		List<GroupConv> gc1 = new ArrayList<GroupConv>();
		List<GroupConv> gc2 = new ArrayList<GroupConv>();
		gc1 = groupConvRep.findAllImageByTerrain(id);
		gc2 = groupConvRep.findAllMessageByTerrain(id);
		
		if (gc1 != null || gc2 != null) {
			groupConvRep.supprGroupMessageByTerrain(id);	
		}
		
		List<UserTerrain> ut1 = new ArrayList<UserTerrain>();
		ut1 = userTerrRep.findByTerrainId(id);
					
		if (ut1 != null) {
			userTerrRep.deleteByTerrainId(id);
		}
		
		ImageGroup im = new ImageGroup();
		im = imGrRep.findByTerrainId(id);
		
		if (im != null) {
			imGrRep.deleteById(id);	
		}

		terrRep.deleteById(id);
		return true;
	}
	
	// Modification d'un terrain
	@RequestMapping(value="/terrains/{id}", method= RequestMethod.PUT)
	public Terrain modifTerrain(@PathVariable Long id, @RequestBody Terrain t) {
		t.setId(id);
		return terrRep.save(t);
	}
	
}
