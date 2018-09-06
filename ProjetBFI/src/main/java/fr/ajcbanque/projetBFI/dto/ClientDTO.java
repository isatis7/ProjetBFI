package fr.ajcbanque.projetBFI.dto;

public class ClientDTO {
    private Long   id;
    private String code;
    private String nom;
    private String formeJuridique;
    private String pays;
    private String numCompteBancaire;
    private Float  ratingInterne;

    public ClientDTO() {
	//
    }

    public ClientDTO(Long id, String code, String nom, String formeJuridique,
	    String pays, String numCompteBancaire, Float ratingInterne) {
	setId(id);
	setCode(code);
	setNom(nom);
	setFormeJuridique(formeJuridique);
	setPays(pays);
	setNumCompteBancaire(numCompteBancaire);
	setRatingInterne(ratingInterne);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getFormeJuridique() {
	return formeJuridique;
    }

    public void setFormeJuridique(String formeJuridique) {
	this.formeJuridique = formeJuridique;
    }

    public String getPays() {
	return pays;
    }

    public void setPays(String pays) {
	this.pays = pays;
    }

    public String getNumCompteBancaire() {
	return numCompteBancaire;
    }

    public void setNumCompteBancaire(String numCompteBancaire) {
	this.numCompteBancaire = numCompteBancaire;
    }

    public Float getRatingInterne() {
	return ratingInterne;
    }

    public void setRatingInterne(Float ratingInterne) {
	this.ratingInterne = ratingInterne;
    }
}
