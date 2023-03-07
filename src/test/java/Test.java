package ProjetHopital.src.test.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Formation;

public class Test {
	
	
	
	public static void main(String[] args) {
		
	}

	
	
	// côté secrétaire
	
	
	public void ajoutPatient(idPatient) {
		public List<Patient> fileAttente = new ArrayList<>();
		
		if (patientConnu);
		{
			fileAttente.add(patient);
		} else {
			// scanners pour enregistrer le patient;
			// ajouter à la file d'attente;
		}
				
	}
	
	
	public boolean patientConnu(idPatient) {
		boolean connu = false;
		if (fileAttente.stream().filter(patient-> patient.getId().equals(idPatient)).findFirst()) {
			connu = true;
		}
		return connu;
	}
	
	
	public Patient enregistrerPatient() {
		// affecter un id, demander nom prenom
	}
	
	
	
	
	
	
	
	
	private Patient getPatient(ResultSet rs) throws SQLException {
		// @formatter:off
		Patient patient=new Patient(rs.getInt("idPatient"), rs.getString("prenom"), rs.getString("nom"));
	}
	
	
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
