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
		Object LA = "1234";
		
		// Interface de login
//		System.out.println("                Compte secrétaire                ");		
		System.out.println("*------------------------------------------------*");
		System.out.println("|         Bienvenue à l'hôpital du style         |");
		System.out.println("*------------------------------------------------*");

		loggingIn("             Veuillez vous enregsitrer            ");
		
		System.out.println("Beubaille");
		

	}
	
	private static void loggingIn(String phrase_prompt) {
//delet that later and replace with a a list with a list of real logins and passwords
		Map<String,String> mLogins = new HashMap<>();
		mLogins.put("Doc1", "mdp1");mLogins.put("Doc2", "mdp2");mLogins.put("Secretaire", "mdp3");mLogins.put("Stop", null);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println(phrase_prompt);
		System.out.print(" Login: ");
		String login = sc.nextLine();
		
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
					accesMedecin();
					break;
				case "Doc2":
					accesMedecin();
					break;
				case "Secretaire":
					System.out.println("*-----------------------------------------------*");
					System.out.println("                Compte secrétaire                ");
					System.out.println("*-----------------------------------------------*");
					accesSecretaire();
					break;
				case "Stop":
					break;
				}
			}
		}
		
	}
	
	private static void accesMedecin() {
		
	}
	
	private static void accesSecretaire() {
		String action = actionsSecretaire();
		switch (action) {
		case "LA":
			System.err.println("Afficher la Liste d'Attente");
			accesSecretaire();
			break;
		
		case "AddLA":
			System.err.println("Ajouter patient à la liste d'attente");
			accesSecretaire();
			break;
			
		case "P":
			System.err.println("Faire une pause");
			accesSecretaire();
			break;
			
		case "DC":
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
}

