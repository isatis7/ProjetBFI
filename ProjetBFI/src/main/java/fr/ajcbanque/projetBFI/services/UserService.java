package fr.ajcbanque.projetBFI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.ajcbanque.projetBFI.dto.UserDTO;
import fr.ajcbanque.projetBFI.entities.User;
import fr.ajcbanque.projetBFI.repositories.IUserJpaRepository;
import fr.ajcbanque.projetBFI.repositories.IUserRepository;

@Service
public class UserService implements IUserService {
    private final IUserJpaRepository userJpaRepository;
    private final IUserRepository    userRepository;

    @Autowired
    protected UserService(IUserJpaRepository userJpaRepository,
	    IUserRepository userRepository) {
	this.userRepository = userRepository;
	this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void save(User user) {
	encodePassword(user);
	userJpaRepository.save(user);
    }

    private static void encodePassword(User user) {
	String rawPassword = user.getPassword();
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String encodedPassword = encoder.encode(rawPassword);
	user.setPassword(encodedPassword);
    }

    @Override
    public boolean validateEmail(User user) {
	Long id = user.getId();
	String email = user.getEmail();
	if (null == id) { // create
	    return !userJpaRepository.existsByEmailIgnoreCase(email);
	}
	return !userJpaRepository.existsByEmailIgnoreCaseAndIdNot(email, id); // update
    }

    @Override
    public User findById(Long id) {
	Optional<User> optional = userJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    public List<UserDTO> findAllAsDTO() {
	return userRepository.findAllAsDTO();
    }

    @Override
    public void disable(Long id) {
	Optional<User> optional = userJpaRepository.findById(id);
	User user = optional.get();
	user.setEnabled(false);
	encodePassword(user);
	userJpaRepository.save(user);
    }

    @Override
    public List<UserDTO> findClientsAsDTO() {
	return userRepository.findClientsAsDTO();
    }

    @Override
    public User getOne(Long id) {
	Optional<User> optional = userJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    public List<UserDTO> findUsersEnabledAsDTO() {
	// TODO Auto-generated method stub
	return userRepository.findUsersEnabledAsDTO();
    }
}
