package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class RatingInterne implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -3181838841059743882L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private Code	      code;
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private Float	      coefficientRisque;

    public RatingInterne() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Code getCode() {
	return code;
    }

    public void setCode(Code code) {
	this.code = code;
    }

    public Float getCoefficientRisque() {
	return coefficientRisque;
    }

    public void setCoefficientRisque(Float coefficientRisque) {
	this.coefficientRisque = coefficientRisque;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	result = prime * result + ((coefficientRisque == null) ? 0
		: coefficientRisque.hashCode());
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
	RatingInterne other = (RatingInterne) obj;
	if (code != other.code) {
	    return false;
	}
	if (coefficientRisque == null) {
	    if (other.coefficientRisque != null) {
		return false;
	    }
	} else if (!coefficientRisque.equals(other.coefficientRisque)) {
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
	return "RatingInterne [id=" + id + ", code=" + code
		+ ", coefficientRisque=" + coefficientRisque + "]";
    }

    public static enum Code {
	A, B, C, D, E;
	public String getName() {
	    return name();
	}
    }
}
