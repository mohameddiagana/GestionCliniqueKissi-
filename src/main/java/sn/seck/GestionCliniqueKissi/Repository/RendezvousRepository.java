package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Rendezvous;

@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous,Integer> {

    @Query(value = "SELECT r FROM Rendezvous r WHERE r.coderdv =:coderdv")
    Rendezvous findByCoderdv(@Param("coderdv")String coderdv);
}
