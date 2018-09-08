package fr.ajcbanque.projetBFI.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.dto.CollaborateurDTO;
import fr.ajcbanque.projetBFI.entities.Collaborateur;

@Repository
public class CollaborateurRepository implements ICollaborateurRepository {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<CollaborateurDTO> findAllAsDTO() {
	Query query = em.createQuery("from Collaborateur");
	List<Collaborateur> collaborateurs = query.getResultList();
	List<CollaborateurDTO> result = new ArrayList<>(collaborateurs.size());
	CollaborateurDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (Collaborateur collaborateur : collaborateurs) {
	    dto = new CollaborateurDTO();
	    dto.setId(collaborateur.getId());
	    sb.append(collaborateur.getMatriculeInterne());
	    sb.append(" - ");
	    sb.append(collaborateur.getEmail());
	    sb.append(" - ");
	    sb.append(collaborateur.getPrenom());
	    sb.append(" - ");
	    sb.append(collaborateur.getNom());
	    dto.setInfoComplet(sb.toString());
	    dto.setEmail(collaborateur.getEmail());
	    dto.setMatriculeInterne(collaborateur.getMatriculeInterne());
	    dto.setNom(collaborateur.getNom());
	    dto.setPrenom(collaborateur.getEmail());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }

    @Override
    public List<CollaborateurDTO> findCustomCreateUserAsDTO() {
	Query query = em.createQuery(
		"select c from Collaborateur c where c not in (select c from User u join u.collaborateur c where c is not null)");
	List<Collaborateur> collaborateurs = query.getResultList();
	List<CollaborateurDTO> result = new ArrayList<>(collaborateurs.size());
	CollaborateurDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (Collaborateur collaborateur : collaborateurs) {
	    dto = new CollaborateurDTO();
	    dto.setId(collaborateur.getId());
	    sb.append(collaborateur.getMatriculeInterne());
	    sb.append(" - ");
	    sb.append(collaborateur.getEmail());
	    sb.append(" - ");
	    sb.append(collaborateur.getPrenom());
	    sb.append(" - ");
	    sb.append(collaborateur.getNom());
	    dto.setInfoComplet(sb.toString());
	    dto.setEmail(collaborateur.getEmail());
	    dto.setMatriculeInterne(collaborateur.getMatriculeInterne());
	    dto.setNom(collaborateur.getNom());
	    dto.setPrenom(collaborateur.getEmail());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }
}
