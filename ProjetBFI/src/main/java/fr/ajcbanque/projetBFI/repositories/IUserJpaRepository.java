package fr.ajcbanque.projetBFI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ajcbanque.projetBFI.entities.User;

public interface IUserJpaRepository extends JpaRepository<User, Long> {
    public boolean existsByEmailIgnoreCase(String email);

    public boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);

    public User findByEmail(String username);
}
