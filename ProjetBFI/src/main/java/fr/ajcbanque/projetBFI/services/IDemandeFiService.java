package fr.ajcbanque.projetBFI.services;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;

public interface IDemandeFiService {
    public DemandeFinancement findById(Long id);

    public boolean validateCode(DemandeFinancement demandeFi);

    public void save(DemandeFinancement demandeFi);

    public void deleteById(Long id);

    public List<DemandeFiDTO> findAllAsDTO(AppLanguage lang);
}
