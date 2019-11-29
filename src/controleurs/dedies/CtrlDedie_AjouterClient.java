package controleurs.dedies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Banque;
import modele.Client;

public class CtrlDedie_AjouterClient implements IControleurDedie {

	private Banque banque;
	
	public CtrlDedie_AjouterClient(Banque banque) {
		this.banque = banque;
	}
	
	@Override
	public void traiterRequete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		ajouterClient(request, response);
	}
	
	private void ajouterClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nomClient");
		String adr = request.getParameter("adrClient");
		IllegalArgumentException erreur;
		Client c = null;
		try { 
			c = banque.ajouterClient(nom, adr);
			// cas où tout s'est bien passsé			
			erreur = null;
		} catch (IllegalArgumentException e) {
			// cas d'erreur			
			erreur = e;
		}
		request.setAttribute("ErreurCreationClient", erreur);
		request.setAttribute("ClientAjoute", c);
		request.getRequestDispatcher("./Vue/AjoutClientRetour.jsp").forward(request, response);	

	}

}
