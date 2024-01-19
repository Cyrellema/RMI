package codebase;

import java.io.Serializable;

public class Espece implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Attributs
	private String nomEspece;
	private int dureeVieMoy;
	
	// Constructeur
	public Espece (String nomEspece, int dureeVieMoy) {
		this.nomEspece = nomEspece;
		this.dureeVieMoy = dureeVieMoy;
	}
	
	//

}
