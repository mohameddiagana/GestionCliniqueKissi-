package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Medicament;
import sn.seck.GestionCliniqueKissi.Repository.MedicamentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    public MedicamentService(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    public List<Medicament> getAllMedicaments() {
        return medicamentRepository.findAll();
    }

    public Optional<Medicament> getMedicamentById(UUID id) {
        return medicamentRepository.findById(id);
    }

    public Medicament saveMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    public void deleteMedicament(UUID id) {
        medicamentRepository.deleteById(id);
    }

    public Medicament updateMedicament(UUID id, Medicament medicamentDetails) {
        return medicamentRepository.findById(id).map(medicament -> {
            medicament.setIdmed(medicamentDetails.getIdmed());
            medicament.setLibelle_medicament(medicamentDetails.getLibelle_medicament());
            medicament.setQuantite_medicament(medicamentDetails.getQuantite_medicament());
            return medicamentRepository.save(medicament);
        }).orElseThrow(() -> new RuntimeException("Medicament non trouvé"));
    }


}
