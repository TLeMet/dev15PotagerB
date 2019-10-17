package fr.solutec.potagerb.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.solutec.potagerb.dao.UserRepository;
import fr.solutec.potagerb.entities.User;

@RestController
@CrossOrigin("*")
public class UserRest {

	@Autowired
	private UserRepository userRep;
	
	// Affichage de tous les users
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return (List<User>) userRep.findAll();
	}
	
	// Recherche user par id
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public Optional<User> getUserbyId(@PathVariable Long id) {
		return userRep.findById(id); 
	}
	
	// Recherche user par mail
	@RequestMapping(value="/users/{mail}", method=RequestMethod.GET)
	public List<User> getUserbyMail(@PathVariable String mail) {
		return userRep.findByMail(mail); 
	}
	
	// Ajout user
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public User saveUser(@RequestBody User u) {
		return userRep.save(u);
	}
	
	// Delete user par id
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Long id) {
		userRep.deleteById(id);
		return true;
	}
	
	// Edit user par id
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public User editUser(@PathVariable Long id, @RequestBody User u) {
		u.setId(id);
		return userRep.save(u);
	}
	
}
