package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;

import java.util.List;
@Repository
public interface UserService {

    Users createUser(Users user);

    List<Users> listuser();

    // Met à jour les informations d'un utilisateur

//   ResponseEntity<Users> updateUser(@PathVariable int iduser, @RequestBody Users user);

    // Supprime un utilisateur
//    ResponseEntity<Void> deleteUser(int iduser);

    // Récupère un utilisateur par son ID
//    ResponseEntity<Users> getUserById(int iduser);

}
