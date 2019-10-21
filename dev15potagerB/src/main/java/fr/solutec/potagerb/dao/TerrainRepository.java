package fr.solutec.potagerb.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.Terrain;


public interface TerrainRepository extends CrudRepository<Terrain, Long>{

	public Optional<Terrain> findByProprietaireId(Long id);
	
	// @Query(value="SELECT t.*, tp.id as idtp, tp.libelle FROM terrain t INNER JOIN type_terrain tp ON t.type_id = tp.id WHERE t.type_id = 1", nativeQuery = true)
	// public List<Object> findByIdType();
	
	public List<Terrain> findByTypeId(Long id);
	
	public Optional<Terrain> findBySurfaceGreaterThanEqual(double surface);
	
	public Optional<Terrain> findByNomIgnoreCase(String nom);
	
	
	/* @Query("select t.adresse from Terrain t where t.ville like %?#{escape([0])} escape ?#{escapeCharacter()}")
	public Optional<Terrain> aaa(String a); */
	
	/* @Query("select Count(user) as tot from UserTerrain ut where ut. = ?1")
	public int findCountUser(Long id); */
}
