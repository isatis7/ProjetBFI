package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.TypeFinancementDTO;

@Repository
public class TypeFinancementRepository extends BaseRepository
				       implements ITypeFinancementRepository {
    @SuppressWarnings("unchecked")
    @Override
    public List<TypeFinancementDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.projetBFI.dto.TypeFinancementDTO(t.id, t.nom)");
	queryBuilder.append(" from TypeFinancement t order by t.nom");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
