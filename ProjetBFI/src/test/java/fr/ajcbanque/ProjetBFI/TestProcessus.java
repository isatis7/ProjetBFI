package fr.ajcbanque.ProjetBFI;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.ajcbanque.projetBFI.WebConfig;
import fr.ajcbanque.projetBFI.entities.Client;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;
import fr.ajcbanque.projetBFI.entities.Devise;
import fr.ajcbanque.projetBFI.entities.FormeJuridique;
import fr.ajcbanque.projetBFI.entities.Pays;
import fr.ajcbanque.projetBFI.entities.RatingInterne;
import fr.ajcbanque.projetBFI.entities.TypeFinancement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class })
@Transactional
public class TestProcessus {
    @Test
    public static void main(String[] args) {
	Client client = new Client();
	Pays pays = new Pays();
	RatingInterne ratingInternePays = new RatingInterne();
	RatingInterne ratingInterneClient = new RatingInterne();
	FormeJuridique formeJuridique = new FormeJuridique();
	Devise devise = new Devise();
	TypeFinancement typeFinancement = new TypeFinancement();
	DemandeFinancement demandeFi = new DemandeFinancement();
	LocalDate dateDemande = LocalDate.of(2017, 01, 15);
	LocalDate dateEffective = LocalDate.of(2018, 12, 31);
	/*
	 *
	 *
	 * ratingInternePays.getCode();
	 * ratingInternePays.setCoefficientRisque(1f);
	 * ratingInterneClient.setCode("X");
	 * ratingInterneClient.setCoefficientRisque(1f);
	 *
	 * formeJuridique.setNom("Watir");
	 *
	 * pays.setCodeIso("Tes"); pays.setRatingInterne(ratingInternePays);
	 *
	 * client.setPays(pays); client.setCode("testwatir");
	 * client.setFormeJuridique(formeJuridique); client.setNom("Watir");
	 * client.setNumCompteBancaire("1689784279584523010025");
	 * client.setRatingInterne(ratingInterneClient);
	 *
	 * devise.setCodeIso("zen");
	 *
	 * typeFinancement.setNom("Test");
	 */
	demandeFi.setClient(client.findById(1));
	demandeFi.setDateDemande(dateDemande);
	demandeFi.setDateEffective(dateEffective);
	demandeFi.setDevise(devise);
	demandeFi.setDuree(36f);
	demandeFi.setMontant(10000f);
	demandeFi.setPerfPlus(new BigDecimal(1));
	demandeFi.setReference("WatirWatir");
	demandeFi.setTypeFinancement(typeFinancement);
	typeFinancement.save();
	System.out.println(demandeFi.toString());
    }
}
