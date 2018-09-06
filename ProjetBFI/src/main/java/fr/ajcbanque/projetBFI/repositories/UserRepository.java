package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.UserDTO;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository {
    // méthode à revoir après modif User.java
    @SuppressWarnings("unchecked")
    @Override
    public List<UserDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.ProjetBFI.dto.UserDTO(");
	queryBuilder.append(
		"u.id, u.nom, d.dateDemande, d.reference, d.duree, d.dateEffective, d.montant, e.codeIso, t.nom)");
	queryBuilder.append(
		" from DemandeFinancement d join Client c join Devise e join TypeFinancement t");
	queryBuilder.append(" order by d.dateDemande");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
