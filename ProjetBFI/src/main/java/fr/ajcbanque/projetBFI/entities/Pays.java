package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Pays implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -683617318853966771L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 2, nullable = false, unique = true)
    private String	      codeIso;
    @ManyToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private RatingInterne     ratingInterne;

    public Pays() {
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

    public RatingInterne getRatingInterne() {
	return ratingInterne;
    }

    public void setRatingInterne(RatingInterne ratingInterne) {
	this.ratingInterne = ratingInterne;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codeIso == null) ? 0 : codeIso.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result
		+ ((ratingInterne == null) ? 0 : ratingInterne.hashCode());
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
	Pays other = (Pays) obj;
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
	if (ratingInterne == null) {
	    if (other.ratingInterne != null) {
		return false;
	    }
	} else if (!ratingInterne.equals(other.ratingInterne)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Pays [id=" + id + ", codeIso=" + codeIso + ", ratingInterne="
		+ ratingInterne + "]";
    }
}
