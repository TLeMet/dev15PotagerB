package fr.solutec.potagerb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public Optional<User> findByMail(String mail);
	
	
}
