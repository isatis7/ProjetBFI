package fr.ajcbanque.projetBFI.dto;

import java.math.BigDecimal;

import fr.ajcbanque.projetBFI.entities.FormeJuridique;
import fr.ajcbanque.projetBFI.entities.Pays;
import fr.ajcbanque.projetBFI.entities.RatingInterne;

public class ClientDTO {
    private Long       id;
    private String     code;
    private String     nom;
    private String     formeJuridique;
    private String     pays;
    private String     numCompteBancaire;
    private BigDecimal ratingInterne;

    public ClientDTO() {
	//
    }

    public ClientDTO(Long id,
     String code, String nom, FormeJuridique formeJuridique, Pays pays,  Long numCompteBancaire, RatingInterne ratingInterne;)
}
