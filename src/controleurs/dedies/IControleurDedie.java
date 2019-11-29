package controleurs.dedies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IControleurDedie {
	
	public void traiterRequete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
