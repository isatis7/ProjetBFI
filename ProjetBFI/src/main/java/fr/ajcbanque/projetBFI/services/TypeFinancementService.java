package fr.ajcbanque.projetBFI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.TypeFinancementDTO;
import fr.ajcbanque.projetBFI.repositories.ITypeFinancementRepository;

@Service
public class TypeFinancementService implements ITypeFinancementService {
    private final ITypeFinancementRepository typeFinancementRepository;

    @Autowired
    protected TypeFinancementService(
	    ITypeFinancementRepository typeFinancementRepository) {
	this.typeFinancementRepository = typeFinancementRepository;
    }

    @Override
    public List<TypeFinancementDTO> findAllAsDTO(AppLanguage lang) {
	return typeFinancementRepository.findAllAsDTO(lang);
    }
}
