package fr.solutec.potagerb.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.Terrain;
import fr.solutec.potagerb.entities.User;

public interface TerrainRepository extends CrudRepository<Terrain, Long>{

	// public Optional<Terrain> findByIdProp(User proprietaire);
	@Query(value="SELECT t.*, tp.id as idtp, tp.libelle FROM terrain t INNER JOIN type_terrain tp ON t.type_id = tp.id WHERE t.type_id = 1", nativeQuery = true)
	public List<Object> findByIdType();
	
	public List<Terrain> findByTypeId(Long id);
	
	public Optional<Terrain> findBySurfaceGreaterThanEqual(double surface);
	
	public Optional<Terrain> findByNom(String nom);
}
