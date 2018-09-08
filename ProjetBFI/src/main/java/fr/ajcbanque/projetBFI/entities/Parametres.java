package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal	      ParamA;
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
    public String toString() {
	return "Parametres [ParamA=" + ParamA + ", ParamB=" + ParamB + "]";
    }
}
