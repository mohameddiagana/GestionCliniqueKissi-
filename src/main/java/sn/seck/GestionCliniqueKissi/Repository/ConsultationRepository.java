package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Consultation;


@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    Consultation findByCodecons(String Codecons);
}
