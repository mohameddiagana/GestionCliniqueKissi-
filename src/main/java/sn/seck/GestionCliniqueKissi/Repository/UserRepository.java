package sn.seck.GestionCliniqueKissi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.seck.GestionCliniqueKissi.Model.Users;

import java.util.Optional;
@Repository
//@CrossOrigin( "*")
public interface UserRepository extends JpaRepository<Users,Integer> {
    Optional<Users>findByEmail(String email);
}
