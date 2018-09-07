package fr.ajcbanque.projetBFI.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DemandeFiDTO {
    private Long       id;
    private String     client;
    private LocalDate  dateDemande;
    private String     reference;
    private Float      duree;
    private LocalDate  dateEffective;
    private Float      montant;
    private String     devise;
    private String     typeFinancement;
    private BigDecimal perfPlus;
    private boolean    validation;

    public DemandeFiDTO() {
	//
    }

    public DemandeFiDTO(Long id, String client, LocalDate dateDemande,
	    String reference, Float duree, LocalDate dateEffective,
	    Float montant, String devise, String typeFinancement,
	    BigDecimal perfPlus, boolean validation) {
	setId(id);
	setClient(client);
	setDateDemande(dateDemande);
	setReference(reference);
	setDuree(duree);
	setDateEffective(dateEffective);
	setMontant(montant);
	setDevise(devise);
	setTypeFinancement(typeFinancement);
	setPerfPlus(perfPlus);
	setValidation(validation);
    }

    public DemandeFiDTO(Long id, String client, LocalDate dateDemande,
	    String reference, Float duree, LocalDate dateEffective,
	    Float montant, String codeIso, String typeFinancement) {
	setId(id);
	setClient(client);
	setDateDemande(dateDemande);
	setReference(reference);
	setDuree(duree);
	setDateEffective(dateEffective);
	setMontant(montant);
	setDevise(devise);
	setTypeFinancement(typeFinancement);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getClient() {
	return client;
    }

    public void setClient(String client) {
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

    public String getDevise() {
	return devise;
    }

    public void setDevise(String devise) {
	this.devise = devise;
    }

    public String getTypeFinancement() {
	return typeFinancement;
    }

    public void setTypeFinancement(String typeFinancement) {
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
}
