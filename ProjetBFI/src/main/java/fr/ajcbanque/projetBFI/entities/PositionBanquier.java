package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class PositionBanquier implements Serializable {
    /**
     *
     */
    @Transient
    private static final long serialVersionUID = 1846167136959477944L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @OneToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private Collaborateur     collaborateur;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Client>      clients;

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

    public List<Client> getClients() {
	return clients;
    }

    public void setClients(List<Client> clients) {
	this.clients = clients;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((clients == null) ? 0 : clients.hashCode());
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
	if (clients == null) {
	    if (other.clients != null) {
		return false;
	    }
	} else if (!clients.equals(other.clients)) {
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
		+ ", clients=" + clients + "]";
    }
}
