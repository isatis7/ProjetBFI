package fr.ajcbanque.projetBFI.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Parametres {
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private BigDecimal ParamA;
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private BigDecimal ParamB;

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

    @Override
    public String toString() {
	return "Parametres [ParamA=" + ParamA + ", ParamB=" + ParamB + "]";
    }
}
