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
		"select new fr.ajcbanque.ProjetBFI.dto.DemandeFiDTO(");
	queryBuilder.append(
		"d.id, c.nom, d.dateDemande, d.reference, d.duree, d.dateEffective, d.montant, e.codeIso, t.nom)");
	queryBuilder.append(
		" from DemandeFinancement d join Client c join Devise e join TypeFinancement t");
	queryBuilder.append(" order by d.dateDemande");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DemandeFiDTO> findAllAsProDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new fr.ajcbanque.ProjetBFI.dto.DemandeFiDTO(");
	queryBuilder.append(
		"d.id, c.nom, d.dateDemande, d.reference, d.duree, d.dateEffective, d.montant, e.codeIso, t.nom, d.perfPlus, d.validation)");
	queryBuilder.append(
		" from DemandeFinancement d join Client c join Devise e join TypeFinancement t");
	queryBuilder.append(" order by d.dateDemande");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
