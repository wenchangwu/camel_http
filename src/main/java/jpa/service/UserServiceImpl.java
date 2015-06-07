package jpa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpa.dao.UserDao;
import jpa.domain.User;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Transactional
	public void saveUser(User user) {
		this.userDao.saveUser(user);
	}

}
