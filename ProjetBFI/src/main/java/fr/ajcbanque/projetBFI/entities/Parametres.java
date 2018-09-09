package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Parametres implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2865600108666403947L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @DecimalMin(value = "0.01", message = "error.perfplus.paramA")
    @DecimalMax(value = "1.00", message = "error.perfplus.paramA")
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal	      ParamA;
    @DecimalMin(value = "0.001", message = "error.perfplus.paramB")
    @DecimalMax(value = "0.025", message = "error.perfplus.paramB")
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false, precision = 19, scale = 3)
    private BigDecimal	      ParamB;

    public Parametres() {
	//
    }

    public BigDecimal getParamA() {
	return ParamA;
    }

    public void setParamA(BigDecimal paramA) {
	ParamA = paramA;
    }

    public BigDecimal getParamB() {
	return ParamB;
    }

    public void setParamB(BigDecimal paramB) {
	ParamB = paramB;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ParamA == null) ? 0 : ParamA.hashCode());
	result = prime * result + ((ParamB == null) ? 0 : ParamB.hashCode());
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
	Parametres other = (Parametres) obj;
	if (ParamA == null) {
	    if (other.ParamA != null) {
		return false;
	    }
	} else if (!ParamA.equals(other.ParamA)) {
	    return false;
	}
	if (ParamB == null) {
	    if (other.ParamB != null) {
		return false;
	    }
	} else if (!ParamB.equals(other.ParamB)) {
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
	return "Parametres [id=" + id + ", ParamA=" + ParamA + ", ParamB="
		+ ParamB + "]";
    }
}
