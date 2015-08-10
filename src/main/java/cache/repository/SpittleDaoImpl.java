package cache.repository;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import cache.enitty.Spittle;

public class SpittleDaoImpl implements SpittleDao {

	@Override
	@Cacheable("spittleCache")
	public Spittle findOne(int id) {
		System.out.println("========================================="+"first time");
		Spittle s = new Spittle();
		s.setId(1);
		s.setName("========================================="+"this is just a demo");
		return s;
	}

	@Override
	@CachePut(value="spittleCache",key="#result.id")
	public Spittle save(Spittle spittle) {
		System.out.println("========================================="+"save the spittle");
		return spittle;
	}

}
