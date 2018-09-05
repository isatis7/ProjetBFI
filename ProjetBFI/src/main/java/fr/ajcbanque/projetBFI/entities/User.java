package fr.ajcbanque.projetBFI.entities;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof User)) {
	    return false;
	}
	User other = (User) obj;
	return email.equals(other.email);
    }

    @Override
    public int hashCode() {
	return Objects.hash(email);
    }

    @Override
    public String toString() {
	return "{id=" + id + ", lastname=" + lastname + ", firstname="
		+ firstname + ", email=" + email + ", password=[SECRET], role="
		+ role + ", accountNonExpired=" + accountNonExpired
		+ ", accountNonLocked=" + accountNonLocked
		+ ", credentialsNonExpired=" + credentialsNonExpired
		+ ", enabled=" + enabled + "}";
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
