package sn.seck.GestionCliniqueKissi.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Consultation;
import sn.seck.GestionCliniqueKissi.Service.ConsultationService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/auth/consultations")
@CrossOrigin(origins = "http://localhost:4200")

/**
 * Recuperaton URL de front
 * */
public class ConsultationController {

//    @Autowired
    private ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping
    public List<Consultation> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable Long id) {
        return consultationService.getConsultationById(id);
    }

    @PostMapping
    @ResponseBody
    public Consultation saveConsultation(@RequestBody Consultation consultation) {
        return consultationService.saveConsultation(consultation);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
    }
}
