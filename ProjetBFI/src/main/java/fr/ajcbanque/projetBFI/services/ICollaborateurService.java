package fr.ajcbanque.projetBFI.services;

import java.util.List;

import fr.ajcbanque.projetBFI.dto.CollaborateurDTO;
import fr.ajcbanque.projetBFI.entities.Collaborateur;

public interface ICollaborateurService {
    public List<CollaborateurDTO> findAllAsDTO();

    public Collaborateur findById(Long id);

    public List<CollaborateurDTO> findCustomCreateUserAsDTO();
}
