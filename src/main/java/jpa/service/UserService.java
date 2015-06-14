package jpa.service;

import jpa.domain.User;

public interface UserService {

	public abstract void saveUser(User user);
	
	public abstract User getUserById(int id);
}
