package com.sargije.ws.hidmet.app.model;
// Generated Jun 14, 2017 10:17:23 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Authorities generated by hbm2java
 */
@Entity
@Table(name = "authorities", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "authority" }))
public class Authorities implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3616732086118168488L;
	private AuthoritiesId id;
	private Users users;

	public Authorities() {
	}

	public Authorities(AuthoritiesId id, Users users) {
		this.id = id;
		this.users = users;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "username", column = @Column(name = "username", nullable = false, length = 50)),
			@AttributeOverride(name = "authority", column = @Column(name = "authority", nullable = false, length = 50)) })
	public AuthoritiesId getId() {
		return this.id;
	}

	public void setId(AuthoritiesId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
