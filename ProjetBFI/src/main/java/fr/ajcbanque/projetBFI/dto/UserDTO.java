package fr.ajcbanque.projetBFI.dto;

public class UserDTO {
    private Long   id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String role;
    public boolean enabled;

    public UserDTO(Long id, String lastname, String firstname, String email,
	    String password, String role, boolean enabled) {
	setId(id);
	setLastname(lastname);
	setFirstname(firstname);
	setEmail(email);
	setPassword(password);
	setRole(role);
	setEnabled(enabled);
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

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }
}
