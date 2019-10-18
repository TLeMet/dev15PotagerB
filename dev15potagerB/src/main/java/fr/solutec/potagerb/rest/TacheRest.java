package fr.solutec.potagerb.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.potagerb.dao.TacheRepository;
import fr.solutec.potagerb.entities.Tache;
import fr.solutec.potagerb.entities.Terrain;

@RestController
@CrossOrigin("*")
public class TacheRest {

	@Autowired
	private TacheRepository tacheRep;

	// Affichage de tous les terrains
	@RequestMapping(value = "/taches", method = RequestMethod.GET)
	public List<Tache> getAllTaches() {
		return (List<Tache>) tacheRep.findAll();
	}

	// Recherche des taches par id terrain
	@RequestMapping(value = "/taches/{id}", method = RequestMethod.GET)
	public Optional<Tache> getTerrain(@PathVariable Long id) {
		return tacheRep.findByIdTerrain(id);
	}
}
