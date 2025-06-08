package sn.seck.GestionCliniqueKissi.auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200") // autoriser le frontend Angular
@Controller
@RequestMapping(path = "/api/v1/auth/users")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, BCryptPasswordEncoder passwordEncoder1) {
        this.userRepository = userRepository;
    }

    // Créer un nouvel utilisateur
    @PostMapping("/users")
    public Users save(@RequestBody Users user) {
        log.info("save user",user.getFirstname(),user.getLastname());
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

    @GetMapping("/{iduser}")
    public Optional<Users> getUserById(@PathVariable int iduser) {
        log.info("getUser {} in the database", iduser);
        return userRepository.findById(iduser);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        log.info("listUsers{} in the database", userRepository.findAll());
        return userRepository.findAll();

    }
    public void deleteUserByid(int iduser) {
        log.info("Delete Id user {} from the database", iduser);
      userRepository.deleteById(iduser);


    }
}
