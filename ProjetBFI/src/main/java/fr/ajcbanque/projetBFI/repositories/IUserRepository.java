package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.UserDTO;

public interface IUserRepository {
    List<UserDTO> findAllAsDTO(AppLanguage lang);
}
