package fr.ajcbanque.projetBFI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ajcbanque.projetBFI.entities.Collaborateur;

public interface ICollaborateurJpaRepository extends
					     JpaRepository<Collaborateur, Long> {
}
