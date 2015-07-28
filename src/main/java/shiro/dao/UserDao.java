package shiro.dao;

import shiro.model.User;
import jpa.dao.BaseDao;


public interface UserDao extends BaseDao<User> {
	
	public User fetchUserByUsername(String username);

}
