package serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import codebase.IDossierSuivi;
import codebase.Espece;


public class Serveur {
	
	/*Constructeur*/
	
	public Serveur() { } ; 
	
	/*Methods*/
	
	public static void main(String[] args) {
		try { 
			System.setProperty("java.security.Policy", "serveurSecurity.Policy");
			System.setSecurityManager(new SecurityManager());
			Espece chat =new Espece ("Européen", 15);
			DossierSuivi dossierchat = new DossierSuivi ("Il est obèse");
			Animal MonsieurChat = new Animal("MonsieurleChat", "Dupont", chat, "GrosMatou", dossierchat);
			Registry registry = LocateRegistry.createRegistry(1099);
			
			if (registry == null) 
				System.err.println("Registry not found");	
			else {
				registry.rebind("MonsieurleChat", MonsieurChat);
				System.out.println(MonsieurChat);		
						}
		}
		catch (RemoteException e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	
	}
}
	
