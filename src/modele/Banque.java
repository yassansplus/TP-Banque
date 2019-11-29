package modele;

import java.util.HashMap;
import java.util.Map;

public class Banque {
	
	private Map<Integer, Client> clients = new HashMap<>();
	
	public Client ajouterClient(String nom, String adresse) {
		Client c = new Client (nom, adresse);
		this.clients.put(c.getId(), c);
		return c;
	}
	
	// création de compte client
	public Compte creerCompte(int numClient) {
		Client client = clients.get(numClient);
		if (client == null)
			throw new ClientInexistantException(numClient);
		Compte compte = client.creerCompte();
		return compte;
	}	
}
