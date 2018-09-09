package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.dto.UserDTO;

public interface IUserRepository {
    List<UserDTO> findAllAsDTO();

    List<UserDTO> findClientsAsDTO();
}
