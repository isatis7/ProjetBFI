package fr.ajcbanque.projetBFI.dto;

public class ClientCreateDTO {
    private Long   id;
    private String infoComplet;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getInfoComplet() {
	return infoComplet;
    }

    public void setInfoComplet(String infoComplet) {
	this.infoComplet = infoComplet;
    }
}
