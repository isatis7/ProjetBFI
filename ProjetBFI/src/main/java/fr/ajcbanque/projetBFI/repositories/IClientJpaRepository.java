package fr.ajcbanque.projetBFI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.ajcbanque.projetBFI.entities.Client;

public interface IClientJpaRepository extends JpaRepository<Client, Long> {
    public boolean existsByCodeIgnoreCase(String code);

    public boolean existsByCodeIgnoreCaseAndIdNot(String code, Long id);

    @Query("select u.client.id from User u where u.id = :userId")
    public Long findIdClientByUser(@Param("userId") Long userId);
}
