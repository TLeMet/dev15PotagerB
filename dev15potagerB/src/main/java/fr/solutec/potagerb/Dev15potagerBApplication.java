package fr.solutec.potagerb;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.potagerb.dao.AdRepo;
import fr.solutec.potagerb.dao.TerrainRepository;
import fr.solutec.potagerb.dao.TypeTerrainRepository;
import fr.solutec.potagerb.dao.UserRepository;
import fr.solutec.potagerb.dao.UserTerrainRepository;
import fr.solutec.potagerb.entities.*;


@SpringBootApplication
public class Dev15potagerBApplication implements CommandLineRunner{

	@Autowired
	private TerrainRepository terrRep;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private TypeTerrainRepository typeTRep;
	
	@Autowired
	private UserTerrainRepository userTerrainRepos;
	
	@Autowired
	private AdRepo adrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Dev15potagerBApplication.class, args);
		
		System.out.println("launch complete");
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("test1", "test1", "test1", "test1", "01", 1);
		User u2 = new User("test2", "test2", "test2", "test2", "02", 2);
		User u3 = new User("test3", "test3", "test3", "test3", "03", 3);
		userRep.save(u1);
		userRep.save(u2);
		userRep.save(u3);
		
		@SuppressWarnings("deprecation")
		Time time = new Time(0,0,1);
		
		TypeTerrain typeT1 = new TypeTerrain("Jardin");
		typeTRep.save(typeT1);
		
		
		Terrain t1 = new Terrain("terrain1", "1.1", "ad1", "Paris", 14.5, time, time, 10, "description", typeT1, u1);
		Terrain t2 = new Terrain("terrain2", "2.2", "ad2", "Paris", 14.5, time, time, 5, "description", typeT1, u3);
		terrRep.save(t1);
		terrRep.save(t2);
		
		
		UserTerrain usert1 = new UserTerrain(u1, t1, false); 
		UserTerrain usert2 = new UserTerrain(u2, t1, false); 
		UserTerrain usert3 = new UserTerrain(u3, t2, false); 
		UserTerrain usert4 = new UserTerrain(u2, t2, false); 
		
		userTerrainRepos.save(usert1);
		userTerrainRepos.save(usert2);
		userTerrainRepos.save(usert3);
		userTerrainRepos.save(usert4);
		
		Admin ad1 = new Admin("vfdhygv", "hgdcfj");
		Admin ad2 = new Admin("vfdhygv", "hgdcfj");
		Admin ad3 = new Admin("vfdhygv", "hgdcfj");
		adrepo.save(ad1);
		adrepo.save(ad2);
		adrepo.save(ad3);
		
		
		
	}
}
