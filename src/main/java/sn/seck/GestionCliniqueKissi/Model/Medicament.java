package sn.seck.GestionCliniqueKissi.Model;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@ToString
@Builder

@Table(name = "medicament")

@AllArgsConstructor @NoArgsConstructor

public class Medicament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@JsonIgnore
    private UUID idmed;

    @Column(nullable = false,name = "libelle_medicament",length = 30)
    private String libelle_medicament;

    @Column(nullable = false,name = "quantite_medicament",length = 10)
    private int quantite_medicament;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

}
