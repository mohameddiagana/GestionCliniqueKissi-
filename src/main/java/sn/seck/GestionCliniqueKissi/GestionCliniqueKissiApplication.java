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
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Service.AuthenticationService;
import sn.seck.GestionCliniqueKissi.Service.PatientService;
import sn.seck.GestionCliniqueKissi.Service.UserService;
import sn.seck.GestionCliniqueKissi.auth.RegisterRequest;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication()
@CrossOrigin(origins = "*")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"sn.seck.GestionCliniqueKissi.Service"})
@EnableJpaRepositories(value = "sn.seck.GestionCliniqueKissi.Repository")

@ComponentScan(basePackages = "sn.seck.GestionCliniqueKissi.Model.Users")
@OpenAPIDefinition
public class GestionCliniqueKissiApplication {
		private UserService userService;
		private PatientService patientService;


	public GestionCliniqueKissiApplication(UserService userService, PatientService patientService) {
		this.userService = userService;
		this.patientService = patientService;
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


			userService.addNewUser(new Users( 1,"moha","diagana","mdiaganaisidk@gmail.com","1234", Role.ADMIN ));
	userService.addNewUser(new Users( 2,"mohamed bocar","samba","assisi@gmail.sn","passer123", Role.User ));
	userService.addNewUser(new Users( 4,"da bocar","cheikh","admin@gmail.sn","123", Role.ADMIN ));
			patientService.addNewPatient(new Patient(2, "c124", "dahaba", "tandia ablaye", "dbtandia@gmail.com", "772512985", "homme",
					LocalDate.now(), "sahm", "developpeur", 861254587, 20));

			patientService.addNewPatient(new Patient(3, "c552","lala","tandia la","daha@gmail.com","772565225","femme",
					LocalDate.now(),"police4","commercante",877878444,60));
//
			patientService.addNewPatient(new Patient(4, "c500","dada","daba tal",
					"taldab@gmail.com","781454748","femme",
					LocalDate.now(),"diourbelle","developpeuse",548852418,56));


			patientService.addNewPatient(new Patient(5, "c521"," ba","yacoub",
					"mame@gmail.com","782156844","femme",
					LocalDate.now(),"castor","agriculeur",128621125,80));

			patientService.addNewPatient(new Patient(6, "c51"," dddbaa","sarr",
					"mae@gmail.com","458872593","male",
					LocalDate.now(),"castor","culte",201104786,23));





		};

}
}



