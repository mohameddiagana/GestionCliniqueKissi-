package sn.seck.GestionCliniqueKissi.Service;

import org.springframework.stereotype.Service;
import sn.seck.GestionCliniqueKissi.Model.Patient;

import java.util.List;
@Service
public interface PatientService {
    Patient addNewPatient(Patient patient);

    Patient getPatient(String nomp);
    List<Patient> listpatient();



}
