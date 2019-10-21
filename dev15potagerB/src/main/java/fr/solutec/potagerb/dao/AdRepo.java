package fr.solutec.potagerb.dao;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.Admin;

public interface AdRepo extends CrudRepository<Admin, Long>{

}
