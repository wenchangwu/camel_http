package jpa.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import jpa.domain.AuthInfo;
import jpa.domain.AuthType;
import jpa.domain.DriverLicense;
import jpa.domain.Employee;
import jpa.domain.ICDLComputerLicense;

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
	public void testLicenseSave(){
		DriverLicense dl=new DriverLicense();
		dl.setDriverLicenseName("driverLicneseName01");
		dl.setDriverLicenseIssueDate(new Date());
		dl.setDriverLicenseExpiryDate(new Date());
		Employee e=new Employee();
		e.setEmployeeName("employee1");
		dl.setEmployee(e);
		userService.save(dl);
	}
	
	@Test
	public void testICDLLicenseSave(){
		ICDLComputerLicense dl=new ICDLComputerLicense();
		dl.setIcdlLicenseDegree("degree01");
		Employee e=new Employee();
		e.setEmployeeName("employee2");
		dl.setEmployee(e);
		
		AuthInfo a=new AuthInfo();
		a.setAuthType(AuthType.EMAIL);
		a.setAuthValue("email");
		
		AuthInfo a1=new AuthInfo();
		a1.setAuthType(AuthType.MOBILE);
		a1.setAuthValue("18817239226");
		
		Map map=new HashMap();
		map.put(AuthType.MOBILE, a1);
		map.put(AuthType.EMAIL, a);
		
		a.setEmployee(e);
		a1.setEmployee(e);
		e.setAuthInfos(map);
		userService.save(dl);
	}
	
}
