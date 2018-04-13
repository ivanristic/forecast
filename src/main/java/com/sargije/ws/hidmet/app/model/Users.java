package com.sargije.ws.hidmet.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue
	@Column(name="u_id")
	private Long userId;
	
	@Column(name="u_username")
	private String userName;
	
	@Column(name="u_password")
	private String password;

	@Column(name="u_active")
	private boolean active;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="userId")
	private Set<UserRoles> userRole = new HashSet<UserRoles>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<UserRoles> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRoles> userRole) {
		this.userRole = userRole;
	}

}
