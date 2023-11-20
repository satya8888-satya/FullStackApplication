package com.FullStack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class New_User {
@Id
@GeneratedValue
private Long id;
private String username;
private String name;
private String email;

public New_User() {
	super();
}

public New_User(Long id, String username, String name, String email) {
	super();
	this.id = id;
	this.username = username;
	this.name = name;
	this.email = email;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "New_User [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + "]";
}



}
