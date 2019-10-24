package fr.solutec.potagerb.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.GroupConv;

public interface GroupConvRepository extends CrudRepository<GroupConv, Long>{

	@Query("select gc from GroupConv gc where terrain.id = ?1 and gc.image is null")
	public List<GroupConv> findAllMessageByTerrain(Long id);
	
	@Query("Delete from GroupConv gc where terrain.id = ?1")
	@Transactional
	@Modifying
	public void supprGroupMessageByTerrain(Long id);
	
	@Query("select gc from GroupConv gc where terrain.id = ?1 and gc.image is not null")
	public List<GroupConv> findAllImageByTerrain(Long id);
	
}
