package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Medecin;
import sn.seck.GestionCliniqueKissi.Model.Patient;

import java.util.List;

@Service
public interface MedecinService {

    Medecin addNewMedecin(Medecin medecin);

    Medecin getMedecin(String lastname);
    List<Medecin> listMedecin();
}
