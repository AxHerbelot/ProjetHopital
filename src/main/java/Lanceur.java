import java.util.Scanner;

public class Lanceur {
	public static void main(String[] args) {
		// Ouvre un scanner
		
		// Interface de login
		System.out.println("*------------------------------------------------*");
		System.out.println("|         Bienvenue à l'hôpital du style         |");
		System.out.println("*------------------------------------------------*");
		loggingIn();
		

	}
	
	private static void loggingIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("             Veuillez vous enregsitrer            ");
		System.out.print(" Login: ");
		String login = sc.nextLine();
		System.out.print(" Mot de passe: ");
		String mdp = sc.nextLine();
	}
	
	
}

