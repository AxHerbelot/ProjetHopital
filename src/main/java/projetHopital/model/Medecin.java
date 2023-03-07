package projetHopital.model;

public class Medecin extends Compte {
	
	
	private String typeCompte="d";
	
	
	
	public Medecin() {
		
	}



	public Medecin(String login, Integer id, String mdp, String typeCompte) {
		super(login, id, mdp, typeCompte);
		
	}



	public Medecin(String login, String mdp, String typeCompte) {
		super(login, mdp, typeCompte);
	
	}



	public String getTypeCompte() {
		return typeCompte;
	}



	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	
	
	 
	

}
