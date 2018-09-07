package fr.ajcbanque.projetBFI.services;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.ClientCreateDTO;
import fr.ajcbanque.projetBFI.dto.ClientDTO;
import fr.ajcbanque.projetBFI.entities.Client;

public interface IClientService {
    public Client findById(Long Id);

    public void save(Client client);

    public boolean validateCode(Client client);

    public List<ClientDTO> findAllAsDTO(AppLanguage lang);

    public List<ClientCreateDTO> findIdAndInfoCompletAsDTO();

    public Long findIdClientByUser(Long userId);
}
