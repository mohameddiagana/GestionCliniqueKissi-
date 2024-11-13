package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    @Query(value = "SELECT m FROM Medecin m WHERE m.Codemed =:Codemed", nativeQuery = true)
    Medecin findByCodemed(@Param("Codemed") String Codemed);
}
