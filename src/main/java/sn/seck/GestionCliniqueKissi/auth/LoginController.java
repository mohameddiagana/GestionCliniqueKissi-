package sn.seck.GestionCliniqueKissi.auth;

import jakarta.persistence.EntityListeners;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
@Controller
@CrossOrigin("http://localhost:7075/api/v1/auth/login")
public class LoginController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
        @RequestMapping(value = "/login")
        public String login() {
            return "redirect:/api/v1/auth/login";
        }

}


