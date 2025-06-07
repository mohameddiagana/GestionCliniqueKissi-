package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Hospitalisation;
import sn.seck.GestionCliniqueKissi.Repository.HospitalisationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalisationService {

    //@Autowired
    private HospitalisationRepository hospitalisationRepository;

    public HospitalisationService(HospitalisationRepository hospitalisationRepository) {
        this.hospitalisationRepository = hospitalisationRepository;
    }

    public List<Hospitalisation> getAllHospitalisations() {
        return hospitalisationRepository.findAll();
    }

    public Optional<Hospitalisation> getHospitalisationById(Long id_hospitalisation) {
        return hospitalisationRepository.findById(id_hospitalisation);
    }

    public Hospitalisation addHospitalisation(Hospitalisation hospitalisation) {
        return hospitalisationRepository.save(hospitalisation);
    }

    public Hospitalisation updateHospitalisation(Long id_hospitalisation, Hospitalisation hospitalisationDetails) {
        Optional<Hospitalisation> hospitalisationationOptional = hospitalisationRepository.findById(id_hospitalisation);

        if (hospitalisationationOptional.isPresent()) {
            Hospitalisation hospitalisation = hospitalisationationOptional.get();
            hospitalisation.setId_hospitalisation(id_hospitalisation);
            hospitalisation.setCode_hospitalisation("AMC");
            hospitalisation.setLibelle_hospitalisation("Actes de kinésithérapie en établissement");
            hospitalisation.setDate_entree(new Date());
            hospitalisation.setTypeHospitalisation("Hospitalisation complet");
            hospitalisation.setDate_sortie(LocalDate.now());
            hospitalisation.setMotif_hospitalisation(hospitalisationDetails.getMotif_hospitalisation());
           // hospitalisation.setDate_sortie(());
            return hospitalisationRepository.save(hospitalisation);
        } else {
            throw new RuntimeException("Hospitalisation not found with id " + id_hospitalisation);
        }
    }

    public void deleteHospitalization(Long id_hospitalisation) {
        hospitalisationRepository.deleteById(id_hospitalisation);
    }
}

