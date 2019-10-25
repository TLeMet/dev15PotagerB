package fr.solutec.potagerb.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.potagerb.dao.ImageGroupRepository;
import fr.solutec.potagerb.entities.ImageGroup;

@RestController
@CrossOrigin("*")
public class ImageGroupRest {

	@Autowired
	ImageGroupRepository imGrRep;
	
	@RequestMapping(value="/uploadGroupImage/{idTerrain}", method= RequestMethod.POST)
	public ImageGroup uploadImageGroup(@PathVariable Long idTerrain, @RequestBody ImageGroup img ) {
		img.getTerrain().setId(idTerrain);
		return imGrRep.save(img);
	}
	
	@RequestMapping(value="/imageGroup/{idTerrain}", method= RequestMethod.GET)
	public ImageGroup getImageGroup(@PathVariable Long idTerrain) {
		return imGrRep.findByTerrainId(idTerrain);
	} 
	
	@RequestMapping(value="/image/{id}", method= RequestMethod.GET)
	public Optional<ImageGroup> getImageById(@PathVariable Long id) {
		return imGrRep.findById(id);
	} 
	
	
	@RequestMapping(value="/imageGroup/{id}", method = RequestMethod.DELETE)
	public boolean supprImgGroup(@PathVariable Long id) {
		imGrRep.deleteById(id);
		return true;
	}
	
}
