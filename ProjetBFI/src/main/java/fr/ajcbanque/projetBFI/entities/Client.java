package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;

public class Client implements Serializable {
    private Long	   id;
    private String	   nom;
    private FormeJuridique formeJuridique;

    public static enum FormeJuridique {
	SAS, SASU, SARL, SA;
	public String getName() {
	    return name();
	}
    }
}
