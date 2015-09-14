package rpc.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rpc.entity.Spittle;
import rpc.service.SpittleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RPCClientConfig.class)
public class RPCSpittleServiceTest {
	
	@Autowired
	@Qualifier("spittleServiceProxy")
	private SpittleService spittleService;
	
	@Autowired
	@Qualifier("httpSpittleServiceProxy")
	private SpittleService httpSpittleServiceProxy;

	@Test
	public void testRMI(){
		Spittle s=spittleService.getSpittle(1);
		System.out.println("========================================"+s.getName());
	}
	
	@Test
	public void testHttpInvoker(){
		Spittle s=httpSpittleServiceProxy.getSpittle(1);
		System.out.println("=================="+s.getName());
	}
}
