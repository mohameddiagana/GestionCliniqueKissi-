package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Medecin;

import java.util.List;
import java.util.Optional;

@Service
public interface MedecinService {

    Medecin addNewMedecin(Medecin medecin);

     Optional <Medecin> getMedecinById(long id);
    List<Medecin> listMedecin();
     void deleteMedecinById(long id);
}
