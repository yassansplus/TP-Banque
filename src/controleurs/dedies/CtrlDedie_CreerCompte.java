package controleurs.dedies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Banque;
import modele.ClientInexistantException;
import modele.Compte;

public class CtrlDedie_CreerCompte implements IControleurDedie {

	private Banque banque;

	public CtrlDedie_CreerCompte(Banque banque) {
		this.banque = banque;
	}

	@Override
	public void traiterRequete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		creerCompte(request, response);		
	}
	
	private void creerCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClient = Integer.parseInt(request.getParameter("idClient"));
		
		ClientInexistantException erreur;
		Compte c = null;
		try { 
			c = banque.creerCompte(idClient);
			// cas où tout s'est bien passsé			
			erreur = null;
		} catch (ClientInexistantException e) {
			// cas d'erreur			
			erreur = e;
		}
		request.setAttribute("ErreurCreationCompte", erreur);
		request.setAttribute("CompteCree", c);
		request.getRequestDispatcher("./Vue/CreationCompteRetour.jsp").forward(request, response);	

	}
	
}
