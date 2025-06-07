package sn.seck.GestionCliniqueKissi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rendezvous")
@EntityListeners(AuditingEntityListener.class)
public class Rendezvous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "coderdv", length = 200)
    private String coderdv;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    @CreatedDate
    private Date daterdv;
    @Column(name = "typerdv", length = 200)
   // @NotBlank(message = "entrer le type de rendezvous")
    private String typerdv;
    @Column
    private Date  heurerdv;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_idpatient")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

}

