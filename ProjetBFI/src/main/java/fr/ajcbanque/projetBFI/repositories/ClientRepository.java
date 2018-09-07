package fr.ajcbanque.projetBFI.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.ClientCreateDTO;
import fr.ajcbanque.projetBFI.dto.ClientDTO;
import fr.ajcbanque.projetBFI.entities.Client;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<ClientCreateDTO> findIdAndInfoCompletAsDTO() {
	Query query = em.createQuery("from Client");
	List<Client> clients = query.getResultList();
	List<ClientCreateDTO> result = new ArrayList<>(clients.size());
	ClientCreateDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (Client client : clients) {
	    dto = new ClientCreateDTO();
	    dto.setId(client.getId());
	    sb.append(client.getCode());
	    sb.append(" - ");
	    sb.append(client.getNom());
	    dto.setInfoComplet(sb.toString());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }
}
