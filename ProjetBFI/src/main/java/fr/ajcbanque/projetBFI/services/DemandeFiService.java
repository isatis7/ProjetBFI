package fr.ajcbanque.projetBFI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;
import fr.ajcbanque.projetBFI.repositories.IDemandeFiJpaRepository;
import fr.ajcbanque.projetBFI.repositories.IDemandeFiRepository;

@Service
public class DemandeFiService implements IDemandeFiService {
    private final IDemandeFiRepository	  demandeFiRepository;
    private final IDemandeFiJpaRepository demandeFiJpaRepository;

    @Autowired
    protected DemandeFiService(IDemandeFiRepository demandeFiRepository,
	    IDemandeFiJpaRepository demandeFiJpaRepository) {
	this.demandeFiRepository = demandeFiRepository;
	this.demandeFiJpaRepository = demandeFiJpaRepository;
    }

    @Override
    public DemandeFinancement findById(Long id) {
	Optional<DemandeFinancement> optional = demandeFiJpaRepository
		.findById(id);
	return optional.get();
    }

    @Override
    public boolean validateReference(DemandeFinancement demandeFi) {
	Long id = demandeFi.getId();
	String reference = demandeFi.getReference();
	if (null == id) {
	    return !demandeFiJpaRepository
		    .existsByReferenceIgnoreCase(reference);
	}
	return !demandeFiJpaRepository
		.existsByReferenceIgnoreCaseAndIdNot(reference, id);
    }

    @PreAuthorize("hasRole('ROLE_USER_CLIENT')")
    @Override
    public void save(DemandeFinancement demandeFi) {
	demandeFiJpaRepository.save(demandeFi);
    }

    @PreAuthorize("hasRole('ROLE_USER_CLIENT')")
    @Override
    public void deleteById(Long id) {
	demandeFiJpaRepository.deleteById(id);
    }

    @Override
    public List<DemandeFiDTO> findAllAsClientDTO(AppLanguage lang) {
	return demandeFiRepository.findAllAsClientDTO(lang);
    }

    @Override
    public List<DemandeFiDTO> findAllAsProDTO(AppLanguage lang) {
	return demandeFiRepository.findAllAsProDTO(lang);
    }

    @Override
    public List<DemandeFiDTO> findAllAsDTO(AppLanguage lang) {
	return demandeFiRepository.findAllAsClientDTO(lang);
    }
}
