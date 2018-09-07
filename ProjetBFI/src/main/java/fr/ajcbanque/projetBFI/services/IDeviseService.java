package fr.ajcbanque.projetBFI.services;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DeviseDTO;

public interface IDeviseService {
    public List<DeviseDTO> findAllAsDTO(AppLanguage lang);
}
