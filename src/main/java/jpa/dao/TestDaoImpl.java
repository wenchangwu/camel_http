package jpa.dao;

import jpa.domain.Employee;
import jpa.domain.License;

import org.springframework.stereotype.Repository;

@Repository(value="testDao")
public class TestDaoImpl extends BaseDaoImpl implements TestDao{

	@Override
	public void save(License license){
		super.getEntityManager().persist(license);
	}
	
	public void save(Employee e){
		super.getEntityManager().persist(e);
	}


}
