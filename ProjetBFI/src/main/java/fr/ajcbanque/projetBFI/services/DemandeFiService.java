package fr.ajcbanque.projetBFI.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;

@Service
public class DemandeFiService implements IDemandeFiService {
    @Override
    public DemandeFinancement findById(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean validateCode(DemandeFinancement demandeFi) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void save(DemandeFinancement demandeFi) {
	// TODO Auto-generated method stub
    }

    @Override
    public void deleteById(Long id) {
	// TODO Auto-generated method stub
    }

    @Override
    public List<DemandeFiDTO> findAllAsDTO(AppLanguage lang) {
	// TODO Auto-generated method stub
	return null;
    }
}
