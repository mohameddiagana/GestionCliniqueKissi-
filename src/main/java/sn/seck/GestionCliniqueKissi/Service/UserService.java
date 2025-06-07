package sn.seck.GestionCliniqueKissi.Service;
import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Users;

import java.util.List;
@Service
public interface UserService {
        Users getUserById(int iduser);
        List<Users> getAllUsers();
        Users save(Users user);
        void deleteUserByid(int iduser);




}
