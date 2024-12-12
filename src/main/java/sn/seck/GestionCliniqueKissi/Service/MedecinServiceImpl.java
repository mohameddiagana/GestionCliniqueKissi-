package sn.seck.GestionCliniqueKissi.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sn.seck.GestionCliniqueKissi.Model.Medecin;
import sn.seck.GestionCliniqueKissi.Repository.MedecinRepository;

import java.util.List;
@Service

@Slf4j
@Transactional
@CacheConfig(cacheNames = "medecins")
public class MedecinServiceImpl implements MedecinService {
    //@Autowired
    private MedecinRepository medecinRepository;

    public MedecinServiceImpl(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @Override
    @ResponseBody
    public Medecin addNewMedecin(@RequestBody Medecin medecin) {
        log.info("Add new Medecin {} to the database", medecin.getLastname());
        return medecinRepository.save(medecin); /*insertion dans la base*/

    }

    @Override
    public Medecin getMedecin(String lastname) {
        log.info("geting medecin {}",lastname);
        return medecinRepository.findByCodemed(lastname);
    }

    @Override
    public List<Medecin> listMedecin() {
        log.info("Fetching all medecin");
        return medecinRepository.findAll();
      // return listMedecin().stream().toList();
    }
}
