package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Medicament;

import java.util.UUID;
@Repository
@EnableJpaRepositories
public interface MedicamentRepository extends JpaRepository<Medicament, UUID> {
}
