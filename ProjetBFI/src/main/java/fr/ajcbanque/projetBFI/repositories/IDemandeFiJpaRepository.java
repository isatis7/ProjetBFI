package fr.ajcbanque.projetBFI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ajcbanque.projetBFI.entities.DemandeFinancement;

public interface IDemandeFiJpaRepository extends
					 JpaRepository<DemandeFinancement, Long> {
}
