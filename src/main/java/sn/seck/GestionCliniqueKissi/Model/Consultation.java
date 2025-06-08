package sn.seck.GestionCliniqueKissi.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consultation")
public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "codecons",length = 150)
    private String codecons;
    @Temporal(TemporalType.DATE)    /*par defaut TIMESTAm*/
    private Date dateconsultation;
    @Column(name = "rapport",length = 100,nullable = false)
//    @Lob
    private String rapport;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_idpatient")
    private Patient patient;

}
