package jpa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpa.dao.UserDao;
import jpa.domain.Address;
import jpa.domain.Employee;
import jpa.domain.Husband;
import jpa.domain.User;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Transactional
	public void saveUser(User user) {
		this.userDao.saveUser(user);
		user.setUserName("wenchang");
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		userDao.saveEmployee(employee);
		
	}

	@Override
	@Transactional
	public Address saveAddress(Address address) {
		return userDao.saveAddress(address);
	}

	@Override
	@Transactional
	public void saveHusband(Husband husband) {
		userDao.saveHusband(husband);
		
	}

	@Override
	@Transactional
	public Husband getHusband(int id) {
		return userDao.getHusband(id);
	}

	@Override
	@Transactional
	public void deleteHusband(int id) {
		userDao.deleteHusband(id);
	}

}
