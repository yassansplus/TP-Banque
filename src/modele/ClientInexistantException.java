package modele;

public class ClientInexistantException extends RuntimeException {

	private int numeroClient;
	
	public ClientInexistantException(int numClient) {
		this.numeroClient = numClient;
	}
}
