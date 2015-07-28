package shiro.test;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shiro.model.Permission;
import shiro.model.Role;
import shiro.model.User;
import shiro.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/applicationcontex.xml" })

public class UserServiceTest {
	
	@Resource
	private UserService userService;
	
	@Test
	public void testCreateUser(){
		User user=new User();
		user.setUsername("吴文琴");
		user.setPassword("123");
		Role role=new Role();
		role.setRole("role2");
		role.setDescription("role2 description");
		
		Role role2=new Role();
		role2.setRole("role3");
		role2.setDescription("role3 description");
		Permission permission=new Permission();
		permission.setPermission("permission3");
		permission.setDescription("permission3 test");
		
		Permission permissio2=new Permission();
		permissio2.setPermission("permission2");
		permissio2.setDescription("permission2 test");
		
		Set<Permission> permissions=new HashSet<Permission>();
		permissions.add(permission);
		permissions.add(permissio2);
		role.setPermissions(permissions);
		Set<Role> roles=new HashSet<Role>();
		roles.add(role);
		roles.add(role2);
		user.setRoles(roles);
		userService.createUser(user);
		
	}
	
	@Test
	public void testFetchUserByUsername(){
		User u=userService.fetchUserByUsername("吴文昌");
		System.out.println(u);
	}

}
