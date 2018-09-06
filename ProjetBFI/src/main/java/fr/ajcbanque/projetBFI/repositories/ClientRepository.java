package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.ClientDTO;

public class ClientRepository extends BaseRepository
			      implements IClientRepository {
    @Override
    public List<ClientDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.formation.lamarmite.dto.CourseDTO(c.id, c.code, c.price, c.");
	String nameCol = "frenchName as courseName, t.";
	String typeNameCol = "frenchName";
	if (lang.isEnglish()) {
	    nameCol = "englishName as courseName, t.";
	    typeNameCol = "englishName";
	}
	queryBuilder.append(nameCol);
	queryBuilder.append(typeNameCol);
	queryBuilder.append(") from Course c join c.type t");
	queryBuilder.append(" order by t.code, courseName");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
    }
}
