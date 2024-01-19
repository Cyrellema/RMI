package serveur;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import codebase.ICabinetVeterinaire;
import codebase.IClient;
import codebase.IAnimal;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinetVeterinaire {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Attribut 
	private ArrayList<IAnimal> patients = new ArrayList<>();
	private ArrayList<IClient> clients = new ArrayList<>();
	private ArrayList<Integer> seuils = new ArrayList<>();

	// Constructeur
	public CabinetVeterinaire(ArrayList<Integer> seuils) throws RemoteException{
		for (Integer i : seuils)
			this.seuils.add(i);
	}

	// Méthodes 

	public void add(IAnimal animal) throws RemoteException {
		this.patients.add(animal);
		for (Integer i : this.seuils)
			if (this.patients.size() == i)
				for (IClient client : this.clients)
					client.update("Il y a desormais " + i + " patients à la clinique.");
	}

	public void addClient(IClient client) throws RemoteException {
		this.clients.add(client);
	}

	public IAnimal getPatientByName(String name) throws RemoteException {
		for (int i=0; i<this.patients.size(); i++) {
			IAnimal patient= this.patients.get(i);
			if (patient.getName().equals(name)) {
				return patient;
			}
		}
		return null;
	}
	
}