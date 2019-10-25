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
		
		
		TypeTerrain typeT1 = new TypeTerrain("Jardin particulier");
		TypeTerrain typeT2 = new TypeTerrain("Jardin public");
		TypeTerrain typeT3 = new TypeTerrain("Balcon/Terrasse");
		TypeTerrain typeT4 = new TypeTerrain("Champs");
		typeTRep.save(typeT1);
		typeTRep.save(typeT2);
		typeTRep.save(typeT3);
		typeTRep.save(typeT4);
		
		
		
		// User u = new User(nom, prenom, mail, pw, tel, age)
		User u1 = new User("Faustin", "Kevin", "faustin@gmail.com", "Faustin10!", "0145564874", 25);
		User u2 = new User("Bériault", "Isabelle", "beriault@gmail.com", "Beriault10@", "0541100234", 56);
		User u3 = new User("Lebel", "Eugène", "lebel@wanadoo.fr", "Lelebel10!", "0350481379", 85);
		User u4 = new User("Famboise", "Diane", "diane.f@outlook.fr", "Famboise10!", "0654785201", 38);
		User u5 = new User("Bonami", "Adrien", "bonami@gmail.com", "Bonami10!", "0678974105", 41);
		User u6 = new User("Mayar", "Jeanine", "jeanine@hotmail.fr", "Jeanine10!", "0398635620", 78);
		User u7 = new User("Macron", "Emmanuel", "president@gouv.fr", "Macronpres10!", "0102030405", 42);
		userRep.save(u1);
		userRep.save(u2);
		userRep.save(u3);
		userRep.save(u4);
		userRep.save(u5);
		userRep.save(u6);
		userRep.save(u7);
		
		

		@SuppressWarnings("deprecation")
		Time time = new Time(0, 0, 1);
		@SuppressWarnings("deprecation")
		Date date = new Date(119, 00, 02);
		
		// Terrain t = new Terrain(nom, adresse, ville, postal, surface, hOuverture, hFermeture, maxUser, description, type, proprietaire)
		Terrain t1 = new Terrain("Le potager d'Eugène", "31 rue d'Alésia", "Paris", "75014", 24.5, time, time, 10, "Trop agé pour m'occuper de mon potager, je recherche des gens motivés pour aller planter des choux", typeT1, u3);
		Terrain t2 = new Terrain("Le Jardin d'Eden", "49 rue Victor Hugo", "Concarneau", "29900", 150, time, time, 5, "J'ai un grand jardin non exploité et je souhaite le mettre à profit. Rejoignez moi !", typeT1, u1);
		Terrain t3 = new Terrain("Jardiland", "39 Chemin des Bateliers", "Aix Les Bains", "73100", 70, time, time, 5, "J'ai un grand jardin non exploité et je souhaite le mettre à profit. Rejoingnez moi !", typeT1, u1);
		Terrain t4 = new Terrain("Garden", "30 Quai des Belges", "Maubeuge", "59600", 40, time, time, 5, " ", typeT1, u2);
		Terrain t5 = new Terrain("Central Park", "19 rue Bonneterie", "Montauban", "82000", 86, time, time, 5, " ", typeT1, u1);
		Terrain t6 = new Terrain("Jardin du Luxembourg", "19 rue de l'Epeule", "Rouen", "76000", 52, time, time, 5, "J'ai un grand jardin non exploité et je souhaite le mettre à profit. Rejoingnez moi !", typeT1, u2);
		Terrain t7 = new Terrain("Jardin de l'Elysée", "55 Rue du Faubourg Saint-Honoré", "Paris", "75008", 10000, time, time, 5, "Trop occupé par ma vie professionnelle, je ne peux m'occuper de mon jardin", typeT1, u7);
		terrRep.save(t1);
		terrRep.save(t2);
		terrRep.save(t3);
		terrRep.save(t4);
		terrRep.save(t5);
		terrRep.save(t6);
		terrRep.save(t7);

		
		String message = "Bonjour, j'aimerais ramasser vos concombres";

		UserTerrain usert1 = new UserTerrain(u1, t1, true, message, date);
		UserTerrain usert2 = new UserTerrain(u2, t1, true, message, date);
		UserTerrain usert4 = new UserTerrain(u7, t1, false, message, date);
		UserTerrain usert3 = new UserTerrain(u3, t2, false, message, date);
		userTerrainRepos.save(usert1);
		userTerrainRepos.save(usert2);
		userTerrainRepos.save(usert3);
		
		
		GroupConv gc1 = new GroupConv(u3, t1, "Merci d'avoir rejoint mon potager", date);
		GroupConv gc2 = new GroupConv(u2, t1, "Comment allez-vous ?", date);
		GroupConv gc3 = new GroupConv(u3, t1, "Etes vous disponible ce week end ?", date);
		grConvRep.save(gc1);
		grConvRep.save(gc2);
		grConvRep.save(gc3); 
	
		
		 

	

		
		/*
		 * Admin ad1 = new Admin("vfdhygv", "hgdcfj"); Admin ad2 = new Admin("vfdhygv",
		 * "hgdcfj"); Admin ad3 = new Admin("vfdhygv", "hgdcfj"); adrepo.save(ad1);
		 * adrepo.save(ad2); adrepo.save(ad3);
		 */

	}
}
