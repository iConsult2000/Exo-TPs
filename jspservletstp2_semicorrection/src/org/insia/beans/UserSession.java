package org.insia.beans;

import java.io.Serializable;

import org.insia.models.User;

public class UserSession implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private User userLogged;

	public User getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(User userLogged) {
		this.userLogged = userLogged;
	}
	
	public boolean isConnected() {
		return userLogged != null;
	}
}
