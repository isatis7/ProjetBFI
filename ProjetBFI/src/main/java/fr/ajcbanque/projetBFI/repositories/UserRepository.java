package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.UserDTO;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository {
    @Override
    public List<UserDTO> findAllAsDTO(AppLanguage lang) {
	// TODO Auto-generated method stub
	return null;
    }
}
