package jpa.service;

import javax.annotation.Resource;

import jpa.domain.Address;
import jpa.domain.FTEmployee;
import jpa.domain.Husband;
import jpa.domain.User;
import jpa.domain.Wife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/applicationcontex.xml" })

public class UserServiceTest {
	
	@Resource
	private UserService userService;

	@Test
	public void testUserSave(){
		User u=new User();
		u.setUserName("吴繁");
		userService.saveUser(u);
	}
	
	@Test
	public void testGetUser(){
		User u1=userService.getUserById(1);
		User u2=userService.getUserById(2);
		
		System.out.println(u1.getRealNameAuthStatus().getStatus());
		System.out.println(u2.getRealNameAuthStatus().getStatus());	
	}
	
	@Test
	public void testEmployee(){
		FTEmployee emp=new FTEmployee();
		Address address=new Address();
		address.setAddress("安徽省安庆市");
		Address a=userService.saveAddress(address);
		emp.setAddress(a);
		emp.setSalary(1500);
		userService.saveEmployee(emp);
	}
	
	@Test
	public void testHusWife(){
		Husband hus=new Husband();
		hus.setName("吴文昌");
		Wife w=new Wife();
		w.setName("吴繁");
		w.setHusband(hus);
		hus.setWife(w);
		userService.saveHusband(hus);
	}
	
	@Test
	public void testDelHus(){
		userService.deleteHusband(8);
	}
}
