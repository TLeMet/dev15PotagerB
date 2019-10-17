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
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return (List<User>) userRep.findAll();
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public Optional<User> getUserbyId(@PathVariable Long id) {
		return userRep.findById(id); 
	}
	
	@RequestMapping(value="/users/{pseudo}", method=RequestMethod.GET)
	public List<User> getUserbyPseudo(@PathVariable String pseudo) {
		return userRep.findByPseudo(pseudo); 
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public User saveUser(@RequestBody User u) {
		return userRep.save(u);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Long id) {
		userRep.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public User editUser(@PathVariable Long id, @RequestBody User u) {
		u.setId(id);
		return userRep.save(u);
	}
	
}
