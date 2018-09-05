package fr.ajcbanque.projetBFI.services;

import fr.ajcbanque.projetBFI.entities.User;

public interface IUserService {
    public boolean validateEmail(User user);

    public User findById(Long id);

    public void save(User user);
}
