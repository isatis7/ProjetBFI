package fr.ajcbanque.projetBFI.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.entities.User;
import fr.ajcbanque.projetBFI.repositories.IUserJpaRepository;

@Service
public class PerfPlusService implements IPerfPlusService {
    private final IPerfPlusJpaRepository perfPlusJpaRepository;

    @Autowired
    protected PerfPlusService(IPerfPlusJpaRepository perfPlusJpaRepository) {
	this.perfPlusJpaRepository = perfPlusJpaRepository;
    }

    @Override
    public void save(PerfPlus perfPlus) {
	perfPlusJpaRepository.save(perfPlus);
    }

    @Override
    public BigDecimal calcul(BigDecimal montant, int duree, CRC crc, CRP crp, ParamA, ParamB) {
	Long id = user.getId();
	String email = user.getEmail();
	if (null == id) { // create
	    return !userJpaRepository.existsByEmailIgnoreCase(email);
	}
	return !userJpaRepository.existsByEmailIgnoreCaseAndIdNot(email, id); // update
    }


}
