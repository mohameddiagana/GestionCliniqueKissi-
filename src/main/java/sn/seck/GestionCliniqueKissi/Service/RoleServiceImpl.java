//package sn.seck.GestionCliniqueKissi.Service;
//
//import jakarta.transaction.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//import sn.seck.GestionCliniqueKissi.Model.Role;
//
//import java.util.List;
//
//@Service
//@Transactional
//@CacheConfig(cacheNames = "role")
////@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//
//public class RoleServiceImpl implements RoleService{
//    private final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
//    private RoleService roleService;
//
//    public RoleServiceImpl(RoleService roleService) {
//        this.roleService = roleService;
//    }
//
//    @Override
//    public Role addNewrole(@RequestBody Role role) {
//       log.info("Add new Patient {} to the database", role.name());
//        return roleService.addNewrole(role);
//    }
//
//    @Override
//    public Role getRole(String name) {
//        log.info("geting patient{}",name);
//        return roleService.getRole(name);
//    }
//
//    @Override
//    public List<Role> lisRoles() {
//        log.info("Fetching all patient");
//        return roleService.lisRoles();
//    }
//}
