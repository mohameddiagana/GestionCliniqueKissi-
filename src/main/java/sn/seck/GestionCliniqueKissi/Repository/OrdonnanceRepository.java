package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Ordonnance;

import java.util.UUID;
@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, UUID> {
}
