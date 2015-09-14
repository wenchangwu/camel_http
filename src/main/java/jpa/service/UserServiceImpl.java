package jpa.service;

import javax.annotation.Resource;

import jpa.dao.TestDao;
import jpa.domain.Employee;
import jpa.domain.License;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Resource
	private TestDao testDao;

	@Override
	@Transactional()
	public void save(License license) {
		testDao.save(license);
	}

	@Override
	public void save(Employee employee) {
		testDao.save(employee);
	}

}
