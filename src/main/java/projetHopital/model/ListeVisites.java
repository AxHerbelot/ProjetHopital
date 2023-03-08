package projetHopital.model;

import java.util.ArrayList;
import java.util.List;

public class ListeVisites {
	public static List<Visite> visites = new ArrayList<>();

	public static List<Visite> getVisites() {
		return visites;
	}

	public static void setVisites(List<Visite> visites) {
		ListeVisites.visites = visites;
	}
	
}
