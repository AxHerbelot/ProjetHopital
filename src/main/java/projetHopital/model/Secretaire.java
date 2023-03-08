package projetHopital.model;

public class Secretaire extends Compte {
	
	private String typeCompte="s";
	
	
	
	
	   public Secretaire() {
		   
		   
	   }




	public Secretaire(Integer id, String login,  String mdp) {
		super(id, login,  mdp);
		
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
