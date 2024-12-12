package sn.seck.GestionCliniqueKissi.auth;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class AuthenticationResponse {

    private String token;
}
