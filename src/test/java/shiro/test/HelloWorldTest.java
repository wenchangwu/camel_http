package shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testHelloWorld() {
		Factory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = (SecurityManager) factory
				.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wufan", "123");

		try {
			subject.login(token);
			System.out.println("the authorization is sucessed");
		} catch (AuthenticationException e) {
			System.out.println("the authorization is failed");
		}

		subject.logout();

	}

	@Test
	public void testHelloWorld2() {
		Factory factory = new IniSecurityManagerFactory(
				"classpath:shiro_realm.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = (SecurityManager) factory
				.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wufan", "123");

		try {
			subject.login(token);
			System.out.println("the authorization is sucessed");
		} catch (AuthenticationException e) {
			System.out.println("the authorization is failed");
		}

		subject.logout();

	}
	
	@Test
	public void testHasRoles() {
		Factory factory = new IniSecurityManagerFactory(
				"classpath:shiro_role.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = (SecurityManager) factory
				.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wufan", "123");

		try {
			subject.login(token);
			System.out.println("the authorization is sucessed");
			subject.hasRole("role4");
			
		} catch (AuthenticationException e) {
			System.out.println("the authorization is failed");
		}

		subject.logout();

	}
	
	@Test
	public void testPermission() {
		Factory factory = new IniSecurityManagerFactory(
				"classpath:shiro_permission.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = (SecurityManager) factory
				.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wufan", "123");

		try {
			subject.login(token);
			System.out.println("the authorization is sucessed");
			subject.hasRole("role1");
			Assert.assertTrue(subject.isPermitted("user:create"));
			Assert.assertTrue(subject.isPermitted("user:update"));
			
		} catch (AuthenticationException e) {
			System.out.println("the authorization is failed");
		}

		subject.logout();

	}
}