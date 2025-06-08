package sn.seck.GestionCliniqueKissi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sn.seck.GestionCliniqueKissi.Model.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")

public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;
    @Column(name = "firstname",length = 30)
    private String firstname;
    @Column(name = "lastname",length = 150)

    private String lastname;
    @Column(name = "email",length = 250)
    private String email;
    @Column(name = "password",length = 100)
    @NotNull(message = "Password cannot be null")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToMany(mappedBy = "users")
//    private List<Token> tokens;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}

