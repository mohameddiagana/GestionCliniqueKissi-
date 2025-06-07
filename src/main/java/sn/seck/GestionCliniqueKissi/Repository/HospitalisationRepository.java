package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Hospitalisation;

@Repository
//@EnableJpaRepositories

public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long> {

}
