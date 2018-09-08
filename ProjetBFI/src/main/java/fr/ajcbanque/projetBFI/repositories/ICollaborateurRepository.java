package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.dto.CollaborateurDTO;

public interface ICollaborateurRepository {
    public List<CollaborateurDTO> findAllAsDTO();

    public List<CollaborateurDTO> findCustomCreateUserAsDTO();
}
