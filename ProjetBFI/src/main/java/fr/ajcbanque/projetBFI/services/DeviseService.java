package fr.ajcbanque.projetBFI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DeviseDTO;
import fr.ajcbanque.projetBFI.repositories.IDeviseRepository;

@Service
public class DeviseService implements IDeviseService {
    private final IDeviseRepository deviseRepository;

    @Autowired
    protected DeviseService(IDeviseRepository deviseRepository) {
	this.deviseRepository = deviseRepository;
    }

    @Override
    public List<DeviseDTO> findAllAsDTO(AppLanguage lang) {
	return deviseRepository.findAllAsDTO(lang);
    }
}
