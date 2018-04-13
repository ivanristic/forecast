package com.sargije.ws.hidmet.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRoles {
	
	@Id
	@GeneratedValue
	@Column(name="ur_id")
	private Long userRoleId;
	
	@Column(name="ur_role")
	private String userRole;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ur_u_id", referencedColumnName="u_id")
	private Users userId;

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}
	
}
