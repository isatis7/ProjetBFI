package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collaborateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @Column(length = 10, nullable = false, unique = true)
    private String matriculeInterne;
    private String nom;
    private String prenom;
    private String email;
}
