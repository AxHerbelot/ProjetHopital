package projetHopital.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Visite{
	private Integer numeroVisite;
	private Patient patient;
	private Integer idMedecin;
	private double cout;
	private String salle;
	private LocalDate dateVisite;
	
	
	
	   public Visite() {
	   }

	public Visite(Integer numeroVisite, Patient patient, Integer idMedecin, String salle, LocalDate dateVisite) {
		super();
		this.numeroVisite = numeroVisite;
		this.patient = patient;
		this.idMedecin = idMedecin;
		this.cout = 20;
		this.salle = salle;
		this.dateVisite = dateVisite;
	}


	public Visite(Patient patient, Integer idMedecin, String salle, LocalDate dateVisite) {
		super();
		this.patient = patient;
		this.idMedecin = idMedecin;
		this.cout = 20;
		this.salle = salle;
		this.dateVisite = dateVisite;
	}



	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Integer idMedecin) {
		this.idMedecin = idMedecin;
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

	public LocalDate getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(LocalDate dateVisite) {
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
