package fr.solutec.potagerb;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.potagerb.dao.AdminRepository;
import fr.solutec.potagerb.dao.GroupConvRepository;
import fr.solutec.potagerb.dao.ImageGroupRepository;
import fr.solutec.potagerb.dao.TerrainRepository;
import fr.solutec.potagerb.dao.TypeTerrainRepository;
import fr.solutec.potagerb.dao.UserRepository;
import fr.solutec.potagerb.dao.UserTerrainRepository;
import fr.solutec.potagerb.entities.*;

@SpringBootApplication
public class Dev15potagerBApplication implements CommandLineRunner {

	@Autowired
	private TerrainRepository terrRep;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private TypeTerrainRepository typeTRep;

	@Autowired
	private UserTerrainRepository userTerrainRepos;

	@Autowired
	private AdminRepository adrepo;
	
	@Autowired
	private ImageGroupRepository imGrRep;
	
	@Autowired
	private GroupConvRepository grConvRep;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Dev15potagerBApplication.class, args);

		System.out.println("launch complete");
	}

	@Override
	public void run(String... args) throws Exception {

		TypeTerrain typeT1 = new TypeTerrain("Jardin");
		typeTRep.save(typeT1);

		User u1 = new User("test1", "test1", "test1", "test1", "01", 1);
		User u2 = new User("test2", "test2", "test2", "test2", "02", 2);
		User u3 = new User("test3", "test3", "test3", "test3", "03", 3);

		userRep.save(u1);
		userRep.save(u2);
		userRep.save(u3);

		@SuppressWarnings("deprecation")
		Time time = new Time(0, 0, 1);

		@SuppressWarnings("deprecation")
		Date date = new Date(119, 00, 02);

		Terrain t1 = new Terrain("terrain1", "1.1", "ad1", "Paris", 14.5, time, time, 10, "description", typeT1, u1);
		Terrain t2 = new Terrain("terrain2", "2.2", "ad2", "Paris", 14.5, time, time, 5, "description", typeT1, u1);
		terrRep.save(t1);
		terrRep.save(t2);

		String message = "Bonjour, j'aimerais ramasser vos concombres";

		UserTerrain usert1 = new UserTerrain(u1, t1, true, message, date);
		UserTerrain usert2 = new UserTerrain(u2, t1, false, message, date);
		UserTerrain usert3 = new UserTerrain(u3, t2, false, message, date);
		UserTerrain usert4 = new UserTerrain(u2, t2, false, message, date);
		UserTerrain usert5 = new UserTerrain(u3, t1, true, message, date);

		userTerrainRepos.save(usert1);
		userTerrainRepos.save(usert2);
		userTerrainRepos.save(usert3);
		userTerrainRepos.save(usert4);
		userTerrainRepos.save(usert5);
		
		GroupConv gc1 = new GroupConv(u1, t1, "Wesh la famille des jardiniers", date);
		GroupConv gc2 = new GroupConv(u3, t1, "Salut salut", date);
		GroupConv gc3 = new GroupConv(u1, t1, "Bla Bla Bla", date);
		GroupConv gc4 = new GroupConv(u3, t1, "aztyzeryaztez", date);
		grConvRep.save(gc1);
		grConvRep.save(gc2);
		grConvRep.save(gc3);
		grConvRep.save(gc4);
		
		
		
		// Test image groupe
		String image = "";
		ImageGroup img = new ImageGroup("test", image.getBytes(), t1); 
	

		
		/*
		 * Admin ad1 = new Admin("vfdhygv", "hgdcfj"); Admin ad2 = new Admin("vfdhygv",
		 * "hgdcfj"); Admin ad3 = new Admin("vfdhygv", "hgdcfj"); adrepo.save(ad1);
		 * adrepo.save(ad2); adrepo.save(ad3);
		 */

	}
}
