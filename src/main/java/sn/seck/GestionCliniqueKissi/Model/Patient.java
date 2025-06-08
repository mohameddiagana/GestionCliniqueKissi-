package sn.seck.GestionCliniqueKissi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


@Getter
@Setter
@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "patient",
uniqueConstraints =
@UniqueConstraint(columnNames = "email"))
/***
UniqueConstraint rend email unique
**/
@EntityListeners(AuditingEntityListener.class)
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpatient;
    @Column(name = "codep", length = 200)
    private int codep;
    @Column(name = "nomp" ,length = 200)
    private String nomp;
    @Column(name = "prenom", length = 200)
    private String prenom;
    @Column(name = "email", length = 200)
    private String email;
    @Column(name = "tel",length = 200)
    private String tel;
    @Column(name = "sexe", length = 200)
    private String sexe;
    @Column(name = "datenaissance")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    @CreatedDate
    private LocalDate datenaissance;
    @Column(name = "adresse", length = 200)
    private String adresse;
    @Column(name = "profession", length = 200)
    private String profession;
    @Column(name = "CIN", length = 250)
    private int CIN;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "patient" ,fetch = FetchType.EAGER)
    private List<Rendezvous> rendezvous;

    @OneToMany(mappedBy = "patient" ,fetch = FetchType.EAGER)
    private List<Hospitalisation> hospitalisationslList;

    // Relation OneToMany avec Consultation
    @OneToMany(mappedBy = "patient" ,fetch = FetchType.EAGER)
    private List<Consultation> consultations = new ArrayList<>();




    public Patient(int idpatient, int codep, String nomp, String prenom, String email, String tel, String sexe, LocalDate datenaissance, String adresse, String profession, int CIN, int age, String rendezvous) {
    }

    public String toString() {
        return "Patient(idpatient=" + this.getIdpatient() + ", codep=" + this.getCodep() + ", nomp=" + this.getNomp() + ", prenom=" + this.getPrenom() + ", email=" + this.getEmail() + ", tel=" + this.getTel() + ", sexe=" + this.getSexe() + ", datenaissance=" + this.getDatenaissance() + ", adresse=" + this.getAdresse() + ", profession=" + this.getProfession() + ", CIN=" + this.getCIN() + ", age=" + this.getAge() + ",rendezvous="+ this.getRendezvous();
    }
    /*METHODE POUR CALCULER Age PAARTIR DATENAISSANCE*/
//   public static int getYears(Date datenaissance)
//    {
//        Calendar curr = Calendar.getInstance();
//        Calendar birth = Calendar.getInstance();
//        birth.setTime(datenaissance);
//        int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
//        curr.add(Calendar.YEAR,-yeardiff);
//        if(birth.after(curr))
//        {
//            yeardiff = yeardiff - 1;
//        }
//        return yeardiff;
       //return getYears(datenaissance);
    }








