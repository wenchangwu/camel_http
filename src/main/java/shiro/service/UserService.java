package shiro.service;

import java.util.Set;

import shiro.model.User;

public interface UserService {

	public void createUser(User user);
	
	public User fetchUser(int id);
	
	public User fetchUserByUsername(String username);
	
	public void updateUser(User user);
	
	public  Set<String> getRolesByUserName(String username);
	
	public Set<String>  getPermissionByUserName(String username);
	
}
