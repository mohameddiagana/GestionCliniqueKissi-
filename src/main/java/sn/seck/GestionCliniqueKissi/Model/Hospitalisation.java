package sn.seck.GestionCliniqueKissi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor @NoArgsConstructor
@ToString
@Builder
@Table(name = "hospitalisation")
@EntityListeners(AuditingEntityListener.class)
public class Hospitalisation implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private UUID id_hospitalisation;
  private Long id_hospitalisation;

  @Column(length = 150, name = "libelle_hospitalisation")
  private String libelle_hospitalisation;

  @Column(length = 150, name = "code_hospitalisation")
  private String code_hospitalisation;

  @Column(length = 150,nullable = false, name = "typeHospitalisation")
  private String typeHospitalisation;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
  @CreatedDate
  @Column(length = 200,nullable = false, name = "date_entree")
  private Date date_entree;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
  @Column(length = 200, name = "date_sortie")
  private LocalDate date_sortie;

  @Column(name = "motif_hospitalisation",length = 150, nullable = false )
  private String motif_hospitalisation;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "patient_id")
  private Patient patient;

}
