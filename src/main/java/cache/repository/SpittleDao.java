package cache.repository;

import cache.enitty.Spittle;

public interface SpittleDao {

	public Spittle findOne(int id);	
	
	public Spittle save(Spittle spittle);
}
