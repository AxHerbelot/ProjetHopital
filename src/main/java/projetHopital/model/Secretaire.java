package projetHopital.model;

public class Secretaire extends Compte {
	
	private String typeCompte="s";
	
	
	
	
	   public Secretaire() {
		   
		   
	   }




	public Secretaire(String login, Integer id, String mdp, String typeCompte) {
		super(login, id, mdp, typeCompte);
		
	}




	public Secretaire(String login, String mdp, String typeCompte) {
		super(login, mdp, typeCompte);
		
	}




	public String getTypeCompte() {
		return typeCompte;
	}




	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	    
	
	    
	    
	    
}
