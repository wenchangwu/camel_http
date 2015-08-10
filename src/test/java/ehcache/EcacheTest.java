package ehcache;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cache.CachingConfig;
import cache.enitty.Spittle;
import cache.repository.SpittleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CachingConfig.class)
public class EcacheTest {
	
	@Resource
	private SpittleDao spittleDao;
	
	@Test
	public void cacheTest() {
		spittleDao.findOne(1);
		System.out.println("this is just a demo");
		spittleDao.findOne(1);
	}
	
	@Test
	public void cacheTest2(){
		Spittle s=new Spittle();
		s.setId(1);
		s.setName("just a demo");
		spittleDao.save(s);
		Spittle s2=spittleDao.findOne(2);
		System.out.println("========================================="+s2.getName());
	}
}
