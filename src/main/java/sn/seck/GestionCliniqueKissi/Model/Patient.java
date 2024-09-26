package sn.seck.GestionCliniqueKissi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "patient",
uniqueConstraints =
@UniqueConstraint(columnNames = "email"))
@EntityListeners(AuditingEntityListener.class)
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpatient;
    @Column(name = "codep",nullable = false,length = 150)
    private String codep;
    @Column(name = "nomp",nullable = false,length = 150)
    private String nomp;
    @Column(name = "prenom",nullable = false,length = 150)
    private String prenom;
    @Column(name = "email")
    @NotBlank(message = "entrer vos mail")
    @Email(message = "email de dois pas etre null")
    private String email;
    @Column(name = "tel")
    private String tel;
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "datenaissance")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    @CreatedDate
    private LocalDate datenaissance;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "profession")
    private String profession;
    @Column(name = "CIN")
    private int CIN;
    @Column(name = "age")
    private int age;

//    public int getAge(LocalDate date, Date startDate, Date endDate) {
//        LocalDate maintenant = LocalDate.now();
//        LocalDate dateNaissance;
//
//        return Period.between(datenaissance, maintenant).getYears();
//
//    }
    public Patient(int idpatient, int codep, String nomp, String prenom, String email, String tel, String sexe, LocalDate datenaissance, String adresse, String profession, int CIN, int age) {
    }
    public String toString() {
        return "Patient(idpatient=" + this.getIdpatient() + ", codep=" + this.getCodep() + ", nomp=" + this.getNomp() + ", prenom=" + this.getPrenom() + ", email=" + this.getEmail() + ", tel=" + this.getTel() + ", sexe=" + this.getSexe() + ", datenaissance=" + this.getDatenaissance() + ", adresse=" + this.getAdresse() + ", profession=" + this.getProfession() + ", CIN=" + this.getCIN() + ", age=" + this.getAge() + ")";
    }
}


