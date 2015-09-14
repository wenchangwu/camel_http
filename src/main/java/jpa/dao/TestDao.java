package jpa.dao;

import jpa.domain.Employee;
import jpa.domain.License;


public interface TestDao {

	public void save(License license);
	
	public void save(Employee e);

}
