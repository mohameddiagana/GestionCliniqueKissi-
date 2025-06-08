package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.seck.GestionCliniqueKissi.Model.Patient;

@Repository
@CrossOrigin("*")/*PERMIT D'ACCEPTER LES REQUETE*/
public interface PatientRepository extends JpaRepository<Patient,Integer> {
  @Query(value = "SELECT p FROM Patient p WHERE p.nomp =:nomp",nativeQuery = true)
     Patient findByPatient(@Param("nomp")String nomp);
}
