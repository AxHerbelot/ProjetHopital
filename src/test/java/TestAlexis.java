import java.util.List;

import projetHopital.dao.CompteDao;
import projetHopital.dao.Context;
import projetHopital.dao.MedecinDao;
import projetHopital.dao.PatientDao;
import projetHopital.model.Medecin;
import projetHopital.model.Patient;

public class TestAlexis {
	public static void main(String[] args) {
		System.out.println("----------------------------PATIENTS----------------------------------");
		System.out.println("------Add 1st row (insert) then print by key (findByKey) and print all (findAll)-------");
		Patient patient1=new Patient(1, "Bob", "Rachet");
		PatientDao patientDao = Context.getPatientDao();
		patientDao.insert(patient1);
		patient1 = null;
		System.out.println("-findByKey-");
		patient1 = patientDao.findByKey(1);
		System.out.println(patient1.getIdPatien()+" "+patient1.getNom()+" "+patient1.getPrenom());
		System.out.println("-findAll-");
		List<Patient> allPatients = patientDao.findAll();
		allPatients.forEach(p -> {System.out.println(p.getIdPatien()+" "+p.getNom()+" "+p.getPrenom());});
		System.out.println("-------Update name of patient------");
		patient1.setNom("Billy");
		patientDao.update(patient1);
		Patient updatedPatient1 = patientDao.findByKey(1);
		System.out.println(updatedPatient1.getIdPatien()+" "+updatedPatient1.getNom()+" "+updatedPatient1.getPrenom());
		
		
		System.out.println("------Delet row (delet) then print all (findAll)-------");
		patientDao.delete(patient1);
		allPatients = patientDao.findAll();
		allPatients.forEach(p -> {System.out.println(p.getIdPatien()+" "+p.getNom()+" "+p.getPrenom());});
		
		
		System.out.println("---------------------------------MEDECIN---------------------------------------");
		CompteDao medecinDao = Context.getCompteDao();
		Medecin medecin1=new Medecin(1, "Doc1", "mdp1");
		medecinDao.insert(medecin1);
		medecinDao.findAll().forEach(m->{System.out.println(m.getId());});
		medecinDao.delete(medecin1);

	}
}
