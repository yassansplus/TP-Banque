package modele.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import modele.Banque;
import modele.Client;
import modele.ClientInexistantException;
import modele.Compte;

public class TestsCreationCompte {
	
	@Test
	public void testCreationComptePositif () {
		// GIVEN : préparer les données du test
		Banque banque = new Banque();
		Client dupont = banque.ajouterClient("Dupont", "Patis");
		
		// WHEN : exécuter la fonction testée
		Compte c = banque.creerCompte(dupont.getId());
		
		// THEN : vérifier la conformité du résultat par rapport à attente du test
		assertNotNull(c);
		assertEquals(0, c.getSolde());
		assertEquals("Dupont", c.getProprietaire().getNom());
	}
	
	@Test
	public void testCreationCompteNegatif () {
		// GIVEN : préparer les données du test
		Banque banque = new Banque();						
		
		// WHEN/THEN
		assertThrows(ClientInexistantException.class, ()->
			{
				banque.creerCompte(102);
			}
		);
	}

}
