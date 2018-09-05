package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class PositionBanquier implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1846167136959477944L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @OneToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private Collaborateur     collaborateur;
    @OneToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private Client	      client;

    public PositionBanquier() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Collaborateur getCollaborateur() {
	return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
	this.collaborateur = collaborateur;
    }

    public Client getClient() {
	return client;
    }

    public void setClient(Client client) {
	this.client = client;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((client == null) ? 0 : client.hashCode());
	result = prime * result
		+ ((collaborateur == null) ? 0 : collaborateur.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	PositionBanquier other = (PositionBanquier) obj;
	if (client == null) {
	    if (other.client != null) {
		return false;
	    }
	} else if (!client.equals(other.client)) {
	    return false;
	}
	if (collaborateur == null) {
	    if (other.collaborateur != null) {
		return false;
	    }
	} else if (!collaborateur.equals(other.collaborateur)) {
	    return false;
	}
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "PositionBanquier [id=" + id + ", collaborateur=" + collaborateur
		+ ", client=" + client + "]";
    }
}
