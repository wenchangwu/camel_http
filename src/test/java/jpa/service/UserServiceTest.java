package jpa.service;

import javax.annotation.Resource;

import jpa.domain.User;

import org.hibernate.envers.Audited;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
}
