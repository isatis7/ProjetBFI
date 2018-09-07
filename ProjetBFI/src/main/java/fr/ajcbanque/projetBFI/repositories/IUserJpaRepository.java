package fr.ajcbanque.projetBFI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.ajcbanque.projetBFI.entities.User;

public interface IUserJpaRepository extends JpaRepository<User, Long> {
    public boolean existsByEmailIgnoreCase(String email);

    public boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);

    public User findByEmail(String username);

    @Query("select u.client.id from User u where u.id = :userId")
    public Long findIdClientByUser(@Param("userId") Long userId);
}
