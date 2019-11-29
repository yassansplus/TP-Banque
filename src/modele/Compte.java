package modele;

public class Compte {
	
	private int numCompte;
	private double solde;
	private Client proprietaire;
	private static int compteur = 0;
	
	public Compte(Client proprietaire) {	
		if(proprietaire == null)
			throw new IllegalArgumentException("le client doit être renseigné");
		this.numCompte = ++compteur;
		this.solde = 0;
		this.proprietaire = proprietaire;
	}
	
	public int getNumCompte() {
		return numCompte;
	}
	
	public double getSolde() {
		return solde;
	}
	
	public Client getProprietaire() {
		return proprietaire;
	}

}
