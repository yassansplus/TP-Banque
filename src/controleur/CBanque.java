package controleur;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controleurs.dedies.CtrlDedie_AjouterClient;
import controleurs.dedies.CtrlDedie_CreerCompte;
import controleurs.dedies.IControleurDedie;
import modele.Banque;
import modele.Client;
import modele.ClientInexistantException;
import modele.Compte;


@WebServlet("/controleur")
public class CBanque extends HttpServlet {
	
	private Banque banque = new Banque();
	// map de <nom de la fonction, objet du controleur dédié correspondant>
	private Map<String, IControleurDedie> controleursDedies = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		controleursDedies.put("AjouterClient", new CtrlDedie_AjouterClient(banque));
		controleursDedies.put("CreerCompte", new CtrlDedie_CreerCompte(banque));
		super.init();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fonction = request.getParameter("fonction_metier");
		controleursDedies.get(fonction).traiterRequete(request, response);				
	}	
}
