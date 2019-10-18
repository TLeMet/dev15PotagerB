package fr.solutec.potagerb;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.potagerb.dao.TerrainRepository;
import fr.solutec.potagerb.dao.TypeTerrainRepository;
import fr.solutec.potagerb.dao.UserRepository;
import fr.solutec.potagerb.entities.*;


@SpringBootApplication
public class Dev15potagerBApplication implements CommandLineRunner{

	@Autowired
	private TerrainRepository terrRep;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private TypeTerrainRepository typeTRep;
	
	public static void main(String[] args) {
		SpringApplication.run(Dev15potagerBApplication.class, args);
		
		System.out.println("launch complete");
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		TypeTerrain typeT1 = new TypeTerrain("Jardin");
		typeTRep.save(typeT1);
		
		User u1 = new User("test1nom", "test1prenom", "test1mail", "test1pw", "01", 1);
		User u2 = new User("test2nom", "test2prenom", "test2mail", "test2pw", "02", 2);
		userRep.save(u1);
		userRep.save(u2);
		
		@SuppressWarnings("deprecation")
		Time time = new Time(0,0,1);
		
		Set<User> users = new HashSet<>();
		users.add(u1);
		users.add(u2);
		
		Terrain t1 = new Terrain("terrain1", "1.1", "ad1", "Paris", 14.5, time, time, 10, users, typeT1, u1);
		terrRep.save(t1);
	}
}
