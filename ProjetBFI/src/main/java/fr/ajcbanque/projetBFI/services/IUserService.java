package fr.ajcbanque.projetBFI.services;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.UserDTO;
import fr.ajcbanque.projetBFI.entities.User;

public interface IUserService {
    public boolean validateEmail(User user);

    public User findById(Long id);

    public void save(User user);

    public List<UserDTO> findAllAsDTO(AppLanguage appLanguage);
}
