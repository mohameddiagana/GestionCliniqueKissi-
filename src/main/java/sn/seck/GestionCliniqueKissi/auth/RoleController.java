//
//package sn.seck.GestionCliniqueKissi.auth;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import sn.seck.GestionCliniqueKissi.Model.Role;
//import sn.seck.GestionCliniqueKissi.Repository.RoleRepository;
//
//import java.util.List;
//
//@RestController
//@Slf4j
//@RequestMapping("/api/v1/auth/")
//@CrossOrigin("http://localhost:8080/api/v1/auth/role/liste")
//
//public class RoleController {
//    @Autowired(required = false)
//    private RoleRepository rolerepository;
//
//    public RoleController(RoleRepository rolerepository) {
//        this.rolerepository = rolerepository;
//    }
//
//    @RequestMapping(value = "/role/liste")
//    public String liste(Model model) {
//        List<Role> role = rolerepository.findAll();
//        log.info("fetching all users!");
//        model.addAttribute("list_roles", rolerepository.findAll());//Pour la liste
//        model.addAttribute("role", role);
//        return "redirect:/api/v1/auth/role/liste";
//    }
//
//    @GetMapping(value = "/role/delete")
//    public ResponseEntity <Void>deleterole(@PathVariable String name) {
//        rolerepository.delete(rolerepository.getByName(name));
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }
//    @RequestMapping(value = "/role/add")
//    public ResponseEntity<Role> addNewrole(@RequestBody Role role){
//        Role newRole = rolerepository.save(role);
//        log.info("add role in database{}",role.name());
//        return new ResponseEntity<Role>(newRole, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/role/{id}")
//    public ResponseEntity<Role> getRole(@PathVariable String name) {
//        Role role = rolerepository.getByName(name);
//        return new ResponseEntity<Role>(role, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/role/edit",method = RequestMethod.GET)
//    public String edit(ModelMap model, String name) {
//
//        List<Role> roles = rolerepository.findAll();
//        log.info("Edit the role");
//        model.put("list_roles", roles);
//        Role rls = rolerepository.getByName(name);
//        model.put("role", rls);
//        return "redirect:/api/v1/auth/role/liste";
//
//    }
//
//}
//
