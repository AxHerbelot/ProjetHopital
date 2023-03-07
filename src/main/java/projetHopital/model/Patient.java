package projetHopital.model;

import java.util.Objects;

public class Patient {
	
	private Integer idPatient;
	private String nom;
	private String prenom;
	
	
	
	   Patient(){
		   
	   }



	public Patient(Integer idPatient, String nom, String prenom) {
		
		this.idPatient = idPatient;
		this.nom = nom;
		this.prenom = prenom;
	}



	public Patient(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}



	public Integer getIdPatient() {
		return idPatient;
	}



	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
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
		return Objects.hash(idPatient);
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
		return Objects.equals(idPatient, other.idPatient);
	}
	
	  
	
	   
	   

}
