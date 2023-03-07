package main.java.projetHopital.model;

public class Medcin extends Compte {
	
	
	private String typeCompte="d";
	
	
	
	public Medcin() {
		
	}



	public Medcin(String login, Integer id, String mdp, String typeCompte) {
		super(login, id, mdp, typeCompte);
		
	}



	public Medcin(String login, String mdp, String typeCompte) {
		super(login, mdp, typeCompte);
	
	}



	public String getTypeCompte() {
		return typeCompte;
	}



	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	
	
	 
	

}
