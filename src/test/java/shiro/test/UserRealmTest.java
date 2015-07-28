package shiro.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/applicationcontex.xml" })

public class UserRealmTest extends BaseTest{
	
	@Test
	public void testLoginSuccess(){
		  //setup();
		  login("classpath:shiro.ini", "吴文昌", password);
		  Assert.assertTrue(subject().isAuthenticated());
	}

}
