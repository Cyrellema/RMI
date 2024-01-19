package codebase;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Espece implements Serializable {
	
	// Attributs
	private String nomEspece;
	private int dureeVieMoy;
	
	// Constructeur
	public Espece (String nomEspece, int dureeVieMoy) {
		this.nomEspece = nomEspece;
		this.dureeVieMoy = dureeVieMoy;
	}
	
	// Méthodes
	public String getnomEspece(){
		return this.nomEspece;
	}
	public int getDureeVieMoy(){
		return this.dureeVieMoy;
	}
}
