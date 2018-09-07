package fr.ajcbanque.projetBFI.dto;

public class DeviseDTO {
    private Long   id;
    private String codeIso;

    public DeviseDTO() {
	//
    }

    public DeviseDTO(Long id, String codeIso) {
	setId(id);
	setCodeIso(codeIso);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCodeIso() {
	return codeIso;
    }

    public void setCodeIso(String codeIso) {
	this.codeIso = codeIso;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", codeIso=" + codeIso + "}";
    }
}
