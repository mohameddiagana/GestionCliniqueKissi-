package sn.seck.GestionCliniqueKissi.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Ordonnance;
import sn.seck.GestionCliniqueKissi.Service.OrdonnanceService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/auth/ordonnances")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdonnanceController {

    private  OrdonnanceService ordonnanceService;

    public OrdonnanceController(OrdonnanceService ordonnanceService) {
        this.ordonnanceService = ordonnanceService;
    }

    @GetMapping
    public List<Ordonnance> getAll() {
        return ordonnanceService.getAllOrdonnances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordonnance> getById(@PathVariable UUID idordonnance) {
        return ordonnanceService.getOrdonnanceById(idordonnance)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ordonnance create(@RequestBody Ordonnance ordonnance) {
        return ordonnanceService.createOrdonnance(ordonnance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ordonnance> update(@PathVariable UUID idordonnance, @RequestBody Ordonnance updated) {
        try {
            return ResponseEntity.ok(ordonnanceService.updateOrdonnance(idordonnance, updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID idordonnance) {
        ordonnanceService.deleteOrdonnance(idordonnance);
        return ResponseEntity.noContent().build();
    }

    public double calculerTotalOrdonnance(List<Ordonnance> ordonnances) {
        return ordonnances.stream()
                .mapToDouble(Ordonnance::calculerTotal)
                .sum();
    }

}
