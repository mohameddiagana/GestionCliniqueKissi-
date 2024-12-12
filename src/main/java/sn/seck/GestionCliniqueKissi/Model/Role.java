package sn.seck.GestionCliniqueKissi.Model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;


//@RequiredArgsConstructor

public enum Role {
    User,
    ADMIN,
    MANAGER,
    COMPTABLE,
    IT,
    DEVELOPPEUR
//    USER(Collections.emptySet()) ,
//    ADMIN(
//            Set.of(
//                    ADMIN_READ,
//                    ADMIN_DELETE,
//                    ADMIN_CREATE,
//                    ADMIN_UPDATE,
//
//                    MANAGER_READ,
//                    MANAGER_CREATE,
//                    MANAGER_DELETE,
//                    MANAGER_UPDATE
//
//
//            )
//    ),
//   MANAGER(
//           (
//                   Set.of(
//
//                           MANAGER_READ,
//                           MANAGER_CREATE,
//                           MANAGER_DELETE,
//                           MANAGER_UPDATE
//
//                   )
//           )
//   )
//           ;
//
//    @Getter
//    private final Set<Permission> permissions;
//    public List<SimpleGrantedAuthority> authorities(){
//        var authorities =  getPermissions()
//                .stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.name()))
//                .collect(Collectors.toList());
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
//        return  authorities;
//
//
//    }
//private final String displayName;
//
//    Role(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
}

