package sn.seck.GestionCliniqueKissi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@ToString
@Builder

@Table(name = "ordonnance")

@AllArgsConstructor @NoArgsConstructor
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idordonnance;

    @Column(nullable = false,name = "numOrdonnance",length = 100)
    private String numOrdonnance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    @Column(name = "dateOrdonnance")
    private Date dateOrdonnance;
    @Column(name = "formatOrdonnance",nullable = false)
    private String formatOrdonnance;

    @Column(name = "prix",nullable = false)
    private double prix;

    @Column(name = "total",nullable = false)
    private int total;
    @Column(name = "quantite",nullable = false)
    private int quantite;

    public double calculerTotal() {
        return prix * quantite;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

}
