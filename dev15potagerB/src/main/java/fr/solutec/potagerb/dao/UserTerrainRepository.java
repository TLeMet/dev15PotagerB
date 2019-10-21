package fr.solutec.potagerb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.UserTerrain;

public interface UserTerrainRepository extends CrudRepository<UserTerrain, Long> {

	public void deleteByTerrainId(Long id);
	
	public List<UserTerrain> findByTerrainId(Long id);
}	
