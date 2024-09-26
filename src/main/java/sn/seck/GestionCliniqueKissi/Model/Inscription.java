//package sn.seck.GestionCliniqueKissi.Model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import lombok.*;
//import org.hibernate.validator.constraints.Length;
//
//@Getter
//@Setter
//@ToString
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table(name = "inscription")
//public class Inscription {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  int id;
//    @NotBlank(message = "entrer votre firstname")
//    private String firstname;
//    @NotBlank(message = "entrer votre lastname")
//    private String lastname;
//    @Email(message = "entrer validation de votre mail")
//    @NotBlank(message = "Entrer votre mail")
//    private String email;
//    @Length(min = 8, message = "password must  be least 8 caractere")
//    private String password;
//}
