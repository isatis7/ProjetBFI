package fr.ajcbanque.projetBFI.dto;

public class CollaborateurDTO {
    private Long   id;
    private String email;
    private String matriculeInterne;
    private String nom;
    private String prenom;
    private String infoComplet;

    public CollaborateurDTO() {
	//
    }

    public CollaborateurDTO(String email, String matriculeInterne, String nom,
	    String prenom, String infoComplet) {
	setEmail(email);
	setMatriculeInterne(matriculeInterne);
	setNom(nom);
	setPrenom(prenom);
	setInfoComplet(infoComplet);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getMatriculeInterne() {
	return matriculeInterne;
    }

    public void setMatriculeInterne(String matriculeInterne) {
	this.matriculeInterne = matriculeInterne;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getPrenom() {
	return prenom;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    public String getInfoComplet() {
	return infoComplet;
    }

    public void setInfoComplet(String infoComplet) {
	this.infoComplet = infoComplet;
    }
}
