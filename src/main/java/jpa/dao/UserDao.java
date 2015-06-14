package jpa.dao;

import jpa.domain.User;

public interface UserDao {

	
	public abstract void saveUser(User user);

	public abstract User getUserById(int id);
}
