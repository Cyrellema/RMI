package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import serveur.Animal;

import java.rmi.NotBoundException;


public class Client {

	// Constructeur
public Client () {}

//Methods
public static void main (String[] args) throws NotBoundException {
	String host = (args.length < 1)? null : args[0];
	try {	
		Registry registry = LocateRegistry.getRegistry(host);
		Animal stub = (Animal) registry.lookup("MonsieurleChat");
		System.out.println(stub);
				
}
catch (Exception e) {
	System.err.println("Server exception: " + e.toString());
	e.printStackTrace();	
	}
}
	
}
