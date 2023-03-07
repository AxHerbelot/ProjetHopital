package projetHopital.model;

public class Medecin extends Compte {
	
	
	private String typeCompte="m";
	
	
	
	public Medecin() {
		
	}



	public Medecin(Integer id,String login, String mdp) {
		super(id,login, mdp);
		
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
