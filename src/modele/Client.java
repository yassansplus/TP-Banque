package modele;

import java.util.HashMap;
import java.util.Map;

public class Client {
	private int id;
	private String nom;
	private String adresse;
	private Map<Integer, Compte> comptes = new HashMap<>();
	
	private static int compteur = 0;

	public Client(String nom, String adresse) {
		if(nom == null || nom.trim().isEmpty())
			throw new IllegalArgumentException("le nom du client n'est pas renseigné");
		this.id = ++compteur;
		this.nom = nom;
		this.adresse = adresse;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public Compte creerCompte() {
		Compte c = new Compte(this);
		comptes.put(c.getNumCompte(), c);
		return c;
	}
}
