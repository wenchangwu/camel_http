package rpc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import rpc.service.SpittleService;

/**
 * 
 * @author wenchang.wu
 * @since 2015年8月10日
 *
 */
@Configuration
public class RPCConfig {
	
	@Bean
	public RmiServiceExporter rmiExporter(SpittleService spittleService){
		RmiServiceExporter rmiExporter=new RmiServiceExporter();
		rmiExporter.setService(spittleService);
		rmiExporter.setServiceName("SpittleService");
		rmiExporter.setServiceInterface(SpittleService.class);
		rmiExporter.setRegistryPort(8089);
		return rmiExporter;
	}


}
