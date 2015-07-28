package shiro.dao.imp;

import javax.persistence.Query;

import jpa.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

import shiro.dao.UserDao;
import shiro.model.User;
@Repository(value="userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao  {

	@Override
	public User fetchUserByUsername(String username) {
		String jpql = " select u from User u where u.username=:username";
		
		Query query= this.getEntityManager().createQuery(jpql);
		query.setParameter("username", username);
		return (User) query.getSingleResult();
	}


}
