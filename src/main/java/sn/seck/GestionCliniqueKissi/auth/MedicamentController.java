package sn.seck.GestionCliniqueKissi.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Medicament;
import sn.seck.GestionCliniqueKissi.Service.MedicamentService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/auth/medicaments")
@CrossOrigin(originPatterns = "http://localhost:4200")
@Slf4j
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;

    @GetMapping
    public List<Medicament> getAllMedicaments() {
        log.info("getAllMedicaments");
        return medicamentService.getAllMedicaments();
    }

    @GetMapping("/{id}")
    public Medicament getMedicamentById(@PathVariable UUID id) {
        log.info("getMedicamentById",medicamentService.getMedicamentById(id));
        return medicamentService.getMedicamentById(id)
                .orElseThrow(() -> new RuntimeException("Medicament non trouvé"));
    }

    @PostMapping
    @ResponseBody
    public Medicament createMedicament(@RequestBody Medicament medicament) {
        log.info("createMedicament",medicament);
        return medicamentService.saveMedicament(medicament);
    }

    @PutMapping("/{id}")
    public Medicament updateMedicament(@PathVariable UUID id, @RequestBody Medicament medicament) {
        log.info("updateMedicament",medicament);
        return medicamentService.updateMedicament(id, medicament);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicament(@PathVariable UUID id) {
        log.info("deleteMedicament",id);
        medicamentService.deleteMedicament(id);
    }
}


