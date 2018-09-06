package fr.ajcbanque.projetBFI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ajcbanque.projetBFI.entities.Client;

public interface IClientJpaRepository extends JpaRepository<Client, Long> {
    public boolean existsByCodeIgnoreCase(String code);

    public boolean existsByCodeIgnoreCaseAndIdNot(String code, Long id);
}
