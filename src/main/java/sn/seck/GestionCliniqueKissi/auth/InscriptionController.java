package sn.seck.GestionCliniqueKissi.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.seck.GestionCliniqueKissi.Model.Users;

@RestController
@RequestMapping(path = "localhost:7075/api/v1/auth/register")
@CrossOrigin(origins = "*")
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
