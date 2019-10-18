package fr.solutec.potagerb.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.Tache;
import fr.solutec.potagerb.entities.Terrain;

public interface TacheRepository extends CrudRepository<Tache, Long>{
	
	public Optional<Tache> findById(Long id);
	
	public Optional<Tache> findByIdTerrain(Long idterrain);

}
