package sn.seck.GestionCliniqueKissi.auth;

import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Model.Rendezvous;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;
import sn.seck.GestionCliniqueKissi.Repository.RendezvousRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200") // autoriser le frontend Angular
@Slf4j
@Controller
@RequestMapping(path = "/api/v1/auth/patient/liste")
public class PatientController {
    //@Autowired
    private PatientRepository patientRepository;
    private RendezvousRepository rendezvousRepository;

    public PatientController(PatientRepository patientRepository, RendezvousRepository rendezvousRepository) {
        this.patientRepository = patientRepository;

        this.rendezvousRepository = rendezvousRepository;
    }


    @GetMapping(value = "/patient/liste")
    public String getPatientList(ModelMap map) {
        List<Patient> getPatientList = patientRepository.findAll( );
        log.info("Fetching all patients");
        //log.debug("debug all patients");
        map.addAttribute("list_patients", patientRepository.findAll( ));//Pour la liste
       // map.addAttribute("list_rendezvous", rendezvousRepository.findAll( ));//Pour la liste
        map.addAttribute("Patient", new Patient( ));//Pour le formulaire
      return "/api/v1/auth/patient/liste";
//      return getPatientList.toString();
      
 }

    @DeleteMapping(value = "/patient/delete")
    public String deletepatient( int idpatient) {
        try {
            patientRepository.delete(patientRepository.getById(idpatient));
            log.info("DELETE THE PATIENT !");

        } catch (Exception ex) {
            ex.printStackTrace( );
        }
        return "redirect:/api/v1/auth/patient/liste";

    }
    @RequestMapping(value = "/patient/add",method = RequestMethod.POST)

    public String NouveauPatient(int idpatient, int codep, String nomp, String prenom, String adresse, String email, String tel, String sexe, LocalDate datenaissance, String profession, int CIN, int age,String rendezvous) {//ajout et mise à jour
        log.info("Saving New Patient in database{}", patientRepository.findByPatient(nomp));
        Patient patient = new Patient( );
        patient.setIdpatient(idpatient);
        patient.setCodep(codep);
        patient.setNomp(nomp);
        patient.setPrenom(prenom);
        patient.setEmail(email);
        patient.setTel(tel);
        patient.setSexe(sexe);
        Rendezvous rv = new Rendezvous();
       patient.setRendezvous(new ArrayList<Rendezvous>());
       patient.setConsultations(new ArrayList<>());
        patient.setDatenaissance(datenaissance);
        patient.setAdresse(adresse);
        patient.setProfession(profession);
        patient.setCIN(CIN);
        patient.setAge(age);
        try {
            patientRepository.saveAndFlush(patient);
            rendezvousRepository.saveAndFlush(rv);
        } catch (Exception ex) {
            ex.printStackTrace( );

        }
        return "redirect:/api/v1/auth/patient/liste";

    }

    @RequestMapping(value = "/patient/edit",method = RequestMethod.GET)
    public String setEdit(ModelMap model, int idpatient) {
        try {
           List<Patient>patientList = patientRepository.findAll();
            log.info("EDIT THE PATIENT !!!");
            model.put("list_patients", patientList);
            Patient patient = patientRepository.getOne(idpatient);
            model.put("patient", patient);

        } catch (Exception ex) {
            ex.printStackTrace( );

        }
        return "redirect:/api/v1/auth/patient/liste";

    }
    @PutMapping(path = "/patient/update")
    public String updatePatient(@PathVariable int idpatient, @RequestBody Patient patient){
        log.info("UPDATE THE NEW PATIENT !!!");
        patient.setIdpatient(idpatient);
        return "redirect:/api/v1/auth/patient/liste"; /* RETOUR A LA LISTE*/
    }
}