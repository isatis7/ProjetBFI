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
public class Client implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8050566319210542572L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 10, nullable = false, unique = true)
    private String	      code;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 100, nullable = false)
    private String	      nom;
    @ManyToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private FormeJuridique    formeJuridique;
    @ManyToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private Pays	      pays;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 10, nullable = false, unique = true)
    private String	      numCompteBancaire;
    @ManyToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private RatingInterne     ratingInterne;

    public Client() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public FormeJuridique getFormeJuridique() {
	return formeJuridique;
    }

    public void setFormeJuridique(FormeJuridique formeJuridique) {
	this.formeJuridique = formeJuridique;
    }

    public Pays getPays() {
	return pays;
    }

    public void setPays(Pays pays) {
	this.pays = pays;
    }

    public String getNumCompteBancaire() {
	return numCompteBancaire;
    }

    public void setNumCompteBancaire(String numCompteBancaire) {
	this.numCompteBancaire = numCompteBancaire;
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
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	result = prime * result
		+ ((formeJuridique == null) ? 0 : formeJuridique.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	result = prime * result + ((numCompteBancaire == null) ? 0
		: numCompteBancaire.hashCode());
	result = prime * result + ((pays == null) ? 0 : pays.hashCode());
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
	Client other = (Client) obj;
	if (code == null) {
	    if (other.code != null) {
		return false;
	    }
	} else if (!code.equals(other.code)) {
	    return false;
	}
	if (formeJuridique == null) {
	    if (other.formeJuridique != null) {
		return false;
	    }
	} else if (!formeJuridique.equals(other.formeJuridique)) {
	    return false;
	}
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
	if (numCompteBancaire == null) {
	    if (other.numCompteBancaire != null) {
		return false;
	    }
	} else if (!numCompteBancaire.equals(other.numCompteBancaire)) {
	    return false;
	}
	if (pays == null) {
	    if (other.pays != null) {
		return false;
	    }
	} else if (!pays.equals(other.pays)) {
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
	return "Client [id=" + id + ", code=" + code + ", nom=" + nom
		+ ", formeJuridique=" + formeJuridique + ", pays=" + pays
		+ ", numCompteBancaire=" + numCompteBancaire
		+ ", ratingInterne=" + ratingInterne + "]";
    }
}
