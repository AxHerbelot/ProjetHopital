import java.time.LocalDate;
import java.util.List;

import projetHopital.dao.VisiteDao;
import projetHopital.dao.CompteDao;
import projetHopital.dao.Context;
import projetHopital.dao.PatientDao;
import projetHopital.model.Medecin;
import projetHopital.model.Patient;
import projetHopital.model.Visite;

public class TestAlexis {
	public static void main(String[] args) {
		System.out.println("----------------------------PATIENTS----------------------------------");
		PatientDao patientDao = Context.getPatientDao();
		Patient patient1=new Patient(1, "Bob", "Rachet");
		patientDao.insert(patient1);
		System.out.println(patient1 = patientDao.findByKey(1));
		patientDao.findAll().forEach(p -> {System.out.println(p.getIdPatien());});
		patient1.setNom("Billy");
		patientDao.update(patient1);
		patientDao.delete(patient1);
		
		System.out.println("---------------------------------COMPTE---------------------------------------");
		CompteDao compteDao = Context.getCompteDao();
		Medecin compte1=new Medecin(1, "Doc1", "mdp1");
		compteDao.insert(compte1);
		System.out.println(compteDao.findByKey(compte1.getId()));
		compteDao.findAll().forEach(m->{System.out.println(m.getId());});
		compte1.setLogin("DocUn"); 
		compteDao.update(compte1);
		compteDao.delete(compte1);
		
		System.out.println("---------------------------------VISITE---------------------------------------");
		VisiteDao visiteDao = Context.getVisiteDao();
		patient1=new Patient(1, "Bob", "Rachet");
		patientDao.insert(patient1);
		Visite visite1 = new Visite(1, patient1, 1, "salle1", LocalDate.of(2023, 03, 07));
		visiteDao.insert(visite1);
		System.out.println(visiteDao.findByKey(visite1.getNumeroVisite()));
		visiteDao.findAll().forEach(v->{System.out.println(v.getNumeroVisite());});
		visiteDao.delete(visite1);
		patientDao.delete(patient1);
		System.out.println("fin");
		
		System.err.println("+------------------------------+");
		System.err.println("|         !ATTENTION!          |");
		System.err.println("+------------------------------+");
		System.out.println(
				"Ceci n'est pas un message d'erreur,\n"
				+ "mais il est très important:\n"
				+ "Le tableau 'visite' est lié au \n"
				+ "tableau 'patient' par une foreign key,\n"
				+ "cequi veut dire qu'on ne peut pas supprimer \n"
				+ "un patient qui possède une visite! \n"
				+ "Il faut d'abbord supprimer les visites \n"
				+ "qui possèdent l'idPatient associé avant\n"
				+ "de supprimer le patient lui même! Thank me later.");


	}
}
