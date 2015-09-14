package jpa.service;

import jpa.domain.Employee;
import jpa.domain.License;


public interface UserService {

	public void save(License license);
	
	public void save(Employee employee);
}
