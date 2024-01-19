package codebase;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote{

	public void afficher() throws RemoteException;
	
	public String getName() throws RemoteException;
	public void setName (String name) throws RemoteException;
	
	public String getOwnerName() throws RemoteException;
	public void setOwnerName(String OwnerName) throws RemoteException;
	
	public Espece getEspece() throws RemoteException;
	public void setEspece(Espece espece) throws RemoteException;
	
	public String getRace() throws RemoteException;
	public void setRace(String Race) throws RemoteException;
	
	public IDossierSuivi getDossierSuivi() throws RemoteException;
	public void setDossierSuivi (IDossierSuivi dossier) throws RemoteException;
	
	
}
