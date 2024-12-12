package sn.seck.GestionCliniqueKissi.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Data
@Getter
@Setter
@RequestMapping("/api/v1/auth")
public class HomeController {
    @GetMapping("/home")
    public ModelAndView home(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView(  );
        modelAndView.setViewName("/home");//resource/template/home.html

        return modelAndView;
        }

        // Ajoutez des autres méthodes pour gérer les autres requêtes
}
