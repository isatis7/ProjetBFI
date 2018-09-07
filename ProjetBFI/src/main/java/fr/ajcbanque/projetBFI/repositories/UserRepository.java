package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.UserDTO;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository {
    @SuppressWarnings("unchecked")
    @Override
    public List<UserDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.projetBFI.dto.UserDTO(");
	queryBuilder.append(
		"u.id, u.lastname, u.firstname, u.email, u.password,  u.role, u.enabled)");
	queryBuilder.append(" from User u where u.enabled='T'");
	queryBuilder.append(" order by u.id");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
