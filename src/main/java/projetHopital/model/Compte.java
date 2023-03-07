package main.java.projetHopital.model;

import java.util.Objects;

public abstract class Compte {

	private Integer id;
	private String login;
	private String mdp;
	private String typeCompte;
	
	
	   
	     public Compte() {
	    	 
	     }



		public Compte(String login, Integer id, String mdp, String typeCompte) {
			
			this.login = login;
			this.id = id;
			this.mdp = mdp;
			this.typeCompte = typeCompte;
		}



		public Compte(String login, String mdp, String typeCompte) {
		
			this.login = login;
			this.mdp = mdp;
			this.typeCompte = typeCompte;
		}



		public Integer getId() {
			return id;
		}



		public void setId(Integer id) {
			this.id = id;
		}



		public String getLogin() {
			return login;
		}



		public void setLogin(String login) {
			this.login = login;
		}



		public String getMdp() {
			return mdp;
		}



		public void setMdp(String mdp) {
			this.mdp = mdp;
		}



		public String getTypeCompte() {
			return typeCompte;
		}



		public void setTypeCompte(String typeCompte) {
			this.typeCompte = typeCompte;
		}



		@Override
		public int hashCode() {
			return Objects.hash(id);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Compte other = (Compte) obj;
			return Objects.equals(id, other.id);
		}
	   
		
		
		
	   
		
	      
	
}
