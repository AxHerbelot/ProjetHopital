//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Test {
//	List<Patient> fileAttente = new ArrayList<>();
//
//	public static void main(String[] args) {
//
//	}
//
//	// côté secrétaire
//
//	public void ajoutPatient(int idPatient) {
//			
//		if (patientConnu(idPatient)) {
//			fileAttente.add(patient);
//		} else {
//			fileAttente.add(enregistrerPatient());
//		}
//	}
//
//	public boolean patientConnu(int idPatient) {
//		// patients étant ici la BDD des patients
//		boolean connu = false;
//		if (patients.stream().filter(patient-> patient.getId().equals(idPatient)).findFirst()) {
//			connu = true;
//		}
//		return connu;
//	}
//
//	public Patient enregistrerPatient() {
//		Scanner sc = new Scanner(System.in);
//		// affecter un id, demander nom prenom
//		// dans l'idéal, faire un id qui auto-increment mais ça sera pour plus tard
//		String prenom = null;
//		String nom = null;
//		int id = 0;
//		
//		System.out.println("ID du patient : ");
//		id = sc.nextInt(); // à remplacer par l'auto-increment de la BDD lors de l'insert
//		
//		System.out.println("Prénom du patient : ");
//		prenom = sc.nextLine();
//		
//		System.out.println("Nom du patient : ");
//		nom = sc.nextLine();
//		
//		new Patient patient = Patient(id, prenom, nom);
//		
//		// patient.insert(patient) dans la BDD quand les DAOs seront prêts
//		
//	}
//	
//	public void afficherFile() {
//		for(Patient patient : fileAttente) {
//			System.out.println(patient.getPrenom() + " " + patient.getNom);
//		}
//	}
//	
//	public void afficherProchainPatient() {
//		// trouver min_id qui ne soit pas déjà passé dans la liste des visites
//		
//	}
//	
//
//	// fonctionne avec une requête SQL
//	private Patient getPatient(ResultSet rs) throws SQLException {
//		Patient patient=new Patient(rs.getInt("idPatient"), rs.getString("prenom"), rs.getString("nom"));
//	}	
//	
//	
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Patient other = (Patient) obj;   // pas 100% sûr que ce soit nécessaire
//		return Objects.equals(id, other.id);
//	}
//	
//	
//	
//	// côté médecin
//	public void visitePatient(int idPatient) {
//		Scanner sc = new Scanner(System.in);
//		// numeroVisite auto-increment par BDD
//		int idMedecin = medecin.getId();
//		int salle = medecin.getSalle();
//		LocalDate date = ;
//		int cout = 20;
//		
//		System.out.println("Date : ");
//		date = sc.nextLine();
//		
//		
//	}
//	
//	
//	
//}
