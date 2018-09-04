package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;
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
    private Client	      client;
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
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private Devise	      devise;
    @NotNull(message = "{error.commons.required}")
    @Column(nullable = false)
    private TypeFinancement   typeFinancement;
}
