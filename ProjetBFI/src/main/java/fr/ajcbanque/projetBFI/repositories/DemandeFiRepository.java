package fr.ajcbanque.projetBFI.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;

@Repository
public class DemandeFiRepository extends BaseRepository
				 implements IDemandeFiRepository {
    @SuppressWarnings("unchecked")
    @Override
    public List<DemandeFiDTO> findByIdUserAsDTO(AppLanguage lang, Long id) {
	Query query = em.createQuery(
		"select d from DemandeFinancement d where d.user.id=" + id
			+ " order by d.dateDemande DESC");
	List<DemandeFinancement> demandes = query.getResultList();
	List<DemandeFiDTO> result = new ArrayList<>(demandes.size());
	DemandeFiDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (DemandeFinancement demande : demandes) {
	    dto = new DemandeFiDTO();
	    dto.setId(demande.getId());
	    dto.setClient(demande.getUser().getClient().getNom() + " - "
		    + demande.getUser().getFirstname() + " "
		    + demande.getUser().getLastname() + " "
		    + demande.getUser().getEmail());
	    dto.setDateDemande(demande.getDateDemande());
	    dto.setDateEffective(demande.getDateEffective());
	    dto.setDevise(demande.getDevise().getCodeIso());
	    dto.setDuree(demande.getDuree());
	    dto.setMontant(demande.getMontant());
	    dto.setPerfPlus(demande.getPerfPlus());
	    dto.setReference(demande.getReference());
	    dto.setTypeFinancement(demande.getTypeFinancement().getNom());
	    dto.setValidation(demande.isValidation());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DemandeFiDTO> findAllAsDTO(AppLanguage lang) {
	Query query = em.createQuery(
		"select d from DemandeFinancement d order by d.dateDemande DESC");
	List<DemandeFinancement> demandes = query.getResultList();
	List<DemandeFiDTO> result = new ArrayList<>(demandes.size());
	DemandeFiDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (DemandeFinancement demande : demandes) {
	    dto = new DemandeFiDTO();
	    dto.setId(demande.getId());
	    dto.setClient(demande.getUser().getClient().getNom() + " - "
		    + demande.getUser().getFirstname() + " "
		    + demande.getUser().getLastname() + " "
		    + demande.getUser().getEmail());
	    dto.setDateDemande(demande.getDateDemande());
	    dto.setDateEffective(demande.getDateEffective());
	    dto.setDevise(demande.getDevise().getCodeIso());
	    dto.setDuree(demande.getDuree());
	    dto.setMontant(demande.getMontant());
	    dto.setPerfPlus(demande.getPerfPlus());
	    dto.setReference(demande.getReference());
	    dto.setTypeFinancement(demande.getTypeFinancement().getNom());
	    dto.setValidation(demande.isValidation());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DemandeFiDTO> findAllProAsDTO(AppLanguage lang, Long id) {
	Query query = em.createQuery(
		"select d from DemandeFinancement d where d.user IN (select p from User u join u.porteFeuilleClients p where u.id ="
			+ id + ") order by d.dateDemande DESC");
	List<DemandeFinancement> demandes = query.getResultList();
	List<DemandeFiDTO> result = new ArrayList<>(demandes.size());
	DemandeFiDTO dto = null;
	StringBuilder sb = new StringBuilder();
	for (DemandeFinancement demande : demandes) {
	    dto = new DemandeFiDTO();
	    dto.setId(demande.getId());
	    dto.setClient(demande.getUser().getClient().getNom() + " - "
		    + demande.getUser().getFirstname() + " "
		    + demande.getUser().getLastname() + " "
		    + demande.getUser().getEmail());
	    dto.setDateDemande(demande.getDateDemande());
	    dto.setDateEffective(demande.getDateEffective());
	    dto.setDevise(demande.getDevise().getCodeIso());
	    dto.setDuree(demande.getDuree());
	    dto.setMontant(demande.getMontant());
	    dto.setPerfPlus(demande.getPerfPlus());
	    dto.setReference(demande.getReference());
	    dto.setTypeFinancement(demande.getTypeFinancement().getNom());
	    dto.setValidation(demande.isValidation());
	    result.add(dto);
	    sb.setLength(0); // reinitialise à vide le StringBuilder
	}
	return result;
    }
}
