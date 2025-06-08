package sn.seck.GestionCliniqueKissi.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Medecin;
import sn.seck.GestionCliniqueKissi.Repository.MedecinRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@Transactional
@CacheConfig(cacheNames = "medecins")
@Service
public class MedecinServiceImpl implements MedecinService {
    //@Autowired
    private MedecinRepository medecinRepository;

    public MedecinServiceImpl(@Lazy MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }


    @Override
    public Medecin addNewMedecin(Medecin medecin) {
        //Medecin med = new Medecin();
        return medecinRepository.saveAndFlush(medecin);
    }

    @Override
    public Optional<Medecin> getMedecinById(long id) {
       // return Optional.empty();
        return medecinRepository.findById(id);
    }

    @Override
    public List<Medecin> listMedecin() {
        return medecinRepository.findAll();
    }

    @Override
    public void deleteMedecinById(long id) {
    medecinRepository.deleteById(id);
    }
}
