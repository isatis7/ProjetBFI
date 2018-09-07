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
public class Devise implements Serializable {
    /**
     *
     */
    @Transient
    private static final long serialVersionUID = 2353923113783011470L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 3, nullable = false, unique = true)
    private String	      codeIso;

    public Devise() {
	//
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
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codeIso == null) ? 0 : codeIso.hashCode());
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
	Devise other = (Devise) obj;
	if (codeIso == null) {
	    if (other.codeIso != null) {
		return false;
	    }
	} else if (!codeIso.equals(other.codeIso)) {
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
	return "Devise [id=" + id + ", codeIso=" + codeIso + "]";
    }
}
