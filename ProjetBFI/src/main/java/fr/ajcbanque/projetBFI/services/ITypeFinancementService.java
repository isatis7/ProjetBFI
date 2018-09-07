package fr.ajcbanque.projetBFI.services;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.TypeFinancementDTO;

public interface ITypeFinancementService {
    List<TypeFinancementDTO> findAllAsDTO(AppLanguage lang);
}
