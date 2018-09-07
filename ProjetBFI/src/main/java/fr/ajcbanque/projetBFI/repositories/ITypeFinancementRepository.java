package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.TypeFinancementDTO;

public interface ITypeFinancementRepository {
    public List<TypeFinancementDTO> findAllAsDTO(AppLanguage lang);
}
