package sn.seck.GestionCliniqueKissi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sn.seck.GestionCliniqueKissi.Model.*;
import sn.seck.GestionCliniqueKissi.Repository.*;
import sn.seck.GestionCliniqueKissi.Service.HospitalisationService;
import sn.seck.GestionCliniqueKissi.Service.PatientService;
import sn.seck.GestionCliniqueKissi.Service.UserService;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;



@SpringBootApplication()
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableWebMvc
@ComponentScan(basePackages = {"sn.seck.GestionCliniqueKissi.Service"})
@EnableJpaRepositories("sn.seck.GestionCliniqueKissi.Repository")
@EntityScan(basePackages={"sn.seck.GestionCliniqueKissi.Model"})

@ComponentScan(basePackages = {"sn.seck.GestionCliniqueKissi.Model"})
@OpenAPIDefinition

public class GestionCliniqueKissiApplication {

	private static final Logger logger = LoggerFactory.getLogger(GestionCliniqueKissiApplication.class);
		private UserRepository userRepository;

		private PatientService patientService;
		private  MedecinRepository medecinRepository;
		private RendezvousRepository rendezvousRepository;
		private ConsultationRepository consultationRepository;
		private PatientRepository patientRepository;
//		private HospitalisationService hospitalisationService;
	private MedicamentRepository medicamentRepository;
	private OrdonnanceRepository ordonnanceRepository;

	private HospitalisationRepository hospitalisationRepository;
	public GestionCliniqueKissiApplication(MedecinRepository medecinRepository,
                                           UserRepository userRepository,
                                           PatientService patientService, RendezvousRepository rendezvousRepository, ConsultationRepository consultationRepository, PatientRepository patientRepository, HospitalisationService hospitalisationService, MedicamentRepository medicamentRepository, OrdonnanceRepository ordonnanceRepository, HospitalisationRepository hospitalisationRepository) {
        this.userRepository = userRepository;
		this.patientService = patientService;
		this.medecinRepository = medecinRepository;

        this.rendezvousRepository = rendezvousRepository;
        this.consultationRepository = consultationRepository;
        this.patientRepository = patientRepository;
        this.medicamentRepository = medicamentRepository;
        this.ordonnanceRepository = ordonnanceRepository;
//        this.hospitalisationService = hospitalisationService;
        this.hospitalisationRepository = hospitalisationRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(GestionCliniqueKissiApplication.class, args);
	}

	@Bean
	CommandLineRunner start( ) {

		return args -> {

			LocalDate date = LocalDate.now();
			// Formater la date dans un format spécifique
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dateFormatted = date.format(formatter);

			// Afficher la date dans le terminale
			System.out.println("La date d'aujourd'hui est: " + dateFormatted);


			Patient patient = new Patient();
			patient.setIdpatient(1);
			patient.setCodep(223547);
			patient.setNomp("malixk");
			patient.setPrenom("diiaa");
			patient.setEmail("MOHAmed bocar");
			patient.setTel("14477858");
			patient.setSexe("Homme");
			patient.setDatenaissance(LocalDate.now());
			patient.setAdresse("karack");
			patient.setCIN(545122412);
			patient.setAge(60);
			patient.setRendezvous(new ArrayList<>());
			patient.setHospitalisationslList(new ArrayList<>());
			patient.setConsultations(new ArrayList<>());
			patientRepository.saveAndFlush(patient);

		userRepository.save(new Users(1, "moha", "diagana", "mdiaganaisidk@gmail.com", "1234", Role.ADMIN));
		userRepository.save(new Users(2, "mohamed bocar", "samba", "assisi@gmail.sn", "passer123", Role.User));
		userRepository.save(new Users(4, "da bocar", "cheikh", "admin@gmail.sn", "123", Role.ADMIN));
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
                    medecin.setRendezvous(new ArrayList<>());
					medecin.setMedicament(new ArrayList<>());
					medecin.setOrdonnances(new ArrayList<>());
					medecinRepository.save(medecin);

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
					consu.setPatient(new Patient());
					//consu.setPrixconsultation(150000);
					consultationRepository.save(consu);

					/* ADD HOSPITALISATION*/
					Hospitalisation hosp = new Hospitalisation();
					hosp.setId_hospitalisation(hosp.getId_hospitalisation());
					hosp.setCode_hospitalisation("CN");
					hosp.setLibelle_hospitalisation("consultation");
					hosp.setTypeHospitalisation("suro");
					hosp.setDate_entree(new Date());
					hosp.setDate_sortie(LocalDate.now());
					hosp.setMotif_hospitalisation("Consulation jambe");
					hosp.setPatient(new Patient());
					hospitalisationRepository.save(hosp);
					/**
					 * declaration USER*/

					Medicament med = new Medicament();
					med.setIdmed(UUID.randomUUID());
					med.setLibelle_medicament("Doliprane");
					med.setQuantite_medicament(10);
					med.setMedecin(new Medecin());

					medicamentRepository.saveAndFlush(med);

					Ordonnance ordonnance = new Ordonnance();
					ordonnance.setIdordonnance(UUID.randomUUID());
					ordonnance.setNumOrdonnance("B-5225-c12");
					ordonnance.setDateOrdonnance(new Date());
					ordonnance.setQuantite(20);
					ordonnance.setFormatOrdonnance("buvable");
					ordonnance.setPrix(200);
					ordonnance.setTotal(ordonnance.getTotal());
					ordonnance.setMedecin(new Medecin());

					ordonnanceRepository.saveAndFlush(ordonnance);

				});




	};

		};

}





