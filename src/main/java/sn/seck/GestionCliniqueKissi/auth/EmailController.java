package sn.seck.GestionCliniqueKissi.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@Data
@Getter
@Setter
public class EmailController {

    private JavaMailSender mailSender;

    public EmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Value("${spring.mail.username}")
    private String frommail;


    @RequestMapping("/send-email")
    @Async
    public void sendEmail(String mail) {
        try{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(frommail);
        message.setTo(mail);
        message.setSubject("Gestion CliniqueKissi");
        message.setText("dooooooooooo the simple email for DIAGANA");

        mailSender.send(message);
        //return "success !";

    }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
            //return e.getMessage();
        }


    }

//    @RequestMapping("/send-email-with-attachement")
//    public String sendEmailWithAttachement() {
//        try{
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper help = new MimeMessageHelper(mimeMessage, true);
//
//            help.setFrom("mohameddiagana807@gmail.com");
//            help.setTo("mohameddiagana807@gmail.com");
//            help.setSubject("CliniqueKissi");
//            help.setText("Java email For attachement!");
//            help.addAttachment("exemple de motif.png",new File("D:\\honorableSeck\\exemple de motif.png"));
//
//
//            mailSender.send(mimeMessage);
//            return "success !";
//
//        }catch (Exception e){
//            return e.getMessage();
//        }
    }
