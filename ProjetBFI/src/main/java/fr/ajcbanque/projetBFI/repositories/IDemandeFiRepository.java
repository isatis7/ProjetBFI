package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;

public interface IDemandeFiRepository {
    public List<DemandeFiDTO> findByIdUserAsDTO(AppLanguage lang, Long id);

    public List<DemandeFiDTO> findAllAsDTO(AppLanguage lang);

    public List<DemandeFiDTO> findAllProAsDTO(AppLanguage lang, Long id);
}
