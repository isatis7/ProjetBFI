package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;

public interface IDemandeFiRepository {
    public List<DemandeFiDTO> findAllAsClientDTO(AppLanguage lang);

    public List<DemandeFiDTO> findAllAsProDTO(AppLanguage lang);
}
