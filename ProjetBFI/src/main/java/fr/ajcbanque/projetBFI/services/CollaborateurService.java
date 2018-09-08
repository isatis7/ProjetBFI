package fr.ajcbanque.projetBFI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.dto.CollaborateurDTO;
import fr.ajcbanque.projetBFI.entities.Collaborateur;
import fr.ajcbanque.projetBFI.repositories.ICollaborateurJpaRepository;
import fr.ajcbanque.projetBFI.repositories.ICollaborateurRepository;

@Service
public class CollaborateurService implements ICollaborateurService {
    @Autowired
    private final ICollaborateurRepository collaborateurRepository;
    @Autowired
    private ICollaborateurJpaRepository	   CollaborateurJpaRepository;

    @Autowired
    protected CollaborateurService(
	    ICollaborateurRepository collaborateurRepository) {
	this.collaborateurRepository = collaborateurRepository;
    }

    @Override
    public List<CollaborateurDTO> findAllAsDTO() {
	return collaborateurRepository.findAllAsDTO();
    }

    @Override
    public Collaborateur findById(Long id) {
	Optional<Collaborateur> optional = CollaborateurJpaRepository
		.findById(id);
	return optional.get();
    }

    @Override
    public List<CollaborateurDTO> findCustomCreateUserAsDTO() {
	return collaborateurRepository.findCustomCreateUserAsDTO();
    }
}
