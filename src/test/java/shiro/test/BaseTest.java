package shiro.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;

import shiro.model.Permission;
import shiro.model.Role;
import shiro.model.User;
import shiro.service.UserService;

public abstract class BaseTest {
	
	@Resource
	private UserService userService;
	
	protected String password="123";
	
	
	public void setup(){
		User admin=new User("吴文昌","123");
		User user =new User("吴繁","123");

		
		Role adminRole=new Role("admin","管理员",Boolean.TRUE);
		Role userRole=new Role("user","用户管理员",Boolean.TRUE);
		
		
		
		Set<Role> adminRoles=new HashSet<Role>();
		adminRoles.add(adminRole);
		adminRoles.add(userRole);
		Set<Role> userRoles=new HashSet<Role>();
		userRoles.add(userRole);
		
		Permission permission1=new Permission("user:create","用户模块新增",Boolean.TRUE);
		Permission permission2=new Permission("user:update","用户模块修改",Boolean.TRUE);
		Permission permission3=new Permission("menu:create","菜单模块新增",Boolean.TRUE);
		
		
		Set<Permission> adminPer=new HashSet<Permission>();
		adminPer.add(permission1);
		adminPer.add(permission2);
		adminRole.setPermissions(adminPer);
		
		Set<Permission> userPer=new HashSet<Permission>();
		userPer.add(permission3);
		userRole.setPermissions(userPer);
		
		admin.setRoles(adminRoles);
	
		userService.createUser(admin);
		userService.createUser(user);
		
	}
	
	
	protected void login(String configFile,String username,String password){
		Factory factory = new IniSecurityManagerFactory(configFile);
		org.apache.shiro.mgt.SecurityManager securityManager = (SecurityManager) factory
				.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		subject.login(token);
	}
	
	public Subject subject() {
        return SecurityUtils.getSubject();
    }

}
