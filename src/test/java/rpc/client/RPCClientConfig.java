package rpc.client;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import rpc.service.SpittleService;

/**
 * 
 * @author wenchang.wu
 * @since 2015年8月10日
 *
 */
@Configuration
public class RPCClientConfig {
	
	@Bean(name="spittleServiceProxy")
	public RmiProxyFactoryBean spittleServiceProxy(){
		RmiProxyFactoryBean rmiProxy=new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://10.7.40.81:8089/SpittleService");
		rmiProxy.setServiceInterface(SpittleService.class);
		return rmiProxy;
	}
	

}
