package sn.seck.GestionCliniqueKissi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sn.seck.GestionCliniqueKissi.Model.*;
import sn.seck.GestionCliniqueKissi.Repository.*;
import sn.seck.GestionCliniqueKissi.Service.PatientService;
import sn.seck.GestionCliniqueKissi.Service.UserService;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication()
@EnableWebMvc
@ComponentScan(basePackages = {"sn.seck.GestionCliniqueKissi.Service"})
@EnableJpaRepositories("sn.seck.GestionCliniqueKissi.Repository")
//@EnableTransactionManagement
@EntityScan(basePackages={"sn.seck.GestionCliniqueKissi.Model"})

@ComponentScan(basePackages = {"sn.seck.GestionCliniqueKissi.Model"})
@OpenAPIDefinition
//@ActiveProfiles("test")
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

		userService.createUser(new Users(1, "moha", "diagana", "mdiaganaisidk@gmail.com", "1234", Role.ADMIN));
		userService.createUser(new Users(2, "mohamed bocar", "samba", "assisi@gmail.sn", "passer123", Role.User));
		userService.createUser(new Users(4, "da bocar", "cheikh", "admin@gmail.sn", "123", Role.ADMIN));
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
					consu.setIdconsultation(1);
					consu.setCodecons("c0025");
					consu.setDateconsultation(new Date());
					consu.setRapport("le Rapport de la semaine est.......:"+ consu.getRapport());
					//consu.setPrixconsultation(150000);
					consultationRepository.save(consu);

				});


	};
		};

}





