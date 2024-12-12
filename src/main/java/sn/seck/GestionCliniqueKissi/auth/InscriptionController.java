package sn.seck.GestionCliniqueKissi.auth;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.seck.GestionCliniqueKissi.Model.Users;

@Controller
public class InscriptionController {
    private  static final Logger log = LoggerFactory.getLogger(InscriptionController.class);
    @GetMapping("/")
    public String register(@ModelAttribute Users users, Model model){
        model.addAttribute("user",users);
        return "/register";
    }
    @PostMapping("/register")
    public void save(Users users){
        log.info("users : {}", users.getFirstname());

    }
}
