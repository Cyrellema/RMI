package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import codebase.ICabinetVeterinaire;
import codebase.IClient;
import codebase.IAnimal;
import codebase.IDossierSuivi;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client extends UnicastRemoteObject implements IClient  {

	private static final long serialVersionUID = -8278731317691388675L;

	// Constructeur
	public Client() throws RemoteException {
	}

	//Methods
	public static void main(String[] args) throws NotBoundException {
		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);

			ICabinetVeterinaire cabinetVeterinaire = (ICabinetVeterinaire) registry.lookup("CabinetVeterinaire");
			IAnimal animalRecherche = cabinetVeterinaire.getPatientByName("MonsieurleChat");
			IDossierSuivi dossierSuiviRecherche = animalRecherche.getDossierSuivi();
			System.out.println(dossierSuiviRecherche.getDossier());
			
			IClient client = new Client();
			cabinetVeterinaire.addClient(client);
			
			for (int i = 0; i < 1001; i++)
				cabinetVeterinaire.add(animalRecherche);

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public void update(String msg) throws RemoteException {
		System.out.println(msg);	
	}
	
}
