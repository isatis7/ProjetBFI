package fr.ajcbanque.projetBFI.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.dto.UserDTO;
import fr.ajcbanque.projetBFI.entities.User;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository {
    @SuppressWarnings("unchecked")
    @Override
    public List<UserDTO> findAllAsDTO() {
	Query query = em.createQuery("from User");
	List<User> users = query.getResultList();
	List<UserDTO> result = new ArrayList<>(users.size());
	UserDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (User user : users) {
	    dto = new UserDTO();
	    dto.setId(user.getId());
	    sb.append(" - ");
	    sb.append(user.getEmail());
	    sb.append(" - ");
	    sb.append(user.getLastname());
	    sb.append(" - ");
	    sb.append(user.getFirstname());
	    dto.setInfos(sb.toString());
	    dto.setRole(user.getRole());
	    dto.setEmail(user.getEmail());
	    dto.setEnabled(user.isEnabled());
	    dto.setLastname(user.getLastname());
	    dto.setFirstname(user.getFirstname());
	    dto.setPassword(user.getPassword());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDTO> findClientsAsDTO() {
	Query query = em
		.createQuery("select u from User u where u.client is not null");
	List<User> users = query.getResultList();
	List<UserDTO> result = new ArrayList<>(users.size());
	UserDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (User user : users) {
	    dto = new UserDTO();
	    dto.setId(user.getId());
	    sb.append(user.getClient().getCode());
	    sb.append(" - ");
	    sb.append(user.getClient().getNom());
	    sb.append(" - ");
	    sb.append(user.getEmail());
	    sb.append(" - ");
	    sb.append(user.getLastname());
	    sb.append(" - ");
	    sb.append(user.getFirstname());
	    dto.setInfos(sb.toString());
	    dto.setRole(user.getRole());
	    dto.setEmail(user.getEmail());
	    dto.setEnabled(user.isEnabled());
	    dto.setLastname(user.getLastname());
	    dto.setFirstname(user.getFirstname());
	    dto.setPassword(user.getPassword());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDTO> findUsersEnabledAsDTO() {
	Query query = em
		.createQuery("select u from User u where u.enabled='T'");
	List<User> users = query.getResultList();
	List<UserDTO> result = new ArrayList<>(users.size());
	UserDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (User user : users) {
	    dto = new UserDTO();
	    dto.setId(user.getId());
	    sb.append(" - ");
	    sb.append(user.getEmail());
	    sb.append(" - ");
	    sb.append(user.getLastname());
	    sb.append(" - ");
	    sb.append(user.getFirstname());
	    dto.setInfos(sb.toString());
	    dto.setRole(user.getRole());
	    dto.setEmail(user.getEmail());
	    dto.setEnabled(user.isEnabled());
	    dto.setLastname(user.getLastname());
	    dto.setFirstname(user.getFirstname());
	    dto.setPassword(user.getPassword());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }
}
