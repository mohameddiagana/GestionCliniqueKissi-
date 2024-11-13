package sn.seck.GestionCliniqueKissi.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "medecin")
public class Medecin {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "codemed",length = 200)
    private String codemed;
    @Column(name = "firstname",length = 200)
    private String firstname;
    @Column(name = "lastname",length = 200)
    private String lastname;
    @Column(name = "email" , length = 250)
    private String email;
    @Column(name = "tele",length = 200)
    private String tele;
    @Column(name ="sexe", length = 200)
    private String sexe;

    @OneToMany(mappedBy = "medecin",fetch = FetchType.LAZY)
    private List<Rendezvous> rendezvous ;

}
