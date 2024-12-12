package sn.seck.GestionCliniqueKissi.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
public class ManagementController {

    @GetMapping
    public String get(){
        return "GET:: management controller";

    }
    public  String post(){
        return  "POST:: management controller";
    }
    public  String put(){
        return  "PUT:: management controller";
    }

    public  String delete(){
        return  "delete:: management controller";
    }

    }

