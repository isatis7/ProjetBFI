package fr.ajcbanque.projetBFI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.entities.Parametres;

@Service
public class ParametresService implements IParametresService {
    @Autowired
    private IParametresJpaRepository paramJpaRepo;

    @Override
    public void save(Parametres param) {
	paramJpaRepo.save(param);
    }

    public Parametres getParam() {
	return paramJpaRepo.getOne(1);
    }
}
