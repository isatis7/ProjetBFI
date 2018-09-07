package fr.ajcbanque.projetBFI.services;

import javax.validation.Valid;

import fr.ajcbanque.projetBFI.entities.Parametres;

public interface IParametresService {
    public void save(Parametres parametres);

    public Parametres findById(Long id);

    public boolean validateId(@Valid Parametres parametres);
}
