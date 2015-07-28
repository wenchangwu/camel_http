package jpa.dao;

import org.springframework.stereotype.Repository;

import jpa.domain.Address;
import jpa.domain.Employee;
import jpa.domain.Husband;
import jpa.domain.User;

@Repository(value="userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public void saveUser(User user) {
		this.getEntityManager().persist(user);
	}

	@Override
	public User getUserById(int id) {
		return this.getEntityManager().find(User.class, id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.getEntityManager().persist(employee);
	}

	@Override
	public Address saveAddress(Address address) {
		this.getEntityManager().persist(address);
		return (Address) this.getEntityManager().find(null, "select a from Address a where a.id="+"1");
	}

	@Override
	public void saveHusband(Husband husband) {
		this.getEntityManager().persist(husband);
		
	}

	@Override
	public Husband getHusband(int id) {
		return this.getEntityManager().find(Husband.class, id);
	}

	@Override
	public void deleteHusband(int id) {
		Husband hus=this.getEntityManager().find(Husband.class, id);
		this.getEntityManager().remove(hus);
		
	}

}
