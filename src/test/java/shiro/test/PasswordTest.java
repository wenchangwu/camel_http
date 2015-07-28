package shiro.test;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import shiro.model.User;

public class PasswordTest extends BaseTest {

	@Test
	public void testPasswordServiceWithMyRealm() {
        login("classpath:shiro_passwordservice.ini", "wu", "123");
    }
	
	
	@Test
    public void testGeneratePassword() {
        String algorithmName = "md5";
        String username = "liu";
        String password = "123";
        String salt1 = username;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;

        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();
        System.out.println(salt2);
        System.out.println(encodedPassword);
    }

    @Test
    public void testHashedCredentialsMatcherWithMyRealm2() {
        //使用testGeneratePassword生成的散列密码
        login("classpath:shiro-hashedCredentialsMatcher.ini", "liu", "123");
    }
	
    @Test
    public void princialCollectionTest(){
    	 //因为Realm里没有进行验证，所以相当于每个Realm都身份验证成功了
        login("classpath:shiro-multirealm.ini", "zhang", "123");
        Subject subject = subject();
        //获取Primary Principal（即第一个）
        Object primaryPrincipal1 = subject.getPrincipal();
        PrincipalCollection princialCollection = subject.getPrincipals();
        Object primaryPrincipal2 = princialCollection.getPrimaryPrincipal();

        //但是因为多个Realm都返回了Principal，所以此处到底是哪个是不确定的
        Assert.assertEquals(primaryPrincipal1, primaryPrincipal2);


        //返回 a b c
        Set<String> realmNames = princialCollection.getRealmNames();
        System.out.println(realmNames);

        //因为MyRealm1和MyRealm2返回的凭据都是zhang，所以排重了
        Set<Object> principals = princialCollection.asSet(); //asList和asSet的结果一样
        System.out.println(principals);

        //根据Realm名字获取
        Collection<User> users = princialCollection.fromRealm("c");
        System.out.println(users);
    }
    
    
	 @Test(expected = ExcessiveAttemptsException.class)
	    public void testRetryLimitHashedCredentialsMatcherWithMyRealm() {
	        for(int i = 1; i <= 4; i++) {
	            try {
	                login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "234");
	            } catch (Exception e) {/*ignore*/}
	        }
	        login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "123");
	    }
}
