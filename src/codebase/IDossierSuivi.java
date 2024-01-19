package codebase;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDossierSuivi extends Remote{
	public void setDossier(String dossier) throws RemoteException;
	public String getDossier() throws RemoteException;
}
