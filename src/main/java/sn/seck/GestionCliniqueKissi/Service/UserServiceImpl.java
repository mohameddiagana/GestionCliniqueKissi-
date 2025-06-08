package sn.seck.GestionCliniqueKissi.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sn.seck.GestionCliniqueKissi.Model.Users;
import sn.seck.GestionCliniqueKissi.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@CacheConfig(cacheNames = "users")
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Service
@Data
@Getter
@Setter
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl( UserRepository userRepository) {
//
        this.userRepository = userRepository;
    }

    /**
     * CORRECTION findbyid
     */
    @Override
    public Users getUserById(int iduser) {
        log.info(new StringBuffer().append("getUserById").toString());
        return userRepository.getById(iduser);/*.orElseThrow(() -> new RuntimeException("User not found"));*/

        /**CORRECTION findbyid */
    }

    @Override
    public List<Users> getAllUsers() {
        log.info("Get all users");
        return userRepository.findAll();
    }

    @Override
    @PostMapping("/users")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Users save(@RequestBody Users user) {
        if(!user.getEmail().contains("@")){

            throw new RuntimeException("votre mail est invalide !!!");
        }
        if(!user.getEmail().contains(".")){

            throw new RuntimeException("votre mail est invalide !!!");
        }

        Optional<Users> userOpt = this.userRepository.findByEmail(user.getEmail());
    /**
     * Verfier si l'utilisateur  est present dans la base
     * */
        if(userOpt.isPresent()){
            throw new RuntimeException("votre mail est deja utilise !!!");
        }
        String mdpCrypt = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(mdpCrypt);
        log.info("Saving new user {} to the database, And To Cryptage mdp",user.getFirstname());
        return userRepository.save(user);


    }

    @Override
    public void deleteUserByid(int iduser) {
        log.info("Delete Id user {} from the database", iduser);
        userRepository.deleteById(iduser);

    }

    }



