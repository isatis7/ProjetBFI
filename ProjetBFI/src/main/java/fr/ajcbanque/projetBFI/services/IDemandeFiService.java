package fr.ajcbanque.projetBFI.services;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;

public interface IDemandeFiService {
    public DemandeFinancement findById(Long id);

    public boolean validateReference(DemandeFinancement demandeFi);

    public void save(DemandeFinancement demandeFi);

    public void deleteById(Long id);

    public List<DemandeFiDTO> findByIdUserAsDTO(AppLanguage lang, Long id);

    public List<DemandeFiDTO> findAllProAsDTO(AppLanguage lang, Long id);

    public List<DemandeFiDTO> findAllAsDTO(AppLanguage lang);
}
