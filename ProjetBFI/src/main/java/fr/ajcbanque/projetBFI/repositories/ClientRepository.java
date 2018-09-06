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
		"select new fr.ajcbanque.ProjetBFI.dto.ClientDTO(");
	queryBuilder.append(
		"c.id, c.code, c.nom, c.formeJuridique, c.pays, c.numCompteBancaire, c.ratingInterne)");
	queryBuilder.append(" from Client c");
	queryBuilder.append(" order by c.nom");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
