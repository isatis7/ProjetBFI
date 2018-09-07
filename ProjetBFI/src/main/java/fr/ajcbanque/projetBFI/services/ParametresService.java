package fr.ajcbanque.projetBFI.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.entities.Parametres;
import fr.ajcbanque.projetBFI.repositories.IParametresJpaRepository;

@Service
public class ParametresService implements IParametresService {
    private final IParametresJpaRepository parametresJpaRepository;

    @Autowired
    protected ParametresService(
	    IParametresJpaRepository parametresJpaRepository) {
	this.parametresJpaRepository = parametresJpaRepository;
    }

    @Override
    public void save(Parametres parametres) {
	parametresJpaRepository.save(parametres);
    }

    @Override
    public Parametres findById(Long id) {
	Optional<Parametres> optional = parametresJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    public boolean validateId(@Valid Parametres parametres) {
	Long id = parametres.getId();
	if (null == id) {
	    return false;
	}
	return true;
    }
}
