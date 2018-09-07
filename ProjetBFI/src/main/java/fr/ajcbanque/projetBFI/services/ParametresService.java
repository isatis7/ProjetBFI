package fr.ajcbanque.projetBFI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.entities.Parametres;
import fr.ajcbanque.projetBFI.repositories.IParametresJpaRepository;
import fr.ajcbanque.projetBFI.repositories.IParametresRepository;

@Service
public class ParametresService implements IParametresService {
    private final IParametresRepository	   parametresRepository;
    private final IParametresJpaRepository parametresJpaRepository;

    @Autowired
    protected ParametresService(IParametresRepository parametresRepository,
	    IParametresJpaRepository parametresJpaRepository) {
	this.parametresJpaRepository = parametresJpaRepository;
	this.parametresRepository = parametresRepository;
    }

    @Override
    public void save(Parametres parametres) {
	parametresJpaRepository.save(parametres);
    }
}
