package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DeviseDTO;

@Repository
public class DeviseRepository extends BaseRepository
			      implements IDeviseRepository {
    @SuppressWarnings("unchecked")
    @Override
    public List<DeviseDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.projetBFI.dto.DeviseDTO(d.id, d.codeIso)");
	queryBuilder.append(" from Devise d order by d.codeIso");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
