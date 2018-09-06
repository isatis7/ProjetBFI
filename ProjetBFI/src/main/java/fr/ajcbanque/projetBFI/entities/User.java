package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID	    = 1800900843909976847L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 50, nullable = false)
    private String	      lastname;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 50, nullable = false)
    private String	      firstname;
    @NotNull(message = "{error.commons.required}")
    @Email(message = "{error.commons.email}")
    @Column(length = 255, nullable = false, unique = true)
    private String	      email;
    @NotNull(message = "{error.commons.required}")
    @Column(length = 100, nullable = false)
    private String	      password;
    @NotNull(message = "{error.commons.required}")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Role	      role;
    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    public boolean	      accountNonExpired	    = true;
    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    public boolean	      accountNonLocked	    = true;
    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    public boolean	      credentialsNonExpired = true;
    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    public boolean	      enabled		    = true;
    private Client	      client;
    private Collaborateur     collaborateur;
    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean	      verrouillageCompte    = false;

    public User() {
	//
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

    public boolean isAccountNonExpired() {
	return accountNonExpired;
    }

    public void setAccountNonExpired(boolean flag) {
	accountNonExpired = flag;
    }

    public boolean isAccountNonLocked() {
	return accountNonLocked;
    }

    public void setAccountNonLocked(boolean flag) {
	accountNonLocked = flag;
    }

    public boolean isCredentialsNonExpired() {
	return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean flag) {
	credentialsNonExpired = flag;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean flag) {
	enabled = flag;
    }

    public Client getClient() {
	return client;
    }

    public void setClient(Client client) {
	this.client = client;
    }

    public Collaborateur getCollaborateur() {
	return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
	this.collaborateur = collaborateur;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (accountNonExpired ? 1231 : 1237);
	result = prime * result + (accountNonLocked ? 1231 : 1237);
	result = prime * result + ((client == null) ? 0 : client.hashCode());
	result = prime * result
		+ ((collaborateur == null) ? 0 : collaborateur.hashCode());
	result = prime * result + (credentialsNonExpired ? 1231 : 1237);
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + (enabled ? 1231 : 1237);
	result = prime * result
		+ ((firstname == null) ? 0 : firstname.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result
		+ ((lastname == null) ? 0 : lastname.hashCode());
	result = prime * result
		+ ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	User other = (User) obj;
	if (accountNonExpired != other.accountNonExpired) {
	    return false;
	}
	if (accountNonLocked != other.accountNonLocked) {
	    return false;
	}
	if (client == null) {
	    if (other.client != null) {
		return false;
	    }
	} else if (!client.equals(other.client)) {
	    return false;
	}
	if (collaborateur == null) {
	    if (other.collaborateur != null) {
		return false;
	    }
	} else if (!collaborateur.equals(other.collaborateur)) {
	    return false;
	}
	if (credentialsNonExpired != other.credentialsNonExpired) {
	    return false;
	}
	if (email == null) {
	    if (other.email != null) {
		return false;
	    }
	} else if (!email.equals(other.email)) {
	    return false;
	}
	if (enabled != other.enabled) {
	    return false;
	}
	if (firstname == null) {
	    if (other.firstname != null) {
		return false;
	    }
	} else if (!firstname.equals(other.firstname)) {
	    return false;
	}
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (lastname == null) {
	    if (other.lastname != null) {
		return false;
	    }
	} else if (!lastname.equals(other.lastname)) {
	    return false;
	}
	if (password == null) {
	    if (other.password != null) {
		return false;
	    }
	} else if (!password.equals(other.password)) {
	    return false;
	}
	if (role != other.role) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", lastname=" + lastname + ", firstname="
		+ firstname + ", email=" + email + ", password=" + password
		+ ", role=" + role + ", accountNonExpired=" + accountNonExpired
		+ ", accountNonLocked=" + accountNonLocked
		+ ", credentialsNonExpired=" + credentialsNonExpired
		+ ", enabled=" + enabled + ", client=" + client
		+ ", collaborateur=" + collaborateur + "]";
    }

    public static enum Role {
	ROLE_USER_CLIENT, ROLE_USER_PRO, ROLE_ADMIN, ROLE_PO;
	public boolean isAdmin() {
	    return this == ROLE_ADMIN;
	}

	public boolean isClient() {
	    return this == ROLE_USER_CLIENT;
	}

	public boolean isPro() {
	    return this == ROLE_USER_PRO;
	}

	public boolean isPO() {
	    return this == ROLE_PO;
	}

	public String getName() {
	    return name();
	}
    }
}
