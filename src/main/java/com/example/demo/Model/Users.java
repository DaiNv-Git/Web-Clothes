package com.example.demo.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String  userName;
private String password;
private String email;
private String address;
private  Boolean enabled;
@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
Set<Roles> roles = new HashSet<>();

public Users() {
	super();
}

public Users(int id, String userName, String password, String email, String address, Boolean enabled,
		Set<Roles> roles) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.address = address;
	this.enabled = enabled;
	this.roles = roles;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<Roles> getRoles() {
	return roles;
}

public void setRoles(Set<Roles> roles) {
	this.roles = roles;
}
}
