package fr.ajcbanque.projetBFI.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;

@Repository
public class DemandeFiRepository extends BaseRepository
				 implements IDemandeFiRepository {
    @SuppressWarnings("unchecked")
    @Override
    public List<DemandeFiDTO> findAllAsClientDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.projetBFI.dto.DemandeFiDTO(");
	queryBuilder.append(
		"d.id, d.client.nom, d.dateDemande, d.reference, d.duree, d.dateEffective, d.montant, d.devise.codeIso, d.typeFinancement.nom)");
	queryBuilder.append(" from DemandeFinancement d");
	queryBuilder.append(" order by d.dateDemande");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DemandeFiDTO> findAllAsProDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.projetBFI.dto.DemandeFiDTO(");
	queryBuilder.append(
		"d.id, d.client.nom, d.dateDemande, d.reference, d.duree, d.dateEffective, d.montant, d.devise.codeIso, d.typeFinancement.nom, d.perfPlus, d.validation)");
	queryBuilder.append(" from DemandeFinancement d");
	queryBuilder.append(" order by d.dateDemande");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
