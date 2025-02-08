package sn.seck.GestionCliniqueKissi.Service;

import jakarta.transaction.Transactional;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Profile;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Repository.UserRepository;

import java.util.List;
@Service
@Transactional
@Slf4j
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {
//    @Autowired
    private UserRepository userRepository;
   // @Autowired
    private PasswordEncoder passwordEncoder;

    private UserService userService;




    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    @PostMapping("/users")
    @Profile("ADMIN")
    public Users createUser(@Valid @RequestBody Users user) {
        String pwdd = user.getPassword();
        user.setPassword(passwordEncoder.encode(pwdd));
        log.info("Saving new user {} to the database", user.getFirstname());
        return userRepository.save(user);
    }
    @Override
    public List<Users> listuser() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

//    @Override
//    @PutMapping("/{iduser}")
//    public ResponseEntity<Users> updateUser(@PathVariable int iduser, @RequestBody Users user) {
//        Users updateUser = userService.updateUser(iduser, user).getBody();
//        log.info("update username !!");
//        return ResponseEntity.ok(updateUser);
//    }

//    @Override
//    @DeleteMapping("/{iduser}")
//    public ResponseEntity<Void> deleteUser(int iduser) {
//        userService.deleteUser(iduser);
//        log.info("delete id user !!");
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

//    @Override
//    @GetMapping("/{iduser}")
//    public ResponseEntity<Users> getUserById(@PathVariable int iduser) {
//        Users user = userService.getUserById(iduser).getBody();
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
    }



