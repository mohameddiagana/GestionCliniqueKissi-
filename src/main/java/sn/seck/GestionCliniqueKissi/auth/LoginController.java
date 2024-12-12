package sn.seck.GestionCliniqueKissi.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
    @GetMapping(value = "")
    public String accueil() {
        return "redirect:/logon";
    }
}
