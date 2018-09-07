package fr.ajcbanque.projetBFI.dto;

public class TypeFinancementDTO {
    private Long   id;
    private String nom;

    public TypeFinancementDTO() {
	//
    }

    public TypeFinancementDTO(Long id, String nom) {
	setId(id);
	setNom(nom);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    @Override
    public String toString() {
	return "TypeFinancementDTO [id=" + id + ", nom=" + nom + "]";
    }
}
