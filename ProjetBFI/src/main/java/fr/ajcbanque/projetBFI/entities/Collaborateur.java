package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Collaborateur implements Serializable {
    /**
     *
     */
    @Transient
    private static final long serialVersionUID = 8494510760349250205L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 10, nullable = false, unique = true)
    private String	      matriculeInterne;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 255, nullable = false)
    private String	      nom;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 255, nullable = false)
    private String	      prenom;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 255, nullable = false, unique = true)
    private String	      email;

    public Collaborateur() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((matriculeInterne == null) ? 0
		: matriculeInterne.hashCode());
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
	Collaborateur other = (Collaborateur) obj;
	if (email == null) {
	    if (other.email != null) {
		return false;
	    }
	} else if (!email.equals(other.email)) {
	    return false;
	}
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (matriculeInterne == null) {
	    if (other.matriculeInterne != null) {
		return false;
	    }
	} else if (!matriculeInterne.equals(other.matriculeInterne)) {
	    return false;
	}
	if (nom == null) {
	    if (other.nom != null) {
		return false;
	    }
	} else if (!nom.equals(other.nom)) {
	    return false;
	}
	if (prenom == null) {
	    if (other.prenom != null) {
		return false;
	    }
	} else if (!prenom.equals(other.prenom)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Collaborateur [id=" + id + ", matriculeInterne="
		+ matriculeInterne + ", nom=" + nom + ", prenom=" + prenom
		+ ", email=" + email + "]";
    }
}
