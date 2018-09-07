package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DeviseDTO;

public interface IDeviseRepository {
    public List<DeviseDTO> findAllAsDTO(AppLanguage lang);
}
