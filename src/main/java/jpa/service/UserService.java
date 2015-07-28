package jpa.service;

import jpa.domain.Address;
import jpa.domain.Employee;
import jpa.domain.Husband;
import jpa.domain.User;

public interface UserService {

	public abstract void saveUser(User user);
	
	public abstract User getUserById(int id);
	
	public abstract void saveEmployee(Employee employee);
	
	public abstract Address saveAddress(Address address);
	
	public abstract void saveHusband(Husband hustand);
	
	public abstract Husband getHusband(int id);
	
	public abstract void deleteHusband(int id);
}
