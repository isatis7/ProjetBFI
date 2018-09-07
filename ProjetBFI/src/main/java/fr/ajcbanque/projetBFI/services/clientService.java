package fr.ajcbanque.projetBFI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.ClientCreateDTO;
import fr.ajcbanque.projetBFI.dto.ClientDTO;
import fr.ajcbanque.projetBFI.entities.Client;
import fr.ajcbanque.projetBFI.repositories.IClientJpaRepository;
import fr.ajcbanque.projetBFI.repositories.IClientRepository;
import fr.ajcbanque.projetBFI.repositories.IUserJpaRepository;

@Service
public class clientService implements IClientService {
    private final IClientRepository    clientRepository;
    private final IClientJpaRepository clientJpaRepository;
    private final IUserJpaRepository   userJpaRepository;

    @Autowired
    protected clientService(IClientRepository clientRepository,
	    IClientJpaRepository clientJpaRepository,
	    IUserJpaRepository userJpaRepository) {
	this.clientRepository = clientRepository;
	this.clientJpaRepository = clientJpaRepository;
	this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Client findById(Long id) {
	Optional<Client> optional = clientJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    public void save(Client client) {
	clientJpaRepository.save(client);
    }

    @Override
    public boolean validateCode(Client client) {
	Long id = client.getId();
	String code = client.getCode();
	if (null == id) { // create
	    return !clientJpaRepository.existsByCodeIgnoreCase(code);
	}
	return !clientJpaRepository.existsByCodeIgnoreCaseAndIdNot(code, id); // update
    }

    @Override
    public List<ClientDTO> findAllAsDTO(AppLanguage lang) {
	return clientRepository.findAllAsDTO(lang);
    }

    @Override
    public Long findIdClientByUser(Long userId) {
	return userJpaRepository.findIdClientByUser(userId);
    }

    @Override
    public List<ClientCreateDTO> findIdAndInfoCompletAsDTO() {
	return clientRepository.findIdAndInfoCompletAsDTO();
    }
}