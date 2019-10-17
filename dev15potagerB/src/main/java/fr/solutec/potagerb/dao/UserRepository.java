package fr.solutec.potagerb.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.potagerb.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public List<User> findByMail(String mail);
}
