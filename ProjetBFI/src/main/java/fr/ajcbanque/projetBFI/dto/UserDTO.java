package fr.ajcbanque.projetBFI.dto;

import fr.ajcbanque.projetBFI.entities.User.Role;

public class UserDTO {
    private Long   id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private Role   role;
    public boolean enabled;
    private String infos;

    public UserDTO() {
	//
    }

    public UserDTO(Long id, String lastname, String firstname, String email,
	    String password, Role role, Boolean enabled, String infos) {
	setId(id);
	setLastname(lastname);
	setFirstname(firstname);
	setEmail(email);
	setPassword(password);
	setRole(role);
	setEnabled(enabled);
	setInfos(infos);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public String getInfos() {
	return infos;
    }

    public void setInfos(String infos) {
	this.infos = infos;
    }
}
