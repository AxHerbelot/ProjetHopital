package projetHopital.model;

import java.util.Date;
import java.util.Objects;

public class Visite{
	
	private Integer numeroVisite;
	private double cout;
	private String salle;
	private Date dateVisite;
	
	
	
	   public Visite() {
		   
	   }



	public Visite(Integer idPatien, String nom, String prenom) {
		super(idPatien, nom, prenom);
		this.cout=cout;
		this.dateVisite=dateVisite;
		this.numeroVisite=numeroVisite;
		this.salle=salle;
		
		
	}



	public Visite(String nom, String prenom) {
		super(nom, prenom);
		this.cout=cout;
		this.dateVisite=dateVisite;
		this.numeroVisite=numeroVisite;
		this.salle=salle;
	}



	public Integer getNumeroVisite() {
		return numeroVisite;
	}



	public void setNumeroVisite(Integer numeroVisite) {
		this.numeroVisite = numeroVisite;
	}



	public double getCout() {
		return cout;
	}



	public void setCout(double cout) {
		this.cout = cout;
	}



	public String getSalle() {
		return salle;
	}



	public void setSalle(String salle) {
		this.salle = salle;
	}



	public Date getDateVisite() {
		return dateVisite;
	}



	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroVisite);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visite other = (Visite) obj;
		return Objects.equals(numeroVisite, other.numeroVisite);
	}

        

	      

        
	    
	
	
	 

	
	

}
