package sn.seck.GestionCliniqueKissi.auth;

import lombok.*;
import sn.seck.GestionCliniqueKissi.Model.Role;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private Role role;


}
