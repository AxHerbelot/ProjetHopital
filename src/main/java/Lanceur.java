import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lanceur {
	public static void main(String[] args) {
//DELET THAT LATER NEED FOR TEST NOW MAP FOR LOGINS AND PASSWORDS
//		Map<String,String> mLogins = new HashMap<>();
//		mLogins.put("Doc1", "mdp1");mLogins.put("Doc2", "mdp2");mLogins.put("Secretaire", "mdp3");
//		System.out.println(mLogins.get("Doc1"));

//DELET THAT LATER NEEDED FOR TEST NOW LIST D'ATTENTE
//		Object LA = "1234";
		
		// Interface de login
//		System.out.println("|                 Compte médecin                 |");		
		System.out.println("*------------------------------------------------*");
		System.out.println("|         Bienvenue à l'hôpital du style         |");
		System.out.println("*------------------------------------------------*");

		loggingIn("             Veuillez vous enregsitrer            ");
		
		System.out.println("Aurevoir");
		

	}
	
	private static void loggingIn(String phrase_prompt) {
//delet that later and replace with a a list with a list of real logins and passwords
		Map<String,String> mLogins = new HashMap<>();
		mLogins.put("Doc1", "mdp1");mLogins.put("Doc2", "mdp2");mLogins.put("Secretaire", "mdp3");mLogins.put("Stop", null);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println(phrase_prompt);
		System.out.print(" Login: ");
		String login = sc.nextLine();
		if(login.toLowerCase().equals("q")) {
			return;
		}
		if (!mLogins.containsKey(login)){
			System.err.println("login innexistant");
			loggingIn("        Veuillez vous enregsitrer à nouveau       ");
		} else {
		System.out.print(" Mot de passe: ");
		String mdp = sc.nextLine();
 
			if (!mLogins.get(login).equals(mdp)) {
				System.err.println("mot de passe inccorect");
				loggingIn("        Veuillez vous enregsitrer à nouveau       ");
			} else {
				System.out.println("Loggin successful");
				switch (login) {
				case "Doc1":
					System.out.println("*-----------------------------------------------*");
					System.out.println("|                Compte médecin                 |");
					System.out.println("*-----------------------------------------------*");
					accesMedecin(1);
					break;
				case "Doc2":
					System.out.println("*-----------------------------------------------*");
					System.out.println("|                Compte médecin                 |");
					System.out.println("*-----------------------------------------------*");
					accesMedecin(2);
					break;
				case "Secretaire":
					System.out.println("*-----------------------------------------------*");
					System.out.println("|               Compte secrétaire               |");
					System.out.println("*-----------------------------------------------*");
					accesSecretaire();
					break;
				case "Stop":
					break;
				}
			}
		}
		
	}
	
	private static void accesMedecin(int numeroMedecin) {
		String action = actionsMedecin(numeroMedecin);
		switch (action.toLowerCase()) {
		case "la":
			System.out.println();
			System.err.println("Afficher la Liste d'Attente");
			accesMedecin(numeroMedecin);
			break;
		
		case "rsd":
			System.err.println("Rendre la salle dispo");
			accesMedecin(numeroMedecin);
			break;
			
		case "slv":
			System.err.println("Sauvegarder la liste des visites");
			accesMedecin(numeroMedecin);
			break;
			
		case "dc":
			System.err.println("Déconnection réussie");
			loggingIn("             Veuillez vous enregsitrer            ");
			break;
		}
	}
	
	private static void accesSecretaire() {
		String action = actionsSecretaire();
		switch (action.toLowerCase()) {
		case "la":
			System.err.println("Afficher la Liste d'Attente");
			accesSecretaire();
			break;
		
		case "addla":
			System.err.println("Ajouter patient à la liste d'attente");
			accesSecretaire();
			break;
			
		case "p":
			System.err.println("Faire une pause");
			accesSecretaire();
			break;
			
		case "dc":
			System.err.println("Déconnection réussie");
			loggingIn("             Veuillez vous enregsitrer            ");
			break;
		}

		
	}
	
	private static String actionsSecretaire() {
		Scanner sc = new Scanner(System.in);
		System.out.println("            Veuillez saisir une action           ");
		System.out.println("Afficher la Liste d'Attente (LA)");
		System.out.println("Ajouter un patient à la Liste d'Attente (AddLA)");
		System.out.println("Faire une pause (P)");
		System.out.println("Déconnection (DC)");
		String action = sc.nextLine();
		return action;
	}
	
	private static void afficherListeAttente(Object LA) {
		
		System.out.println(LA);
	}
	private static void ajouterPatientLA(int idPatient) {
		
	}
	
	private static String actionsMedecin(int numero_medecin) {
		Scanner sc = new Scanner(System.in);
		System.out.println("            Veuillez saisir une action           ");
		System.out.println("Afficher la Liste d'Attente (LA)");
		System.out.println("Rendre la salle dispo (RSD)");
		System.out.println("Sauvegarder la liste des visites (SLV)");
		System.out.println("Déconnection (DC)");
		String action = sc.nextLine();
		return action;
	}
}

