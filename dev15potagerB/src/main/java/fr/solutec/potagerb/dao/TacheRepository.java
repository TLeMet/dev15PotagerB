package fr.solutec.potagerb.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.Tache;
import fr.solutec.potagerb.entities.Terrain;
import fr.solutec.potagerb.entities.User;

public interface TacheRepository extends CrudRepository<Tache, Long>{
	
	public Optional<Tache> findById(Long id);
	
	public Optional<Tache> findByTerrainId(Long id);
	
	public Optional<Tache> findByUserDoneId(Long id);

}
