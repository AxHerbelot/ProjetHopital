package projetHopital.model;

import java.util.Objects;

public class Patient {
	private Integer idPatien;
	private String nom;
	private String prenom;
	
	
	    public Patient() {
	    	  
	      }


		public Patient(Integer idPatien, String nom, String prenom) {
			this.idPatien = idPatien;
			this.nom = nom;
			this.prenom = prenom;
		}


		public Patient(String nom, String prenom) {
		
			this.nom = nom;
			this.prenom = prenom;
		}


		public Integer getIdPatien() {
			return idPatien;
		}


		public void setIdPatien(Integer idPatien) {
			this.idPatien = idPatien;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		@Override
		public int hashCode() {
			return Objects.hash(idPatien);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Patient other = (Patient) obj;
			return Objects.equals(idPatien, other.idPatien);
		}
	      
	      
	  
	
	     
	
	
}
