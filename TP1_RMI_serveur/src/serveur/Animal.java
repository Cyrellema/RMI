package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import codebase.Espece;
import codebase.IAnimal;
import codebase.IDossierSuivi;

public class Animal extends UnicastRemoteObject implements IAnimal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
/*Attributs de l'animal*/
private String name;
private String ownername;
private Espece espece;
private String race;
private IDossierSuivi dossier;

/* Constructeur*/
public Animal(String name, String ownername, Espece espece, String race, IDossierSuivi dossier) throws RemoteException {
	this.name = name;
	this.ownername = ownername;
	this.espece = espece;
	this.race = race;
	this.dossier = dossier;
}

/* Affichage des attributs de l'animal*/ 
public String toString() {
	return "nom de l'animal:" + " " + this.name + "\nnom du proprietaire:" + " " + this.ownername;
}

@Override
public void afficher() throws RemoteException {
	// TODO Auto-generated method stub
	System.out.println(this);
}

@Override
public String getName() throws RemoteException {
	// TODO Auto-generated method stub
	return this.name;
}

@Override
public void setName(String name) throws RemoteException {
	// TODO Auto-generated method stub
	this.name=name;
}

@Override
public String getOwnerName() throws RemoteException {
	// TODO Auto-generated method stub
	return this.ownername;
}

@Override
public void setOwnerName(String ownername) throws RemoteException {
	// TODO Auto-generated method stub
	this.ownername=ownername;
	
}

@Override
public Espece getEspece() throws RemoteException {
	// TODO Auto-generated method stub
	return this.espece;
}

public void setEspece(Espece espece) throws RemoteException{
	this.espece=espece;
}

@Override
public String getRace() throws RemoteException {
	// TODO Auto-generated method stub
	return this.race;
}

@Override
public void setRace(String Race) throws RemoteException {
	// TODO Auto-generated method stub
	
}

@Override
public IDossierSuivi getDossierSuivi() throws RemoteException {
	// TODO Auto-generated method stub
	return this.dossier;
}

@Override
public void setDossierSuivi(IDossierSuivi dossier) throws RemoteException {
	// TODO Auto-generated method stub
	this.dossier=dossier;
	
}


}
