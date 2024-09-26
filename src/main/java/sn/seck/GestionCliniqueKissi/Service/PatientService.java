package sn.seck.GestionCliniqueKissi.Service;

import sn.seck.GestionCliniqueKissi.Model.Patient;


import java.util.List;
public interface PatientService {
    Patient addNewPatient(Patient patient);

    Patient getPatient(String nomp);
    List<Patient> listpatient();



}
