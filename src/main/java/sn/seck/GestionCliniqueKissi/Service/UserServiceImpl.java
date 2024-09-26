package sn.seck.GestionCliniqueKissi.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users addNewUser(@RequestBody Users user) {
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


}
