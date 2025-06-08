package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Medecin;
import sn.seck.GestionCliniqueKissi.Model.Ordonnance;
import sn.seck.GestionCliniqueKissi.Repository.OrdonnanceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrdonnanceService {

    private OrdonnanceRepository ordonnanceRepository;

    public OrdonnanceService(OrdonnanceRepository ordonnanceRepository) {
        this.ordonnanceRepository = ordonnanceRepository;
    }

    public List<Ordonnance> getAllOrdonnances() {
        return ordonnanceRepository.findAll();
    }

    public Optional<Ordonnance> getOrdonnanceById(UUID idordonnance) {
        return ordonnanceRepository.findById(idordonnance);
    }

    public Ordonnance createOrdonnance(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    public void deleteOrdonnance(UUID idordonnance) {
        ordonnanceRepository.deleteById(idordonnance);
    }


    public Ordonnance updateOrdonnance(UUID idordonnance, Ordonnance updated) {
        return ordonnanceRepository.findById(idordonnance).map(ordonnance -> {
            ordonnance.setIdordonnance(updated.getIdordonnance());
            ordonnance.setNumOrdonnance(updated.getNumOrdonnance());
            ordonnance.setDateOrdonnance(updated.getDateOrdonnance());
            ordonnance.setFormatOrdonnance(updated.getFormatOrdonnance());
            ordonnance.setPrix(updated.getPrix());
            ordonnance.setTotal(updated.getTotal());
            ordonnance.setMedecin(new Medecin());
            return ordonnanceRepository.save(ordonnance);
        }).orElseThrow(() -> new RuntimeException("Ordonnance not found"));
    }

}
