package fr.ajcbanque.projetBFI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ajcbanque.projetBFI.entities.Parametres;

public interface IParametresJpaRepository extends
					  JpaRepository<Parametres, Long> {
    //
}
