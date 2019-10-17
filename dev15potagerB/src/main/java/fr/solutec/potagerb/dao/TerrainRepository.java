package fr.solutec.potagerb.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.Terrain;
import fr.solutec.potagerb.entities.User;

public interface TerrainRepository extends CrudRepository<Terrain, Long>{

	// public Optional<Terrain> findByIdProp(User proprietaire);
	
	public Optional<Terrain> findByType(Long idType);
	
	public Optional<Terrain> findBySurfaceGreaterThanEqual(double surface);
	
	public Optional<Terrain> findByNom(String nom);
}
