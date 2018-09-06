package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.UserDTO;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository {
    // méthode à revoir après modif User.java (requête à revoir)
    @SuppressWarnings("unchecked")
    @Override
    public List<UserDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.ProjetBFI.dto.UserDTO(");
	queryBuilder.append(
		"u.id, u.email, u.enabled, u.firstname, u.lastname, u.password, u.role)");
	queryBuilder.append(" from User u");
	queryBuilder.append(" order by u.id");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
