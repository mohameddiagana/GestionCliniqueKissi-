package sn.seck.GestionCliniqueKissi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sn.seck.GestionCliniqueKissi.Model.*;
import sn.seck.GestionCliniqueKissi.Repository.ConsultationRepository;
import sn.seck.GestionCliniqueKissi.Repository.MedecinRepository;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;
import sn.seck.GestionCliniqueKissi.Repository.RendezvousRepository;
import sn.seck.GestionCliniqueKissi.Service.AuthenticationService;
import sn.seck.GestionCliniqueKissi.Service.PatientService;
import sn.seck.GestionCliniqueKissi.Service.UserService;
import sn.seck.GestionCliniqueKissi.auth.RegisterRequest;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication()
@CrossOrigin(origins = "*")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"sn.seck.GestionCliniqueKissi.Service"})
@EnableJpaRepositories(value = "sn.seck.GestionCliniqueKissi.Repository")

@ComponentScan(basePackages = "sn.seck.GestionCliniqueKissi.Model")
@OpenAPIDefinition
public class GestionCliniqueKissiApplication {

		private UserService userService;
		private PatientService patientService;
		private MedecinRepository medecinRepository;
		private RendezvousRepository rendezvousRepository;
		private ConsultationRepository consultationRepository;
		private PatientRepository patientRepository;

	public GestionCliniqueKissiApplication(MedecinRepository medecinRepository,
                                           UserService userService,
                                           PatientService patientService, RendezvousRepository rendezvousRepository, ConsultationRepository consultationRepository, PatientRepository patientRepository) {
		this.userService = userService;
		this.patientService = patientService;
		this.medecinRepository = medecinRepository;

        this.rendezvousRepository = rendezvousRepository;
        this.consultationRepository = consultationRepository;
        this.patientRepository = patientRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(GestionCliniqueKissiApplication.class, args);
	}

	@Bean
	CommandLineRunner start( ) {

		return args -> {

			/*LocalDate date = LocalDate.now();
			// Formater la date dans un format spécifique
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dateFormatted = date.format(formatter);

			// Afficher la date dans le terminale
			System.out.println("La date d'aujourd'hui est: " + dateFormatted);

			 */
			Patient patient = Patient.builder()
						.idpatient(1)
					.codep(2002)
					.nomp("diagana")
					.prenom("MOHAmed bocar")
					.email("md@gmail.com")
					.tel("784152522")
					.sexe("Homme")
					.datenaissance(LocalDate.now())
					.adresse("sahm")
					.profession("devops")
					.CIN(545122412)
					.age(58)
					.rendezvous(new ArrayList<Rendezvous>())
					.build();


			patientRepository.saveAndFlush(patient);





		userService.addNewUser(new Users(1, "moha", "diagana", "mdiaganaisidk@gmail.com", "1234", Role.ADMIN));
		userService.addNewUser(new Users(2, "mohamed bocar", "samba", "assisi@gmail.sn", "passer123", Role.User));
		userService.addNewUser(new Users(4, "da bocar", "cheikh", "admin@gmail.sn", "123", Role.ADMIN));
		/*Liste des Medecins*/
		Stream.of("Bocar", "zeyade", "BRAHIME", "youssouf")
				.forEach(name -> {
					Medecin medecin = new Medecin();
					medecin.setId(1);
					medecin.setCodemed("m002");
					medecin.setFirstname("Bocar Bnnff");
					medecin.setLastname("DIagana ");
					medecin.setEmail("mddiag@gmail.com");
					medecin.setTele("777885825");
					medecin.setSexe("Homme");
					Rendezvous rendezvous1 = new Rendezvous();
                    medecin.setRendezvous(Collections.singletonList(rendezvous1));
					medecinRepository.saveAndFlush(medecin);

					/*Liste des Rendezvous*/
					//medecin.speciali(Math.random()>0.5?"DENTAIRE":"CARDIO") UUID
					Rendezvous rendezvous = new Rendezvous();
					rendezvous.setId(1);
					rendezvous.setCoderdv("c002");
					rendezvous.setDaterdv(new Date());
					rendezvous.setTyperdv("Consultation");
					rendezvous.setHeurerdv(new Date());
					rendezvous.setMedecin(medecin);
					rendezvous.setPatient(new Patient());
					rendezvousRepository.save(rendezvous);

					//Rendezvous rendezvous1 = rendezvousRepository.findById(1).orElse(null);

					Consultation consu = new Consultation();
					consu.setId(1);
					consu.setCodecons("c0025");
					consu.setDateconsultation(new Date());
					consu.setRapport("le Rapport de la semaine est.......:"+ consu.getRapport());
					consultationRepository.save(consu);
				});


	};
		};

}





