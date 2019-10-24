package fr.solutec.potagerb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.potagerb.dao.GroupConvRepository;
import fr.solutec.potagerb.entities.GroupConv;

@RestController
@CrossOrigin("*")
public class GroupConvRest {
	
	@Autowired
	private GroupConvRepository groupConvRep;
	
	// Liste de tous les messages d'un terrain
	@RequestMapping(value="/messageGroupe/{id}", method= RequestMethod.GET)
	public List<GroupConv> getAllMessageByTerrain(@PathVariable Long id){
		return groupConvRep.findAllMessageByTerrain(id);
	}
	
	// Insertion message
	@RequestMapping(value="/messageGroupe/{idUser}/{idTerrain}", method= RequestMethod.POST)
	public GroupConv saveMessage(@PathVariable Long idUser, @PathVariable Long idTerrain, @RequestBody GroupConv gc) {
		gc.getAuteur().setId(idUser);
		gc.getTerrain().setId(idTerrain);	
		return groupConvRep.save(gc);
	}
	
	// Supprimer tous les messages d'un terrain
	@RequestMapping(value="/messageGroupe/{id}", method= RequestMethod.DELETE)
	public boolean supprGroupMessage(@PathVariable Long id) {
		groupConvRep.supprGroupMessageByTerrain(id);
		return true;
	}
	
	// Liste de toutes les images d'un terrain
	@RequestMapping(value="/imageGroupe/{id}", method= RequestMethod.GET)
	public List<GroupConv> getAllImageByTerrain(@PathVariable Long id){
		return groupConvRep.findAllImageByTerrain(id);
	}
	
	
} 
