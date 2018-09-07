package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class DemandeFinancement implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7940205110557467195L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Client	      client	       = new Client();
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private LocalDate	      dateDemande;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 255, nullable = false, unique = true)
    private String	      reference;
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private Float	      duree;
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private LocalDate	      dateEffective;
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private Float	      montant;
    @ManyToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private Devise	      devise;
    @ManyToOne
    @NotNull(message = "{error.commons.required}")
    @JoinColumn(nullable = false)
    private TypeFinancement   typeFinancement;
    // @NotNull(message = "{error.commons.required}")
    // @Column(nullable = false)
    private BigDecimal	      perfPlus;
    private boolean	      validation;

    public DemandeFinancement() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Client getClient() {
	return client;
    }

    public void setClient(Client client) {
	this.client = client;
    }

    public LocalDate getDateDemande() {
	return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
	this.dateDemande = dateDemande;
    }

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public Float getDuree() {
	return duree;
    }

    public void setDuree(Float duree) {
	this.duree = duree;
    }

    public LocalDate getDateEffective() {
	return dateEffective;
    }

    public void setDateEffective(LocalDate dateEffective) {
	this.dateEffective = dateEffective;
    }

    public Float getMontant() {
	return montant;
    }

    public void setMontant(Float montant) {
	this.montant = montant;
    }

    public Devise getDevise() {
	return devise;
    }

    public void setDevise(Devise devise) {
	this.devise = devise;
    }

    public TypeFinancement getTypeFinancement() {
	return typeFinancement;
    }

    public void setTypeFinancement(TypeFinancement typeFinancement) {
	this.typeFinancement = typeFinancement;
    }

    public BigDecimal getPerfPlus() {
	return perfPlus;
    }

    public void setPerfPlus(BigDecimal perfPlus) {
	this.perfPlus = perfPlus;
    }

    public boolean isValidation() {
	return validation;
    }

    public void setValidation(boolean validation) {
	this.validation = validation;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((client == null) ? 0 : client.hashCode());
	result = prime * result
		+ ((dateDemande == null) ? 0 : dateDemande.hashCode());
	result = prime * result
		+ ((dateEffective == null) ? 0 : dateEffective.hashCode());
	result = prime * result + ((devise == null) ? 0 : devise.hashCode());
	result = prime * result + ((duree == null) ? 0 : duree.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((montant == null) ? 0 : montant.hashCode());
	result = prime * result
		+ ((perfPlus == null) ? 0 : perfPlus.hashCode());
	result = prime * result
		+ ((reference == null) ? 0 : reference.hashCode());
	result = prime * result
		+ ((typeFinancement == null) ? 0 : typeFinancement.hashCode());
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
	DemandeFinancement other = (DemandeFinancement) obj;
	if (client == null) {
	    if (other.client != null) {
		return false;
	    }
	} else if (!client.equals(other.client)) {
	    return false;
	}
	if (dateDemande == null) {
	    if (other.dateDemande != null) {
		return false;
	    }
	} else if (!dateDemande.equals(other.dateDemande)) {
	    return false;
	}
	if (dateEffective == null) {
	    if (other.dateEffective != null) {
		return false;
	    }
	} else if (!dateEffective.equals(other.dateEffective)) {
	    return false;
	}
	if (devise == null) {
	    if (other.devise != null) {
		return false;
	    }
	} else if (!devise.equals(other.devise)) {
	    return false;
	}
	if (duree == null) {
	    if (other.duree != null) {
		return false;
	    }
	} else if (!duree.equals(other.duree)) {
	    return false;
	}
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (montant == null) {
	    if (other.montant != null) {
		return false;
	    }
	} else if (!montant.equals(other.montant)) {
	    return false;
	}
	if (perfPlus == null) {
	    if (other.perfPlus != null) {
		return false;
	    }
	} else if (!perfPlus.equals(other.perfPlus)) {
	    return false;
	}
	if (reference == null) {
	    if (other.reference != null) {
		return false;
	    }
	} else if (!reference.equals(other.reference)) {
	    return false;
	}
	if (typeFinancement == null) {
	    if (other.typeFinancement != null) {
		return false;
	    }
	} else if (!typeFinancement.equals(other.typeFinancement)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "DemandeFinancement [id=" + id + ", client=" + client
		+ ", dateDemande=" + dateDemande + ", reference=" + reference
		+ ", duree=" + duree + ", dateEffective=" + dateEffective
		+ ", montant=" + montant + ", devise=" + devise
		+ ", typeFinancement=" + typeFinancement + ", perfPlus="
		+ perfPlus + ", validation=" + validation + "]";
    }
}
