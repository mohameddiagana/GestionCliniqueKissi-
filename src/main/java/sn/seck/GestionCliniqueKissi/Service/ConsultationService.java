package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Consultation;
import sn.seck.GestionCliniqueKissi.Repository.ConsultationRepository;

import java.util.List;

@Service
public class ConsultationService {

    private ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));
    }

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
    /**
     * UNE METHODE PERMETTANT DE SUPPRIMER ID-CONSULTATION
     * */
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }
}
