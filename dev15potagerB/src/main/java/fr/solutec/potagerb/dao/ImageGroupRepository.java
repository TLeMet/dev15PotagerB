package fr.solutec.potagerb.dao;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.ImageGroup;

public interface ImageGroupRepository extends CrudRepository<ImageGroup, Long>{
	
	public ImageGroup findByTerrainId(Long id);
}
