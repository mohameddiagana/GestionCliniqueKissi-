package sn.seck.GestionCliniqueKissi.auth;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "localhost:7075/api/v1/auth/")
@Slf4j
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Créer un nouvel utilisateur avec un rôle spécifique
    @PostMapping("/users")
    public Users createUser(@Valid @RequestBody Users user) {
        log.info("create user {}", user);
        return userRepository.save(user);

    }

    // Modifier le rôle d'un utilisateur
    @PutMapping("/users/{id}")
    public Users updateUserRole(@PathVariable int id, @RequestBody Role newRole) {
        Optional<Users> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            Users user = userOpt.get();
            user.setRole(newRole);
            return userRepository.save(user);
        }
        return null;  // ou gestion d'erreur
    }

}
