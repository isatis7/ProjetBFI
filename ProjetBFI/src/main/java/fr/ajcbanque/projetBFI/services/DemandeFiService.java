package fr.ajcbanque.projetBFI.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.AppLanguage;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;
import fr.ajcbanque.projetBFI.entities.Client;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;
import fr.ajcbanque.projetBFI.entities.Parametres;
import fr.ajcbanque.projetBFI.repositories.IClientJpaRepository;
import fr.ajcbanque.projetBFI.repositories.IDemandeFiJpaRepository;
import fr.ajcbanque.projetBFI.repositories.IDemandeFiRepository;
import fr.ajcbanque.projetBFI.repositories.IParametresJpaRepository;

@Service
public class DemandeFiService implements IDemandeFiService {
    private final IDemandeFiRepository	   demandeFiRepository;
    private final IDemandeFiJpaRepository  demandeFiJpaRepository;
    private final IClientJpaRepository	   clientJpaRepository;
    private final IParametresJpaRepository parametresJpaRepository;

    @Autowired
    protected DemandeFiService(IDemandeFiRepository demandeFiRepository,
	    IDemandeFiJpaRepository demandeFiJpaRepository,
	    IClientJpaRepository clientJpaRepository,
	    IParametresJpaRepository parametresJpaRepository) {
	this.demandeFiRepository = demandeFiRepository;
	this.demandeFiJpaRepository = demandeFiJpaRepository;
	this.clientJpaRepository = clientJpaRepository;
	this.parametresJpaRepository = parametresJpaRepository;
    }

    @Override
    public DemandeFinancement findById(Long id) {
	Optional<DemandeFinancement> optional = demandeFiJpaRepository
		.findById(id);
	return optional.get();
    }

    @Override
    public boolean validateReference(DemandeFinancement demandeFi) {
	Long id = demandeFi.getId();
	String reference = demandeFi.getReference();
	if (null == id) {
	    return !demandeFiJpaRepository
		    .existsByReferenceIgnoreCase(reference);
	}
	return !demandeFiJpaRepository
		.existsByReferenceIgnoreCaseAndIdNot(reference, id);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_CLIENT', 'ROLE_ADMIN')")
    @Override
    public void save(DemandeFinancement demandeFi) {
	Long clientId = demandeFi.getClient().getId();
	Optional<Client> optionalClient = clientJpaRepository
		.findById(clientId);
	Client client = optionalClient.get();
	Optional<Parametres> optionalParam = parametresJpaRepository
		.findById(1L);
	Parametres param = optionalParam.get();
	BigDecimal perfPlus = calculPerfPlus(demandeFi, param, client);
	demandeFi.setPerfPlus(perfPlus);
	demandeFiJpaRepository.save(demandeFi);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_CLIENT', 'ROLE_ADMIN')")
    @Override
    public void deleteById(Long id) {
	demandeFiJpaRepository.deleteById(id);
    }

    @Override
    public List<DemandeFiDTO> findAllAsClientDTO(AppLanguage lang) {
	return demandeFiRepository.findAllAsClientDTO(lang);
    }

    @Override
    public List<DemandeFiDTO> findAllAsProDTO(AppLanguage lang) {
	return demandeFiRepository.findAllAsProDTO(lang);
    }

    @Override
    public List<DemandeFiDTO> findAllAsDTO(AppLanguage lang) {
	return demandeFiRepository.findAllAsClientDTO(lang);
    }

    private BigDecimal calculPerfPlus(DemandeFinancement demandeFi,
	    Parametres param, Client client) {
	BigDecimal mf = demandeFi.getMontant();
	BigDecimal df = demandeFi.getDuree();
	BigDecimal crp = client.getPays().getRatingInterne()
		.getCoefficientRisque();
	BigDecimal crc = client.getRatingInterne().getCoefficientRisque();
	BigDecimal perf = BigDecimal.valueOf(0);
	BigDecimal a = param.getParamA();
	BigDecimal b = param.getParamB();
	BigDecimal t = BigDecimal.valueOf(10000);
	BigDecimal u = mf.divide(df);// (mf/df)
	BigDecimal v = mf.multiply(crc);// (mf*crc)
	BigDecimal w = mf.multiply(crp);// (mf*crp)
	BigDecimal x = b.divide(a);// (b/a)
	BigDecimal y = mf.multiply(x);// (mf*(x))
	BigDecimal z = u.add(v.add(w).add(y));// (u)+(v)+(w)+(y)
	perf = z.divide(t, 3);// 10000
	return perf;
    }
}
