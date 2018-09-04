package fr.ajcbanque.projetBFI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.Principal;
import fr.ajcbanque.projetBFI.entities.User;
import fr.ajcbanque.projetBFI.repositories.IUserJpaRepository;

@Service
public class LoginService implements ILoginService {
    @Autowired
    private IUserJpaRepository iUserJparRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
	User u = iUserJparRepo.findByEmail(username);
	if (null == u) {
	    throw new UsernameNotFoundException("User Not found : " + username);
	}
	return new Principal(u);
    }
}
