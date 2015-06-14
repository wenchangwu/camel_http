package jpa.dao;

import org.springframework.stereotype.Repository;

import jpa.domain.User;

@Repository(value="userDao")
public class UserDaoImpl extends BaseDao implements UserDao{

	public void saveUser(User user) {
		this.getJpaTemplate().persist(user);
	}

	@Override
	public User getUserById(int id) {
		return this.getJpaTemplate().find(User.class, id);
	}

}
