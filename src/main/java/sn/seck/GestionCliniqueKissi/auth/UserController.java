package sn.seck.GestionCliniqueKissi.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "localhost:7075/api/v1/auth/users")
@Slf4j
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Obtenir tous les utilisateurs
    @GetMapping
    public List<Users> getAllUsers() {
        log.info("search all users");
        return userRepository.findAll();
    }

    // Obtenir un utilisateur par son ID
    @GetMapping("/users/{id}")
    public Optional<Users> getUserById(@PathVariable int id) {
        log.info("get by USerId");
        return userRepository.findById(id);
    }

    // Créer un nouvel utilisateur avec un rôle spécifique
    @PostMapping
    public Users createUser( @RequestBody Users user) {
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

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        log.info("delete userid");
        userRepository.deleteById(id);
    }
}
