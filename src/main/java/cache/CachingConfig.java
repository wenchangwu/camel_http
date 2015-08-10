package cache;

import net.sf.ehcache.CacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import cache.repository.SpittleDao;
import cache.repository.SpittleDaoImpl;

@Configuration
@EnableCaching
public class CachingConfig {

	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cm){
		return new EhCacheCacheManager(cm);
	}
	
	@Bean
	public EhCacheManagerFactoryBean ecache() {
		EhCacheManagerFactoryBean ehCacheFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheFactoryBean.setConfigLocation(new ClassPathResource(
				"config/ehcache/ehcache.xml"));
		return ehCacheFactoryBean;
	}
	
	@Bean(name="spittleDao")
	public SpittleDao getSpittleDao(){
		return new SpittleDaoImpl();
	}
	
}
