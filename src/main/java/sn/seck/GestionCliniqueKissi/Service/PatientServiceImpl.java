package sn.seck.GestionCliniqueKissi.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import sn.seck.GestionCliniqueKissi.Model.Patient;
import sn.seck.GestionCliniqueKissi.Repository.PatientRepository;

import java.util.List;

@Service
@Slf4j
@Transactional
@CacheConfig(cacheNames = "patients")
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    /*INJECTION VIA CONSTRUCTEUR*/

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    @ResponseBody
    public Patient addNewPatient(@RequestBody Patient patient) {
        log.info("Add new Patient {} to the database", patient.getNomp());
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public Patient getPatient(String nomp) {
        log.info("geting patient{}",nomp);
        return patientRepository.findByPatient(nomp);
    }


    @Override
    public List<Patient> listpatient() {
        log.info("Fetching all patient");
        return patientRepository.findAll();
    }
}
