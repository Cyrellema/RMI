package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import codebase.IDossierSuivi;

public class DossierSuivi extends UnicastRemoteObject implements IDossierSuivi {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //import de la s�rialisation de DossierSuivi, jsp pk 
	public String dossier;

	public DossierSuivi(String dossier) throws RemoteException {
		this.dossier = dossier;
	}

//Accesseur 
	public void setDossier(String dossier) throws RemoteException {
		this.dossier = dossier;
	}

	public String getDossier() throws RemoteException {
		return this.dossier;
	}

	public String toString() {
		return this.dossier;
	}

}
