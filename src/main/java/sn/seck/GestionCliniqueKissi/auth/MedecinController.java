package sn.seck.GestionCliniqueKissi.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Medecin;
import sn.seck.GestionCliniqueKissi.Service.MedecinService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/auth/medecins")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class MedecinController {
    @Autowired
    private  MedecinService medecinService;

    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }
    /*
    Lise des Medecins dans la base
    **/
    @GetMapping
    public List<Medecin> listMedecin() {
        log.info("listMedecin{} in the database", medecinService.listMedecin());
        return medecinService.listMedecin();

    }
    /**
     * Ajout du medecin
     * */
    @PostMapping
    @ResponseBody
    public Medecin addNewMedecin(@RequestBody Medecin medecin) {
        log.info("addNewMedecin {} in the database", medecin);
        return medecinService.addNewMedecin(medecin);
    }
    /**
     * Recuperation du Medecin via son identifiant
     * */
    @GetMapping("/{id}")
    public Optional<Medecin> getMedecinById(@PathVariable Long id) {
        log.info("getMedecinById {} in the database", id);
        return medecinService.getMedecinById(id);
    }
    /**
     * suppression Id MEdein
     * */

    @DeleteMapping("/{id}")
    public void deleteMedecin(@PathVariable Long id) {
        log.info("deleteMedecin {} in the database", id);
        medecinService.deleteMedecinById(id);
    }
}
