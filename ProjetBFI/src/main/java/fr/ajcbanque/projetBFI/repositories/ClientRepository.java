package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.ClientDTO;

@Repository
public class ClientRepository extends BaseRepository
			      implements IClientRepository {
    @SuppressWarnings("unchecked")
    @Override
    public List<ClientDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.projetBFI.dto.ClientDTO(");
	queryBuilder.append(
		"c.id, c.code, c.nom, j.nom, p.codeIso, c.numCompteBancaire, r.coefficientRisque)");
	queryBuilder.append(
		" from Client c join FormeJuridique j join Pays p join RatingInterne r");
	queryBuilder.append(" order by c.nom");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
