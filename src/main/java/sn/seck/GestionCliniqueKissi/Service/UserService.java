package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.stereotype.Repository;
import sn.seck.GestionCliniqueKissi.Model.Role;
import sn.seck.GestionCliniqueKissi.Model.Users;

import java.util.List;
@Repository
public interface UserService {

    Users createUser(Users user);

    List<Users> listuser();
    //Role addNewRole(Role role);
    //Role findRoleBYRoleName(String roleName);
   // void addRoleToUser(String roleName, String user);
   //List<Role> listRole();

}
