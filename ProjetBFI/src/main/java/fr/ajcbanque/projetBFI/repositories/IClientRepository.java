package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.ClientDTO;

public interface IClientRepository {
    public List<ClientDTO> findAllAsDTO(AppLanguage lang);
}
