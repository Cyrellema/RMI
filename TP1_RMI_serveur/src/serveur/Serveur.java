package serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import codebase.IDossierSuivi;
import codebase.Espece;
import codebase.ICabinetVeterinaire;

public class Serveur {

	/* Constructeur */

	public Serveur() {
	};

	/* Methods */

	public static void main(String[] args) {
		String securityPolicyURL = args.length > 0 ? args[0] : "file:C:\\Users\\gaeta\\eclipse-workspace\\TP1_RMI_serveur\\src\\serveur\\security.policy";
		String codebaseURL = args.length > 1 ? args[1] : "file:C:\\Users\\gaeta\\eclipse-workspace\\TP1_RMI_common\\src\\codebase";
		try {
			System.setProperty("java.security.policy", securityPolicyURL);
			System.setProperty("java.rmi.server.codebase", codebaseURL);
			System.setSecurityManager(new SecurityManager());

			Registry registry = LocateRegistry.createRegistry(1099);

			if (registry == null) {
				System.err.println("Registry not found");
				return;
			}
				
			Espece chat = new Espece("Européen", 15);
			Espece rat = new Espece ("Rat nu", 2);
			DossierSuivi dossierchat = new DossierSuivi("Il est obèse");
			DossierSuivi dossierrat= new DossierSuivi ("Il a froid"); 
			Animal Splinter = new Animal ("Splinter", "Gerard", rat, "RatDeVille", dossierrat);
			Animal MonsieurChat = new Animal("MonsieurleChat", "Dupont", chat, "GrosMatou", dossierchat);
			ArrayList<Integer> seuils = new ArrayList<>();
			seuils.add(100);
			seuils.add(500);
			seuils.add(1000);
			CabinetVeterinaire cabinetVeterinaire = new CabinetVeterinaire(seuils);
			cabinetVeterinaire.add(MonsieurChat);
			cabinetVeterinaire.add(Splinter);
			registry.rebind("CabinetVeterinaire", cabinetVeterinaire);
			System.out.println(cabinetVeterinaire);
			

		} catch (RemoteException e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}

	}
}
