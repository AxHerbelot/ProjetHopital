package projetHopital.app; 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import projetHopital.dao.CompteDao;
import projetHopital.dao.Context;
import projetHopital.dao.PatientDao;
import projetHopital.dao.VisiteDao;
import projetHopital.model.Compte;
import projetHopital.model.ListeVisites;
import projetHopital.model.Medecin;
import projetHopital.model.Patient;
import projetHopital.model.Secretaire;
import projetHopital.model.Visite;

public class Lanceur {
	public static void main(String[] args) throws FileNotFoundException {
//CREER LA BDD DE COMPTES
//		CompteDao compteDao = Context.getCompteDao();
//		Secretaire secretaire = new Secretaire(3,"Secretaire","mdp");
//		Medecin medecin1 = new Medecin(1,"medecin1","mdp1");
//		Medecin medecin2 = new Medecin(2,"medecin2","mdp2");
//		compteDao.insert(secretaire); compteDao.insert(medecin1); compteDao.insert(medecin2);

//CREER FICHIER AVEC LA LISTE D'ATTENTE DEDANS S'IL N'EXISTE PAS
		File fListeAttente = new File("./ListeAttente.txt");
		if (fListeAttente.exists() && !fListeAttente.isDirectory()) {
			//the file exist it's good
		} else {
			//create the file
			try {
				FileOutputStream fos = new FileOutputStream(fListeAttente);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
//CHARGER BDD DE COMPTES
		CompteDao compteDao = Context.getCompteDao();
		Map<String,String> log_pswd = new HashMap<>();
		compteDao.findAll().forEach(c->{log_pswd.put(c.getLogin(), c.getMdp());});
//		for (String login:login_pswrd.keySet()) {
//			System.out.println(login);
//			System.out.println(login_pswrd.get(login));
//		}
//		
		// Interface de login
//		System.out.println("|                 Liste d'Attente                |");		
		System.out.println("*------------------------------------------------*");
		System.out.println("|         Bienvenue à l'hôpital du style         |");
		System.out.println("*------------------------------------------------*");

		loggingIn("             Veuillez vous enregsitrer            ");
		
		System.out.println("Aurevoir");
		

	}
	
	private static void loggingIn(String phrase_prompt) throws FileNotFoundException {
//delet that later and replace with a a list with a list of real logins and passwords
		CompteDao compteDao = Context.getCompteDao();
		Map<String,String> mLogins = new HashMap<>();
		compteDao.findAll().forEach(c->{mLogins.put(c.getLogin(), c.getMdp());});
		
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
				case "medecin1":
					System.out.println("*-----------------------------------------------*");
					System.out.println("|                Compte médecin                 |");
					System.out.println("*-----------------------------------------------*");
					System.out.println("Salle (1/2): ");
					int nSalle1 = sc.nextInt();
					accesMedecin(1,nSalle1);
					break;
				case "medecin2":
					System.out.println("*-----------------------------------------------*");
					System.out.println("|                Compte médecin                 |");
					System.out.println("*-----------------------------------------------*");
					System.out.println("Salle (1/2): ");
					int nSalle2 = sc.nextInt();
					accesMedecin(2,nSalle2);
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
	
	
	private static void accesSecretaire() throws FileNotFoundException {
		String action = actionsSecretaire();
		switch (action.toLowerCase()) {
		case "la":
			afficherListeAttente();
			accesSecretaire();
			break;
		
		case "addla":
			ajouterPatientLA();
			accesSecretaire();
			break;
			
		case "p":
			System.out.println("Secrétaire en pause");
			System.out.println("                    (\r\n"
					+ "                        )     (\r\n"
					+ "                 ___...(-------)-....___\r\n"
					+ "             .-\"\"       )    (          \"\"-.\r\n"
					+ "       .-'``'|-._             )         _.-|\r\n"
					+ "      /  .--.|   `\"\"---...........---\"\"`   |\r\n"
					+ "     /  /    |                             |\r\n"
					+ "     |  |    |                             |\r\n"
					+ "      \\  \\   |                             |\r\n"
					+ "       `\\ `\\ |                             |\r\n"
					+ "         `\\ `|                             |\r\n"
					+ "         _/ /\\                             /\r\n"
					+ "        (__/  \\                           /\r\n"
					+ "     _..---\"\"` \\                         /`\"\"---.._\r\n"
					+ "  .-'           \\                       /          '-.\r\n"
					+ " :               `-.__             __.-'              :\r\n"
					+ " :                  ) \"\"---...---\"\" (                 :\r\n"
					+ "  '._               `\"--...___...--\"`              _.'\r\n"
					+ "    \\\"\"--..__                              __..--\"\"/\r\n"
					+ "     '._     \"\"\"----.....______.....----\"\"\"     _.'\r\n"
					+ "        `\"\"--..,,_____            _____,,..--\"\"`\r\n"
					+ "                      `\"\"\"----\"\"\"`");
			faireUnePause();
			break;
			
		case "dc":
			System.err.println("Déconnection réussie");
			loggingIn("             Veuillez vous enregsitrer            ");
			break;
		}

		
	}
	
	private static String actionsSecretaire() {
		Scanner sc = new Scanner(System.in);
		System.out.println("           -Veuillez saisir une action-          ");
		System.out.println("Afficher la Liste d'Attente (LA)");
		System.out.println("Ajouter un patient à la Liste d'Attente (AddLA)");
		System.out.println("Faire une pause (P)");
		System.out.println("Déconnection (DC)");
		System.out.print("Action: ");
		String action = sc.nextLine();
		return action;
	}
	
	private static void afficherListeAttente() {
		System.out.println("__________________________________________________");
		System.out.println("                  Liste d'Attente                 ");
		Scanner scanner;
		try {
			scanner = new Scanner(new File("./ListeAttente.txt"));
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());};
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("__________________________________________________");

	}
	private static void ajouterPatientLA() {
		PatientDao patientDao = Context.getPatientDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("Patient connu de l'hoptial (o/n)");
		String connu = sc.nextLine();
		if (connu.toLowerCase().equals("o")) {
			System.out.print("id du patient à ajouter: ");
			int idPatient = sc.nextInt();
			Patient patientO = patientDao.findByKey(idPatient);
			try {
				FileWriter fw = new FileWriter("./ListeAttente.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(patientO.getIdPatien()+","+patientO.getNom()+","+patientO.getPrenom()+"\n");
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Patient ajouté à la file d'attente");
		} else if (connu.toLowerCase().equals("n")){
			System.out.println("_________________________________________________");
			System.out.println("                 Nouveau Patient                 ");
			System.out.println("Informations nouveau client:                     ");
			System.out.print("id: ");
			int idPatient = sc.nextInt();
			System.out.print("nom: ");
			String nom = sc.nextLine();
			nom = sc.nextLine();
			System.out.print("prenom: ");
			String prenom = sc.nextLine();
			Patient patientN = new Patient(idPatient, nom, prenom);
			patientDao.insert(patientN);
			try {
				FileWriter fw = new FileWriter("./ListeAttente.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(patientN.getIdPatien()+","+patientN.getNom()+","+patientN.getPrenom()+"\n");
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("                 Patient Ajouté!                 ");
			System.out.println("_________________________________________________");
			System.out.println("(patient ajouté à la bdd et à la file d'attente)");
		} else {
			System.out.println("Répondez par oui (o) ou par non (n)");
			ajouterPatientLA();
		}
	}
	
	private static void faireUnePause() throws FileNotFoundException {
		System.out.print("Entrez le mot de passe pour reprendre: ");
		CompteDao compteDao = Context.getCompteDao();
		String mdp = compteDao.findByKey(3).getMdp();
		Scanner sc = new Scanner(System.in);
		if (mdp.equals(sc.nextLine())){
			System.out.println("fin de la pause!\n\n\n");
			accesSecretaire();
		} else {
			System.out.println("Mauvais mot de passe, je reste en pause");
			faireUnePause();
		}
		
	}
	//////////////////////////////////////////////////////////////////////////// MEDECIN
	
	private static void accesMedecin(int nMedecin, int nSalle) throws FileNotFoundException {
		List<Visite> lVisites = ListeVisites.getVisites();
		
		String action = actionsMedecin(nMedecin,nSalle);
		switch (action.toLowerCase()) {
		case "la":
			afficherListeAttente();
			accesMedecin(nMedecin,nSalle);
			break;
		
		case "rsd":
			System.out.println("Salle "+nSalle+" ouverte");
			rendreSalleDisponnible(nMedecin, nSalle);

			accesMedecin(nMedecin,nSalle);
			break;
			
		case "slv":
			sauvegarderVisites();
			accesMedecin(nMedecin,nSalle);
			break;
			
		case "dc":
			System.err.println("Déconnection réussie");
			loggingIn("             Veuillez vous enregsitrer            ");
			break;
		}
	}
	
	private static String actionsMedecin(int nMedecin, int nSalle) {
		Scanner sc = new Scanner(System.in);
		System.out.println("           -Veuillez saisir une action-          ");
		System.out.println("Afficher la Liste d'Attente (LA)");
		System.out.println("Rendre la salle dispo (RSD)");
		System.out.println("Sauvegarder la liste des visites (SLV)");
		System.out.println("Déconnection (DC)");
		System.out.print("Action: ");
		String action = sc.nextLine();
		return action;
	}
	
	private static void rendreSalleDisponnible(int nMedecin, int nSalle) throws FileNotFoundException {
		List<Visite> lVisites = ListeVisites.getVisites();
		Scanner sc = new Scanner(System.in);
		PatientDao patientDao = Context.getPatientDao();
		Scanner scLA;
	
		scLA = new Scanner(new File("./ListeAttente.txt"));
		String firstLine = scLA.nextLine();
		Patient patient = patientDao.findByKey(Integer.valueOf(firstLine.split(",")[0]));
		Visite visite = new Visite(patient, nMedecin, "salle" + nSalle, LocalDate.now());
		
		System.out.println("Entrez 'annuler' pour annuler la visite ou 'finir' pour terminer la visite: ");
		String statutVisite = sc.nextLine();
		if (statutVisite.equals("annuler")) {
			System.out.println("Visite annulée");

		} else if (statutVisite.equals("finir")) {
			System.out.println("Visite finie");
			lVisites.add(visite);
			ListeVisites.setVisites(lVisites);
			
			try {
				FileWriter fw = new FileWriter("./ListeAttenteTmp.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				Scanner scanner = new Scanner(new File("./ListeAttente.txt"));
				String line = scanner.nextLine();
				while(scanner.hasNextLine()) {
					line = scanner.nextLine();
					bw.write(line+"\n");
				}
				bw.close();
				
				scanner = new Scanner(new File("./ListeAttenteTmp.txt"));
				PrintWriter writer = new PrintWriter("./ListeAttente.txt");
				while(scanner.hasNextLine()) {
					line = scanner.nextLine();
					writer.println(line);
				}
				writer.close();
				//File f = new File("./ListeAttenteTmp.txt");
				//Files.delete(f.toPath());

				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			rendreSalleDisponnible(nMedecin,nSalle);

		}
	}
	
	private static void sauvegarderVisites() {
		VisiteDao visiteDao = Context.getVisiteDao();
		for (Visite v:ListeVisites.getVisites()) {
			visiteDao.insert(v);
		}
		System.out.println("Sauvegarde finie\n\n\n");
	}
	
}

