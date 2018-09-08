package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class FormeJuridique implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3992325391596179656L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @NotBlank(message = "{error.commons.required}")
    @Column(length = 20, nullable = false, unique = true)
    private String	      nom;

    public FormeJuridique() {
	//
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
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
	FormeJuridique other = (FormeJuridique) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (nom == null) {
	    if (other.nom != null) {
		return false;
	    }
	} else if (!nom.equals(other.nom)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "FormeJuridique [id=" + id + ", nom=" + nom + "]";
    }
}
